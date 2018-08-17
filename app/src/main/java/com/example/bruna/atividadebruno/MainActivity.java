package com.example.bruna.atividadebruno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bruna.atividadebruno.bancodedados.BDListaClientes;
import com.example.bruna.atividadebruno.modal.Cliente;

public class MainActivity extends AppCompatActivity {

    private String[] hints;
    private String[] tags;
    public static BDListaClientes listaClientes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaClientes = new BDListaClientes();
        hints = getResources().getStringArray( R.array.hints );
        tags= getResources().getStringArray(R.array.tags);

        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById( R.id.linear_Layout);

        for (int i = 0; i <hints.length; i++){
            EditText editText = new EditText(this);
            editText.setId(i);
            editText.setHint(hints[i]);
            editText.setTag(tags[i]);
            linearLayout.addView( editText );
        }

        final int childCount = linearLayout.getChildCount();


       Button btEnviar = new Button(this);
       btEnviar.setText("Enviar");
       btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout linearLayoutFirst = findViewById(R.id.linear_Layout);
                linearLayoutFirst.setVisibility(View.GONE);

                LinearLayout linearLayoutResultado = findViewById(R.id.linearResultado);
                linearLayoutResultado.setVisibility(View.VISIBLE);

                String resultado = "";

                Cliente cliente = new Cliente();

                for(int i = 0 ; i < hints.length; i++){
                    EditText editText = findViewById(i);

                    if(!TextUtils.isEmpty(editText.getText().toString())){
                        resultado += editText.getText().toString() + "\n";
                        cliente.setarCampo(editText.getTag().toString(),editText.getText().toString());
                        editText.setText("");
                    }
                }

                listaClientes.inserirCliente(cliente);

                ((TextView) findViewById(R.id.textViewResultado)).setText(resultado);

            }
       });

        ((Button)findViewById(R.id.btClientes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Cliente.class);
                startActivity(it);
            }
        });

        ((Button)findViewById(R.id.btVoltar)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LinearLayout linearLayoutFirst = findViewById(R.id.linear_Layout);
                linearLayoutFirst.setVisibility(View.VISIBLE);

                LinearLayout linearLayoutResultado = findViewById(R.id.linearResultado);
                linearLayoutResultado.setVisibility(View.GONE);
            }
        });

        linearLayout.addView(btEnviar);
    }
}
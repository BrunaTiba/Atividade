package com.example.bruna.atividadebruno.servidor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bruna.atividadebruno.R;
import com.example.bruna.atividadebruno.bancodedados.BDListaClientes;
import com.example.bruna.atividadebruno.modal.Cliente;
import com.example.bruna.atividadebruno.modal.ConfigurarCampo;
import com.example.bruna.atividadebruno.modal.Contato;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] hints;
    private String[] tags;
    public static BDListaClientes listaClientes;
    private String dados = "[{\"nome\": \"Bruna\",  \"sobrenome\": \"Spinola Tiba\",  \"datadenascimento\": \"16/05/1997\",  \"cidade\": \"São Paulo\", \"id\":\"01\"}, \\n  \\n{\"nome\": \"Thiago\",  \"sobrenome\": \"Brava\",  \"datadenascimento\": \"16/05/1982\",  \"cidade\": \"Goiania\", \"id\": \"02\"},   \\n  \\n  {\"nome\": \"Fulana\",  \"sobrenome\": \"Silva\",  \"datadenascimento\": \"20/12/1997\",  \"cidade\": \"Rio de Janeiro\", \"id\":\"03\"}, \\n \\n  {\"nome\": \"Steve\",  \"sobrenome\": \"Seven\",  \"datadenascimento\": \"17/07/1977\",  \"cidade\": \"Espirito Santo\",   \"id\": \"04\"},   \\n  \\n  {\"nome\": \"Primeiro\",  \"sobrenome\": \"First\",  \"datadenascimento\": \"01/01/2001\",  \"cidade\": \"São Paulo\",   \"id\": \"05}]";


    public List<ConfigurarCampo> campos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        List<Contato> contatos = gson.fromJson(dados,new TypeToken<List<Contato>>(){}.getType());
        LinearLayout linearLayout = findViewById(R.id.linear_Layout);


        //listaClientes = new BDListaClientes();
       // hints = getResources().getStringArray(R.array.hints);
       // tags = getResources().getStringArray(R.array.tags);

       // setContentView(R.layout.activity_main);



        for (Contato contato : contatos) {

            TextView editText = new TextView (this);
            TextView textView = new TextView (this);

            editText.setText(contato.getNome());
            textView.setText(contato.getSobrenome());
            linearLayout.addView(editText);
            linearLayout.addView(textView);

           //EditText editText = new EditText(this);
           // editText.setId(i);
           // editText.setHint(hints[i]);
           // editText.setTag(tags[i]);
           // linearLayout.addView(editText);
        }

        listaClientes = new BDListaClientes();

        inicializarArr();

        for (ConfigurarCampo configurarCampo : campos) {
            EditText editText = new EditText (this);
            editText.setId(configurarCampo.getId());
            editText.setHint(configurarCampo.getHint());
            editText.setTag(configurarCampo.getTag());

            linearLayout.addView(editText);
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

                for (int i = 0; i < hints.length; i++) {
                    EditText editText = findViewById(i);

                    if (!TextUtils.isEmpty(editText.getText().toString())) {
                        resultado += editText.getText().toString() + "\n";
                        cliente.setarCampo(editText.getTag().toString(), editText.getText().toString());
                        editText.setText("");
                    }
                }

                listaClientes.inserirCliente(cliente);

                ((TextView) findViewById(R.id.textViewResultado)).setText(resultado);

            }
        });

        ((Button) findViewById(R.id.btClientes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Cliente.class);
                startActivity(it);
            }
        });

        ((Button)findViewById(R.id.btContato)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ContatoActivity.class);
                startActivity(it);
            }
        });

        ((Button) findViewById(R.id.btVoltar)).setOnClickListener(new View.OnClickListener() {

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

    private void inicializarArr() {

        hints = getResources().getStringArray(R.array.hints);

        tags = getResources().getStringArray(R.array.tags);

        campos = initCampos();

    }

    private List<ConfigurarCampo> initCampos(){

        List<ConfigurarCampo> list = new ArrayList<>();

        ConfigurarCampo campoNome = new ConfigurarCampo();
        campoNome.setHint(getResources().getString(R.string.nome));
        campoNome.setTag("nome");
        campoNome.setId(1);

        list.add(campoNome);

        ConfigurarCampo campoSobrenome = new ConfigurarCampo();
        campoSobrenome.setHint(getResources().getString(R.string.sobrenome));
        campoSobrenome.setTag("sobrenome");
        campoSobrenome.setId(2);

        list.add(campoSobrenome);

        ConfigurarCampo campoDataNascimento = new ConfigurarCampo();
        campoDataNascimento.setHint(getResources().getString(R.string.dataNascimento));
        campoDataNascimento.setTag("dataNascimento");
        campoDataNascimento.setId(3);

        list.add(campoDataNascimento);


        ConfigurarCampo campoCidade = new ConfigurarCampo();
        campoCidade.setHint(getResources().getString(R.string.cidade));
        campoCidade.setTag("cidade");
        campoCidade.setId(5);

        list.add(campoCidade);


        return list;

    }}

    //private List<ConfigurarCampo> initCampos() {

      ///  ConfigurarCampo nome = new ConfigurarCampo();
        //nome.setMint(getResources().getString(R.string.nome));
        //nome.setTag(1);
   // }
//}
package com.example.bruna.atividadebruno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] hints;
    private String[] tags;

    //private int qtdViewAdd = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hints = getResources().getStringArray( R.array.hints );
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById( R.id.linear_Layout);

        for (int i = 0; i <hints.length; i++){
            EditText editText = new EditText( this );
            editText.setId( i );
            editText.setHint(hints[i]);


            editText.setTag(tags[i]);

            linearLayout.addView( editText );
        }


       Button btEnviar = new Button(this);
       btEnviar.setText("Enviar");
        linearLayout.addView(btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout linearLayout = findViewById(R.id.linear_Layout);
                linearLayout.setVisibility(View.GONE);

                LinearLayout linearLayoutResultado = findViewById(R.id.linearResultado);
                linearLayoutResultado.setVisibility(View.VISIBLE);

                String resultado = "";

                for(int i = 0 ; i < hints.length; i++){
                    EditText textView = findViewById(i);
                    if(!TextUtils.isEmpty(textView.getText().toString())){
                        resultado += textView.getText().toString() + "\n";
                    }
                }

                ((TextView) findViewById(R.id.textViewResultado)).setText(resultado);
            }
        });
        linearLayout.addView(btEnviar);

    }
}

package com.example.bruna.atividadebruno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int qtdViewAdd = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linear_Layout);

        for (int i = 0 ; i < qtdViewAdd; i++) {

            EditText editText = new EditText(this);
            editText.setId(i);
            editText.setHint("Digite seu nome:");
            linearLayout.addView(editText);

        }

        Button btEnviar = new Button(this);
        btEnviar.setText("Enviar");
        linearLayout.addView(btEnviar);

    }
}

package com.example.bruna.atividadebruno.servidor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bruna.atividadebruno.R;
import com.example.bruna.atividadebruno.modal.Contato;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ContatoActivity {
    List<Contato> contatos;

    public ContatoActivity(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        contatos = (List<Contato>) new TypeToken<List<Contato>>(){}.getType();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);

        for (Contato contato : contatos) {

            View v = inflater.inflate(R.layout.item_contato,null,false);

            ((TextView)v.findViewById(R.id.tvNome)).setText(contato.getNome());
            ((TextView)v.findViewById(R.id.tvSobrenome)).setText(contato.getSobrenome());
            ((TextView)v.findViewById(R.id.tvNascimento)).setText(contato.getDatadenascimento());
            ((TextView)v.findViewById(R.id.tvCidade)).setText(contato.getCidade());
            ((LinearLayout)v.findViewById(R.id.llContainerContato)).addView(v);

        }
    }
}
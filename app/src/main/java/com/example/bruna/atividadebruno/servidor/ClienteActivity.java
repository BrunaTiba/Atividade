package com.example.bruna.atividadebruno.servidor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bruna.atividadebruno.R;
import com.example.bruna.atividadebruno.modal.Cliente;

import java.util.List;

public class ClienteActivity extends AppCompatActivity {

    List<Cliente> clientes;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        clientes = MainActivity.listaClientes.recuperarClientes();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);

        for (Cliente cliente : clientes) {

            View v = inflater.inflate(R.layout.item_cliente,null,false);

            ((TextView)v.findViewById(R.id.tvNome)).setText(cliente.getNome());

            ((TextView)v.findViewById(R.id.tvSobrenome)).setText(cliente.getSobrenome());

            ((TextView)v.findViewById(R.id.tvDatadeNascimento)).setText(cliente.getDataNascimento());

            ((TextView)v.findViewById(R.id.tvCidade)).setText(cliente.getCidade());

             ((LinearLayout)findViewById(R.id.llContainerClientes)).addView(v);

        }
    }

}

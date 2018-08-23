package com.example.bruna.atividadebruno.bancodedados;

import com.example.bruna.atividadebruno.modal.Cliente;
import com.example.bruna.atividadebruno.modal.Contato;

import java.util.ArrayList;
import java.util.List;

public class BDListaClientes
{
    private List<Cliente> clientes;
    private List<Contato> contatos;

    public BDListaClientes (){
        clientes = new ArrayList<>();
    }
    public void inserirCliente(Cliente cliente){
        clientes.add(cliente);}

    public List<Cliente> recuperarClientes () {
        return clientes;}
}






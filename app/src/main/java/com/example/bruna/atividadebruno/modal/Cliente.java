package com.example.bruna.atividadebruno.modal;

public class Cliente {
    private String nome;
    private String Sobrenome;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private String estado;
    private String cidade;
    private String bairro;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public void setarCampo(String nomeDoCampo, String valorDoCampo) {

        switch (nomeDoCampo) {

            case "nome":
                setNome(valorDoCampo);
                break;
            case "sobrenome":
                setSobrenome(valorDoCampo);
                break;
            case "dataNascimento":
                setDataNascimento(valorDoCampo);
                break;
            case "cpf":
                setCpf(valorDoCampo);
                break;
            case "rg":
                setRg(valorDoCampo);
                break;
            case "estado":
                setEstado(valorDoCampo);
                break;
            case "cidade":
                setCidade(valorDoCampo);
                break;
            case "bairro":
                setBairro(valorDoCampo);
                break;
        }
    }
}

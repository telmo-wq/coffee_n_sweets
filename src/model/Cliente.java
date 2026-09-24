package model;

import java.time.LocalDate;

public class Cliente {
    private int IDCliente;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    public Cliente() {}

    public Cliente(int IDCliente, String nome, String email, LocalDate dataCadastro) {
        this.IDCliente = IDCliente;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public int getIDCliente() {
        return IDCliente;
    }
    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

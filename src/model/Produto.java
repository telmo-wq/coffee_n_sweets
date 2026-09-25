package model;

public class Produto {
    private int IDProduto;
    private String nome;
    private float preco;
    private String descricao;

    public Produto() {}

    public Produto(int IDProduto, String nome, float preco, String descricao) {
        this.IDProduto = IDProduto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getIDProduto() {
        return IDProduto;
    }
    public void setIDProduto(int IDProduto) {
        this.IDProduto = IDProduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

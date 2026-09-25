package dto;

public class TopProdutosDTO {
    private int IDProduto;
    private String nome;
    private int totalVendido;

    public TopProdutosDTO(int IDProduto, String nome, int totalVendido) {
        this.IDProduto = IDProduto;
        this.nome = nome;
        this.totalVendido = totalVendido;
    }

    public int getIDProduto() {
        return IDProduto;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalVendido() {
        return totalVendido;
    }
}

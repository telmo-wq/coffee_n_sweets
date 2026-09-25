package dto;

public class BaristasDestaqueDTO {
    private int IDFuncionario;
    private String nome;
    private int itensPreparados;

    public BaristasDestaqueDTO(int IDFuncionario, String nome, int itensPreparados) {
        this.IDFuncionario = IDFuncionario;
        this.nome = nome;
        this.itensPreparados = itensPreparados;
    }

    public int getIDFuncionario() {
        return IDFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public int getItensPreparados() {
        return itensPreparados;
    }
}

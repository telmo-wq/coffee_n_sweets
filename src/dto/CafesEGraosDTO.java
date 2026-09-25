package dto;

public class CafesEGraosDTO {
    private String nomeCafe;
    private String nomeGrao;
    private String origem;
    private String razaoSocial;
    private double precoKG;

    public CafesEGraosDTO(String nomeCafe, String nomeGrao, String origem, String razaoSocial, double precoKG) {
        this.nomeCafe = nomeCafe;
        this.nomeGrao = nomeGrao;
        this.origem = origem;
        this.razaoSocial = razaoSocial;
        this.precoKG = precoKG;
    }

    public String getNomeCafe() {
        return nomeCafe;
    }

    public String getNomeGrao() {
        return nomeGrao;
    }

    public String getOrigem() {
        return origem;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public double getPrecoKG() {
        return precoKG;
    }
}

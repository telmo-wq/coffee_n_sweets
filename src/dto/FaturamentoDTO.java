package dto;

import java.time.LocalDate;

public class FaturamentoDTO {
    private LocalDate data;
    private double faturamento;
    private String formaPagamento;

    public FaturamentoDTO(LocalDate data, double faturamento, String formaPagamento) {
        this.data = data;
        this.faturamento = faturamento;
        this.formaPagamento = formaPagamento;
    }

    public LocalDate getData() {
        return data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public double getFaturamento() {
        return faturamento;
    }
}

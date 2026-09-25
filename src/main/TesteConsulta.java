package main;

import dao.ConsultasDAO;
import dto.CafesEGraosDTO;
import dto.FaturamentoDTO;
import dto.TopProdutosDTO;
import dto.BaristasDestaqueDTO;

import java.sql.SQLException;

public class TesteConsulta {
    public static void main(String[] args) {
        ConsultasDAO relatorioDAO = new ConsultasDAO();

        try {
            System.out.println("--- Faturamento por dia e forma de pagamento ---");
            for (FaturamentoDTO f : relatorioDAO.faturamentoPorDia()) {
                System.out.println(f.getData() + " | R$ " + f.getFaturamento() + " | " + f.getFormaPagamento());
            }

            System.out.println("\n--- Top 10 produtos mais vendidos ---");
            for (TopProdutosDTO p : relatorioDAO.top10ProdutosVendidos()) {
                System.out.println(p.getNome() + " | Total vendido: " + p.getTotalVendido());
            }

            System.out.println("\n--- Baristas acima da média ---");
            for (BaristasDestaqueDTO b : relatorioDAO.baristasAcimaDaMedia()) {
                System.out.println(b.getNome() + " | Itens preparados: " + b.getItensPreparados());
            }

            System.out.println("\n--- Cafés e seus grãos ---");
            for (CafesEGraosDTO c : relatorioDAO.cafesEGraos()) {
                System.out.println("Café: " + c.getNomeCafe() + " | Grão: " + c.getNomeGrao() + " | Origem: " + c.getOrigem() +
                                " | Fornecedor: " + c.getRazaoSocial() + " | Preço por KG: R$ " + c.getPrecoKG());
            }

        } catch (SQLException e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
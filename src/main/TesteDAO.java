package main;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteDAO {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        try {
            Cliente novo = new Cliente(0, "João Silva", "joao@email.com", LocalDate.now());
            dao.inserir(novo);
            System.out.println("Cliente inserido! ID gerado: " + novo.getIDCliente());

            List<Cliente> clientes = dao.listar();
            System.out.println("\n--- Lista de clientes ---");
            for (Cliente c : clientes) {
                System.out.println(c.getIDCliente() + " | " + c.getNome() + " | "
                        + c.getEmail() + " | " + c.getDataCadastro());
            }

            novo.setNome("João Silva Atualizado");
            dao.atualizar(novo);
            System.out.println("\nCliente atualizado!");

            System.out.println("\n--- Lista após atualização ---");
            for (Cliente c : dao.listar()) {
                System.out.println(c.getIDCliente() + " | " + c.getNome());
            }

            dao.excluir(novo.getIDCliente());
            System.out.println("\nCliente excluído!");

        } catch (SQLException e) {
            System.out.println("Erro no teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
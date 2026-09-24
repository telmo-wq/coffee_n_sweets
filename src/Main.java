import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.println("Conectado com sucesso!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM Cliente");

            if (rs.next()) {
                int total = rs.getInt("total");
                System.out.println("Total de clientes no banco: " + total);
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
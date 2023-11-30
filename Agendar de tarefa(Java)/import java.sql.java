import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Estacionamento {

    // Método para inserir um carro na tabela carros
    public static void inserirCarro(String placa, String modelo) {
        // Configurações de conexão com o banco de dados
        String url = "jdbc:mysql://localhost/Estacionamento";
        String usuario = "root";
        String senha = "Wi@20081998";

        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // SQL para inserir um novo carro
            String sql = "INSERT INTO carros (placa, modelo) VALUES (?, ?)";

            // Cria uma declaração preparada para evitar injeção de SQL
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                // Define os parâmetros da declaração preparada
                preparedStatement.setString(1, placa);
                preparedStatement.setString(2, modelo);

                // Executa a atualização
                preparedStatement.executeUpdate();

                System.out.println("Carro inserido com sucesso!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Trate a exceção adequadamente, por exemplo, e.printStackTrace();
            System.out.println("Erro ao inserir o carro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso do método de inserção
        inserirCarro("ABC1234", "Fusca");
    }
}

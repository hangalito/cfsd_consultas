package consultas.dbconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class DBConecta {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_inscricoes?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVERMYSQL8 = "com.mysql.jdbc.cj.Driver";
    private static final String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                Class.forName(DRIVERMYSQL5);
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro de conexão" + ex.getMessage());
        }
        return conexao;
    }
}

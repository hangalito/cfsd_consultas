package consultas.dbconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConecta {

    public static final String URL = "jdbc:mysql://localhost:3306/bd_inscricoes?useSSL=false&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVERMYSQL8 = "com.mysql.jdbc.cj.Driver";
    public static final String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    public static Connection conexao;

    public static Connection getConexao() throws Throwable{

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

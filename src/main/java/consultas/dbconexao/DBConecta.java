package consultas.dbconexao;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class DBConecta {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_inscricoes?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    private static final String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName(DRIVERMYSQL8);
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            String msg = ex.getLocalizedMessage();
            Logger.getLogger(MethodHandles.lookup().lookupClass().getName())
                    .log(Level.SEVERE, ex, () -> "Erro de conexão: " + msg);
        }
        return conexao;
    }
}

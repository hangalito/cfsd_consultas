package consultas.dbconexao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger LOG = Logger.getLogger(DatabaseConnection.class.getName());
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_inscricoes?useSSL=false&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(Driver.class.getName());
        } catch (ClassNotFoundException e) {
            LOG.log(Level.SEVERE, "Class not found: {0}", e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

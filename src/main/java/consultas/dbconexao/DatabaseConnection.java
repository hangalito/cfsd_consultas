package consultas.dbconexao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:sqlserver://OPERJOTTA\\SQLEXPRESS;databaseName=gestaocursos;encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() throws SQLException {
        SQLServerDriver.register();
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

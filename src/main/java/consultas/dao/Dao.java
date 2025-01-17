package consultas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Define a estrutura básica a serem implementadas pelas classes DAO.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">
 * Bartolomeu Hangalo</a>
 */
abstract class Dao<T, ID> {

    /**
     * Cria uma consulta SQL usando o modelo JDBC e retorna um objeto
     * {@link ResultSet} com os dados obtidos da base dados.
     *
     * @param conn Instância de {@link Connection} conectada a base de dados.
     * @param sql Instrução SQL para executar na base de dados.
     * @param params Parâmetros opcionais para passar à consulta SQL.
     * @return Instância de {@link ResultSet} com os dados obtidos da base de
     * dados.
     * @throws SQLException No caso de algum erro durante a operação, propaga
     * exceção.
     */
    protected ResultSet query(Connection conn, String sql, Object... params) throws SQLException {
        var ps = conn.prepareStatement(sql);
        for (var i = 0; i < params.length; i++) {
            var param = params[i];
            ps.setObject(i + 1, param);
        }
        return ps.executeQuery();
    }

    public abstract List<T> findAll();

    public abstract Optional<T> findById(ID id);

    public abstract List<T> search(Object param);
}

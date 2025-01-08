package com.cfsd.cfsd_consultas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta classe contém métodos que serão partilhados por
 * todas as classes DAO no projeto.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
abstract class Dao {

    /**
     * Cria uma consulta SQL usando o modelo JDBC e retorna um objeto {@link ResultSet}
     * com os dados obtidos da base dados.
     *
     * @param conn   Instância de {@link Connection} conectada a base de dados.
     * @param sql    Instrução SQL para executar na base de dados.
     * @param params Parâmetros opcionais para passar à consulta SQL.
     * @return Instância de {@link ResultSet} com os dados obtidos da base de dados.
     * @throws SQLException No caso de algum erro durante a operação, propaga exceção.
     */
    protected ResultSet consultar(Connection conn, String sql, Object... params) throws SQLException {
        var ps = conn.prepareStatement(sql);
        for (var i = 0; i < params.length; i++) {
            var param = params[i];
            ps.setObject(i, param);
        }
        return ps.executeQuery();
    }
}

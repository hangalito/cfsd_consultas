package com.cfsd.cfsd_consultas.dao;

import com.cfsd.cfsd_consultas.modelo.Operacao;
import jakarta.ejb.Stateful;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por realizar as operações de consulta na base de dados para a
 * entidade {@link Operacao}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
@Stateful
public class OperacaoDao extends Dao {

    /**
     * Preenche os campos do objeto passado com os dados da base de dados.
     *
     * @param operacao Instância de {@link Operacao} com os campos a serem preenchidos.
     * @param rs       Instância de {@link ResultSet} com os dados a serem obtidos.
     * @throws SQLException No caso de algum erro durante a operação, propagar a exceção.
     */
    public static void populateFields(Operacao operacao, ResultSet rs) throws SQLException {
        operacao.setChave(rs.getInt("ChaveDaOperacao"));
        operacao.setCodigo(rs.getString("CodigoDaOperacao"));
        operacao.setNome(rs.getString("NomeDaOperacao"));
    }

    /**
     * Lista todas as operações presentes na base de dados.
     *
     * @return Lista de operações salvas na base de dados.
     */
    public List<Operacao> findAll() {
        // TODO: implementar o código para buscar todos os horários da base de dados
        throw new UnsupportedOperationException("Method OperacaoDao::findAll() not implemented yet");
    }

    /**
     * Lista todas as operações na base de dados com a chave especificada.
     *
     * @param chave A chave da(s) operação(ões) para listar.
     * @return Lista de operações com a chave especificada.
     */
    public List<Operacao> findByChave(Integer chave) {
        // TODO: implementar o código para buscar as operações com uma determinada chave
        throw new UnsupportedOperationException("Method OperacaoDao::findByChave(Integer) not implemented yet");
    }

    /**
     * Consultar uma operação com um código específico.
     *
     * @param codigo O código da operação para consultar.
     * @return Instância de {@link Optional}<{@link Operacao}.
     */
    public Optional<Operacao> findByCodigo(String codigo) {
        // TODO: implementar o código para buscar a operação com código específico
        throw new UnsupportedOperationException("Method Operacao::findByCodigo(String) not implemented yet");
    }

}

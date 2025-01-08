package com.cfsd.cfsd_consultas.dao;

import com.cfsd.cfsd_consultas.modelo.Turma;
import jakarta.ejb.Stateful;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por realizar as operações de consulta na base de dados para a
 * entidade {@link Turma}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
@Stateful
public class TurmaDao extends Dao {

    /**
     * Preenche os campos do objeto passado com os dados da base de dados.
     *
     * @param turma Instância de {@link Turma} com os campos a serem preenchidos.
     * @param rs    Instância de {@link ResultSet} com os dados a serem obtidos.
     * @throws SQLException No caso de algum erro durante a operação, propagar a exceção.
     */
    public static void populateFields(Turma turma, ResultSet rs) throws SQLException {
        turma.setCodigo(rs.getString("CodigoDaTurma"));
        turma.setNome(rs.getString("NomeDaTurma"));
    }

    /**
     * Lista todas as turmas salvas na base de dados.
     *
     * @return Lista de turmas da base de dados.
     */
    public List<Turma> findAll() {
        // TODO: implementar o código para listar todas as turmas
        throw new UnsupportedOperationException("Method TurmaDao::findAll() not implemented yet");
    }

    /**
     * Busca os dados da turma com o código especificado.
     *
     * @param codigo O código da turma para consultar.
     * @return {@link Optional}<{@link Turma}>
     */
    public Optional<Turma> findById(String codigo) {
        // TODO: implementar o código para listar a turma com o ID especificado
        throw new UnsupportedOperationException("Method TurmaDao::findById(String) not implemented yet");
    }

    /**
     * Lista todas as turmas da base de dados com o nome especificado.
     *
     * @param name O nome das turmas para listar.
     * @return Lista das turmas com o nome especificado.
     */
    public List<Turma> findByName(String name) {
        // TODO: implementar o código para listar as turmas com o nome especificado
        throw new UnsupportedOperationException("Method TurmaDao::findByName(String) not implemented yet");
    }
}

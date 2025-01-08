package com.cfsd.cfsd_consultas.dao;

import com.cfsd.cfsd_consultas.modelo.Horario;
import jakarta.ejb.Stateful;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por realizar as operações de consulta na base de dados para a
 * entidade {@link Horario}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
@Stateful
public class HorarioDao extends Dao {

    /**
     * Método responsável por preencher os dados da entidade {@link Horario} passado.
     *
     * @param horario A instância da entidade para preencher os campos.
     * @param rs      Instância de {@link ResultSet} de onde os dados serão obtidos.
     * @throws SQLException No caso de algum error ocorrer durante a operação,
     *                      propagar a exceção.
     */
    public static void populateFields(Horario horario, ResultSet rs) throws SQLException {
        horario.setCodigo(rs.getString("CodigoDoHorario"));
        horario.setNome(rs.getString("NomeDoHorario|"));
    }

    /**
     * Lista todos os horários salvos na base de dados e retorna-os numa lista.
     *
     * @return A lista de horários na base de dados.
     */
    public List<Horario> findAll() {
        // TODO: implementar o código para buscar todos os horários da base de dados
        throw new UnsupportedOperationException("Method HorarioDao::findAll() not implemented yet");
    }

    public Optional<Horario> findById(String id) {
        // TODO: implementar o código para buscar o horário com ID especificado
        throw new UnsupportedOperationException("Method HorarioDao::findById(String) not implemented yet");
    }

    /**
     * Lista os horários na base de dados com um nome especificado.
     *
     * @param name O nome do horário para pesquisar.
     * @return A lista de horários com o nome especificado.
     */
    public List<Horario> findByName(String name) {
        // TODO: implementar o código para buscar horários por nome
        throw new UnsupportedOperationException("Method HorarioDao::findByName(String) not implemented yet");
    }
}

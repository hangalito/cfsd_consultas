package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.modelo.Horario;
import jakarta.ejb.Stateless;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por realizar as operações de consulta na base de dados
 * para a entidade {@link Horario}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Stateless
public class HorarioDao extends Dao<Horario, String> {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String FIND_ALL = "SELECT * FROM TblHorarios";
    private static final String FIND_BY_ID = "SELECT * FROM TblHorarios WHERE CodigoDoHorario = ?";
    private static final String FIND_BY_NAME = "";

    /**
     * Responsável por preencher os dados da entidade {@link Horario}
     * passado.
     *
     * @param horario A instância da entidade para preencher os campos.
     * @param rs      Instância de {@link ResultSet} de onde os dados serão obtidos.
     * @throws SQLException No caso de algum error ocorrer durante a operação,
     *                      propagar a exceção.
     */
    public static void populateFields(Horario horario, ResultSet rs) throws SQLException {
        horario.setCodigo(rs.getString("CodigoDoHorario"));
        horario.setNome(rs.getString("NomeDoHorario"));
    }

    /**
     * Lista todos os horários salvos na base de dados e retorna-os numa lista.
     *
     * @return A lista de horários na base de dados.
     */
    @Override
    public List<Horario> findAll() {
        LOG.info("Querying all time tables from the database");
        List<Horario> horarios = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            var rs = query(conn, FIND_ALL);
            while (rs.next()) {
                var horario = new Horario();
                populateFields(horario, rs);
                horarios.add(horario);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todos os horários na base de dados: " + msg);
        }
        return horarios;
    }

    /**
     * Consulta os dados do horário na base de dados com um código especificado.
     *
     * @param codigo O código do horário para consultar os dados.
     * @return Caso nenhum horário coincida com o código especificado, retorna
     * {@link Optional} vazio, caso contrário, um {@link Optional} com o
     * horário.
     */
    @Override
    public Optional<Horario> findById(String codigo) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = query(conn, FIND_BY_ID, codigo);
            if (rs.next()) {
                Horario horario = new Horario();
                populateFields(horario, rs);
                return Optional.of(horario);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todos o horário com o código " + codigo + " na base de dados: " + msg);
        }
        return Optional.empty();
    }

    @Override
    public List<Horario> search(Object param) {
        return List.of();
    }

    /**
     * Lista os horários na base de dados com um nome especificado.
     *
     * @param nome O nome do horário para pesquisar.
     * @return A lista de horários com o nome especificado.
     */
    public List<Horario> findByName(String nome) {
        List<Horario> horarios = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = query(conn, FIND_BY_NAME, nome);
            while (rs.next()) {
                Horario horario = new Horario();
                populateFields(horario, rs);
                horarios.add(horario);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todos os horários com o nome " + nome + " na base de dados: " + msg);
        }
        return horarios;
    }
}

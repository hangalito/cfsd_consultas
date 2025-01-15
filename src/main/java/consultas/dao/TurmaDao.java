package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Turma;
import jakarta.ejb.Stateless;

import java.io.Serializable;
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
 * para a entidade {@link Turma}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Stateless
public class TurmaDao extends Dao<Turma, String> implements Serializable {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    /**
     * Preenche os campos do objeto passado com os dados da base de dados.
     *
     * @param turma Instância de {@link Turma} com os campos a serem
     * preenchidos.
     * @param rs Instância de {@link ResultSet} com os dados a serem obtidos.
     * @throws SQLException No caso de algum erro durante a operação, propagar a
     * exceção.
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
    @Override
    public List<Turma> findAll() {
        List<Turma> turmas = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblturmas");
            while (rs.next()) {
                var turma = new Turma();
                populateFields(turma, rs);
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todas as turmas da base de dados: " + msg);
        }
        return turmas;
    }

    /**
     * Busca os dados da turma com o código especificado.
     *
     * @param codigo O código da turma para consultar.
     * @return {@link Optional}<{@link Turma}>
     */
    @Override
    public Optional<Turma> findById(String codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblturmas WHERE NomeDaTurma = ?", codigo);
            if (rs.next()) {
                var turma = new Turma();
                populateFields(turma, rs);
                return Optional.of(turma);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar a turma com o código " + codigo + " na base de dados: " + msg);
        }
        return Optional.empty();
    }

    /**
     * Lista todas as turmas da base de dados com o nome especificado.
     *
     * @param name O nome das turmas para listar.
     * @return Lista das turmas com o nome especificado.
     */
    public List<Turma> findByName(String name) {
        List<Turma> turmas = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblturmas WHERE NomeDaTurma = ?", name);
            while (rs.next()) {
                var turma = new Turma();
                populateFields(turma, rs);
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar todas as turmas da base de dados: " + msg);
        }
        return turmas;
    }
}

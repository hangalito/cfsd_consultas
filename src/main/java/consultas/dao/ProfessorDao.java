package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Professor;
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
 * para a entidade {@link Professor}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Stateless
public class ProfessorDao extends Dao<Professor, Integer> {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    /**
     * Preenche os campos do objecto passado com os dados na base de dados.
     *
     * @param professor Intância de {@link Professor} com os campos a serem
     * preenchidos.
     * @param rs Instância de {@link ResultSet} com os dados obtidos da base de
     * dados.
     * @throws SQLException No caso de algum erro SQL durante a operação,
     * propagar a excepção.
     */
    public static void populateFields(Professor professor, ResultSet rs) throws SQLException {
        professor.setCodigo(rs.getInt("CodigoDoFuncionario"));
        professor.setNome(rs.getString("NomeDoFuncionario"));
        professor.setDataDeNascimento(rs.getDate("DataDeNascimento").toLocalDate());
        professor.setDataDeAdmissao(rs.getDate("DataDeAdmissao").toLocalDate());
    }

    /**
     * Lista todos os dados de todos os professores salvos na base de dados.
     *
     * @return Uma lista com os professores obtidos da base de dados.
     */
    @Override
    public  List<Professor> findAll() {
        List<Professor> professores = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblprofessores");
            while (rs.next()) {
                var professor = new Professor();
                populateFields(professor, rs);
                professores.add(professor);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listas os professores na base de dados: " + msg);
        }
        return professores;
    }

    /**
     * Obter os dados do professor na base de dados com um código específico.
     *
     * @param codigo O código do professor na base de dados para consultar.
     * @return Instância de {@link Optional} com o professor caso seja
     * encontrado algum, do contrário um {@link Optional} vazio.
     */
    @Override
    public Optional<Professor> findById(Integer codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblprofessores WHERE CodigoDoProfessor = ?", codigo);
            if (rs.next()) {   
                var professor = new Professor();
                populateFields(professor, rs);
                return Optional.of(professor);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao obter os dados do professor com código " + codigo + ":" + msg);
        }
        return Optional.empty();
    }

    public List<Professor> findByName(String nome) {
        List<Professor> professores = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblprofessores WHERE NomeDoProfessor = ?", nome);
            while(rs.next()) {
                var professor = new Professor();
                populateFields(professor, rs);
                professores.add(professor);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar os professores com o nome " + nome + ": " + msg);
        }
        return professores;
    }
}

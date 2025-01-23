package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Funcionario;
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
 * para a entidade {@link Funcionario}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Stateless
public class FuncionarioDao extends Dao<Funcionario, Integer> {

    private static final String SQL_FIND_ALL = "SELECT * FROM TblProfessores";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM TblProfessores WHERE CodigoDoProfessor = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM TblProfessores WHERE NomeDoProfessor = ?";

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    /**
     * Preenche os campos do objeto passado com os dados na base de dados.
     *
     * @param funcionario Instância de {@link Funcionario} com os campos a serem
     *                    preenchidos.
     * @param rs          Instância de {@link ResultSet} com os dados obtidos da base de
     *                    dados.
     * @throws SQLException No caso de algum erro SQL durante a operação,
     *                      propagar a exceção.
     */
    public static void populateFields(Funcionario funcionario, ResultSet rs) throws SQLException {
        funcionario.setCodigo(rs.getInt("CodigoDoFuncionario"));
        funcionario.setNome(rs.getString("NomeDoFuncionario"));
        funcionario.setDataDeNascimento(rs.getDate("DataDeNascimento").toLocalDate());
        funcionario.setDataDeAdmissao(rs.getDate("DataDeAdmissao").toLocalDate());
    }

    /**
     * Lista todos os dados de todos os professores salvos na base de dados.
     *
     * @return Uma lista com os professores obtidos da base de dados.
     */
    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> professores = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, SQL_FIND_ALL);
            while (rs.next()) {
                var professor = new Funcionario();
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
    public Optional<Funcionario> findById(Integer codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, SQL_FIND_BY_ID, codigo);
            if (rs.next()) {
                var professor = new Funcionario();
                populateFields(professor, rs);
                return Optional.of(professor);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao obter os dados do professor com código " + codigo + ":" + msg);
        }
        return Optional.empty();
    }

    @Override
    public List<Funcionario> search(Object param) {
        return List.of();
    }

    public List<Funcionario> findByName(String nome) {
        List<Funcionario> professores = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, SQL_FIND_BY_NAME, nome);
            while (rs.next()) {
                var professor = new Funcionario();
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

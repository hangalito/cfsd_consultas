package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.modelo.Funcionario;
import static consultas.util.LoggingUtil.severe;
import jakarta.ejb.Stateless;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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

    private static final String SQL_FIND_ALL = "SELECT * FROM TblFuncionarios";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM TblFuncionarios WHERE CodigoDoFuncionario = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM TblFuncionarios WHERE NomeDoFuncionario = ?";
    private static final Comparator<Funcionario> COMPARATOR = Comparator.comparing(Funcionario::getNome)
            .thenComparingInt(Funcionario::getCodigo)
            .thenComparing(Funcionario::getDataDeAdmissao);

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    /**
     * Preenche os campos do objeto passado com os dados na base de dados.
     *
     * @param funcionario Instância de {@link Funcionario} com os campos a serem
     * preenchidos.
     * @param rs Instância de {@link ResultSet} com os dados obtidos da base de
     * dados.
     * @throws SQLException No caso de algum erro SQL durante a operação,
     * propagar a exceção.
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
        try (Connection conn = DatabaseConnection.getConnection()) {
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
        professores.sort(COMPARATOR);
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
        try (Connection conn = DatabaseConnection.getConnection()) {
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
        final String SQL = """
                           SELECT * FROM TblFuncionarios
                           WHERE CodigoDoFuncionario LIKE ?
                           OR NomeDoFuncionario LIKE ?
                         """;
        final String p = "%" + param + "%";
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (ResultSet rs = query(conn, SQL, p, p)) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    populateFields(funcionario, rs);
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException ex) {
            severe(ex, "Erro ao pesquisar por funcionários: " + ex.getLocalizedMessage());
        }
        funcionarios.sort(COMPARATOR);
        return funcionarios;
    }

    public List<Funcionario> findByName(String nome) {
        List<Funcionario> professores = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
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
        professores.sort(COMPARATOR);
        return professores;
    }
}

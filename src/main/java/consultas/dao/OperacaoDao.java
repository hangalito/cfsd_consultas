package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Operacao;
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
 * para a entidade {@link Operacao}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Stateless
@SuppressWarnings("unused")
public class OperacaoDao extends Dao<Operacao, String> {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final Comparator<Operacao> COMPARATOR = Comparator.comparing(Operacao::getNome);
    private static final String LIST_ALL = "SELECT * FROM tbloperacoes";
    private static final String LIST_BY_ID = "SELECT * FROM tbloperacoes WHERE CodigoDaOperacao = ?";
    private static final String LIST_BY_KEY = "SELECT * FROM tbloperacoes WHERE ChaveDaOperacao = ?";
    private static final String LIST_BY_NAME = "SELECT * FROM tbloperacoes WHERE NomeDaOperacao = ?";
    private static final String SEARCH_QUERY = """
                                               SELECT * FROM tbloperacoes
                                               WHERE CodigoDaOperacao LIKE ?
                                               OR ChaveDaOperacao LIKE ?
                                               OR NomeDaOperacao LIKE ?
                                               """;

    /**
     * Preenche os campos do objeto passado com os dados da base de dados.
     *
     * @param operacao Instância de {@link Operacao} com os campos a serem
     * preenchidos.
     * @param rs Instância de {@link ResultSet} com os dados a serem obtidos.
     * @throws SQLException No caso de algum erro durante a operação, propagar a
     * exceção.
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
    @Override
    public List<Operacao> findAll() {
        List<Operacao> operacoes = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, LIST_ALL);
            while (rs.next()) {
                Operacao operacao = new Operacao();
                populateFields(operacao, rs);
                operacoes.add(operacao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todas as operações na base de dados: " + msg);
        }
        operacoes.sort(COMPARATOR);
        return operacoes;
    }

    /**
     * Consultar uma operação com um código específico.
     *
     * @param codigo O código da operação para consultar.
     * @return Instância de {@link Optional}<{@link Operacao}.
     */
    @Override
    public Optional<Operacao> findById(String codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, LIST_BY_ID, codigo);
            if (rs.next()) {
                Operacao operacao = new Operacao();
                populateFields(operacao, rs);
                return Optional.of(operacao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todas as operações na base de dados: " + msg);
        }
        return Optional.empty();
    }

    /**
     * Lista todas as operações na base de dados com a chave especificada.
     *
     * @param chave A chave da(s) operação(ões) para listar.
     * @return Lista de operações com a chave especificada.
     */
    public List<Operacao> findByChave(Integer chave) {
        List<Operacao> operacoes = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, LIST_BY_KEY, chave);
            while (rs.next()) {
                var operacao = new Operacao();
                populateFields(operacao, rs);
                operacoes.add(operacao);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todas as operações na base de dados: " + msg);
        }
        operacoes.sort(COMPARATOR);
        return operacoes;
    }

    @Override
    public List<Operacao> search(Object param) {
        List<Operacao> operacoes = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            String sql = "%" + param + "%";
            ResultSet rs = query(conn, SEARCH_QUERY, sql);
            while (rs.next()) {
                Operacao operacao = new Operacao();
                populateFields(operacao, rs);
                operacoes.add(operacao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao pesquisar operações: " + msg);
        }
        operacoes.sort(COMPARATOR);
        return operacoes;
    }
}

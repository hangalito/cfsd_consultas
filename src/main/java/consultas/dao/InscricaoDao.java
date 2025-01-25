package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.modelo.Aluno;
import consultas.modelo.Inscricao;
import jakarta.ejb.Stateless;

import java.io.Serializable;
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

@Stateless
public class InscricaoDao extends Dao<Inscricao, Integer> implements Serializable {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final Comparator<Inscricao> COMPARATOR = Comparator.comparing(Inscricao::getData).reversed()
            .thenComparingInt(Inscricao::getCodigo);

    private static final String FIND_ALL = "SELECT * FROM TblInscricoes";
    private static final String FIND_BY_ID = "SELECT * FROM TblInscricoes WHERE CodigoDaInscricao = ?";

    public static void populateFields(Inscricao inscricao, ResultSet rs) throws SQLException {
        inscricao.setCodigo(rs.getInt("CodigoDaInscricao"));
        inscricao.setData(rs.getDate("DataDaInscricao").toLocalDate());
    }

    @Override
    public List<Inscricao> findAll() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = query(conn, FIND_ALL);
            while (rs.next()) {
                Inscricao inscricao = new Inscricao();
                populateFields(inscricao, rs);
                new AlunoDao().findById(rs.getInt("CodigoDoAluno"))
                        .ifPresent(inscricao::setAluno);
                new FuncionarioDao().findById(rs.getInt("CodigoDoFuncionario"))
                        .ifPresent(inscricao::setFuncionario);
                inscricao.setDetalhes(new DetalhesDaInscricaoDao().findByInsc(inscricao));
                inscricoes.add(inscricao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar todas as inscrições: " + msg);
        }
        inscricoes.sort(COMPARATOR);
        return inscricoes;
    }

    @Override
    public Optional<Inscricao> findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = query(conn, FIND_BY_ID, id);
            if (rs.next()) {
                Inscricao inscricao = new Inscricao();
                populateFields(inscricao, rs);
                new AlunoDao().findById(rs.getInt("CodigoDoAluno"))
                        .ifPresent(inscricao::setAluno);
                new FuncionarioDao().findById(rs.getInt("CodigoDoFuncionario"))
                        .ifPresent(inscricao::setFuncionario);
                return Optional.of(inscricao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar inscrição por ID: " + msg);
        }
        return Optional.empty();
    }

    @Override
    public List<Inscricao> search(Object param) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Inscricao> findByAluno(Aluno aluno) {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = query(conn, "SELECT * FROM TblInscricoes WHERE CodigoDoAluno = ?", aluno.getCodigo());
            while (rs.next()) {
                Inscricao inscricao = new Inscricao();
                inscricao.setAluno(aluno);
                populateFields(inscricao, rs);
                new FuncionarioDao().findById(rs.getInt("CodigoDoFuncionario"))
                        .ifPresent(inscricao::setFuncionario);
                inscricoes.add(inscricao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar inscrições do aluno: " + msg);
        }
        inscricoes.sort(COMPARATOR);
        return inscricoes;
    }
}

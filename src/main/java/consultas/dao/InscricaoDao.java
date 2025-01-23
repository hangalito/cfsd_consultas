package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Aluno;
import consultas.modelo.Inscricao;
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

@Stateless
public class InscricaoDao extends Dao<Inscricao, Integer> implements Serializable {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String FIND_ALL = """
            SELECT * FROM tblinscricoes i
            JOIN tblalunos a ON i.CodigoDoAluno = a.CodigoDoAluno
            JOIN tblfuncionarios f ON i.CodigoDoFuncionario = f.CodigoDoFuncionario
            JOIN tbldetalhesdainscricao d ON i.CodigoDaInscricao = d.CodigoDaInscricao
            JOIN tblfuncionarios p ON d.CodigoDoProfessor = p.CodigoDoFuncionario
            """;
    private static final String FIND_BY_ID = """
            SELECT * FROM tblinscricoes i
            JOIN tblalunos a ON i.CodigoDoAluno = a.CodigoDoAluno
            JOIN tblfuncionarios f ON i.CodigoDoFuncionario = f.CodigoDoFuncionario
            JOIN tbldetalhesdainscricao d ON i.CodigoDaInscricao = d.CodigoDaInscricao
            JOIN tblfuncionarios p ON d.CodigoDoProfessor = p.CodigoDoFuncionario
            WHERE i.CodigoDaInscricao = ?
            """;

    public static void populateFields(Inscricao inscricao, ResultSet rs) throws SQLException {
        inscricao.setCodigo(rs.getInt("CodigoDaInscricao"));
        inscricao.setData(rs.getDate("DataDaInscricao").toLocalDate());
    }

    private static void populateAluno(Inscricao inscricao, ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        AlunoDao.populateFields(aluno, rs);
        inscricao.setAluno(aluno);
    }

    private static void populateFuncionario(Inscricao inscricao, ResultSet rs, String field) throws SQLException {
        FuncionarioDao dao = new FuncionarioDao();
        dao.findById(rs.getInt(field))
                .ifPresent(inscricao::setFuncionario);
    }

    @Override
    public List<Inscricao> findAll() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, FIND_ALL);
            while (rs.next()) {
                Inscricao inscricao = new Inscricao();
                populateFields(inscricao, rs);
                populateAluno(inscricao, rs);
                populateFuncionario(inscricao, rs, "CodigoDoFuncionario");
                populateFuncionario(inscricao, rs, "CodigoDoProfessor");
                inscricoes.add(inscricao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listas as inscrições: " + msg);
        }
        return inscricoes;
    }

    @Override
    public Optional<Inscricao> findById(Integer codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, FIND_BY_ID, codigo);
            if (rs.next()) {
                Inscricao inscricao = new Inscricao();
                populateFields(inscricao, rs);
                populateAluno(inscricao, rs);
                populateFuncionario(inscricao, rs, "CodigoDoFuncionario");
                populateFuncionario(inscricao, rs, "CodigoDoProfessor");
                return Optional.of(inscricao);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listas as inscrições: " + msg);
        }
        return Optional.empty();
    }

    @Override
    public List<Inscricao> search(Object param) {
        return List.of();
    }
}

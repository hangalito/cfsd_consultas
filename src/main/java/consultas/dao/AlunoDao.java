package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Aluno;
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
public class AlunoDao extends Dao<Aluno, Integer> implements Serializable {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static void populateFields(Aluno aluno, ResultSet rs) throws SQLException {
        aluno.setCodigo(rs.getInt("CodigoDoAluno"));
        aluno.setNome(rs.getString("NomeDoAluno"));
        aluno.setTelefone(rs.getString("TelefoneDoAluno"));
        aluno.setMorada(rs.getString("MoradaDoAluno"));
        aluno.setLocalDeNascimento(rs.getString("LocalDeNascimentoDoAluno"));
        aluno.setHabilitacoesLiterarias(rs.getString("HabilitacoesLiterariasDoAluno"));
        aluno.setSexo(rs.getString("SexoDoAluno"));
        aluno.setOutrosDados(rs.getString("OutrosdadosdoAluno"));
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, "SELECT * FROM tblalunos");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                populateFields(aluno, rs);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar os alunos: " + msg);
        }
        return alunos;
    }

    @Override
    public Optional<Aluno> findById(Integer codigo) {
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, "SELECT * FROM tblalunos WHERE CodigoDoAluno = ?", codigo);
            if (rs.next()) {
                Aluno aluno = new Aluno();
                populateFields(aluno, rs);
                return Optional.of(aluno);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar o aluno de código " + codigo + ": " + msg);
        }
        return Optional.empty();
    }

    public List<Aluno> findByName(String name) {
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            String param = "%" + name + "%";
            ResultSet rs = query(conn, "SELECT * FROM tblalunos WHERE NomeDoAluno LIKE ?", param);
            while (rs.next()) {
                Aluno aluno = new Aluno();
                populateFields(aluno, rs);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao pesquisar por nome: " + msg);
        }
        return alunos;
    }

    public List<Aluno> search(Object param) {
        String sql = """
                     SELECT * FROM tblalunos
                     WHERE CodigoDoAluno LIKE ?
                     OR NomeDoAluno LIKE ?
                     OR TelefoneDoAluno LIKE  ?
                     """;
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            String format = "%" + param + "%";
            ResultSet rs = query(conn, sql, format, format, format);
            while (rs.next()) {
                Aluno aluno = new Aluno();
                populateFields(aluno, rs);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao pesquisar por alunos: " + msg);
        }
        return alunos;
    }
}

package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.exceptions.NoResultException;
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
    private static final String SQL_FIND_ALL = "SELECT * FROM TblAlunos";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM TblAlunos WHERE CodigoDoAluno = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM TblAlunos WHERE NomeDoAluno LIKE ?";
    private static final String SQL_SEARCH = """
            SELECT * FROM TblAlunos
            WHERE CodigoDoAluno LIKE ?
            OR NomeDoAluno LIKE ?
            OR TelefoneDoAluno LIKE  ?
            """;

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
    public List<Aluno> findAll() throws SQLException, NoResultException {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        ResultSet rs = query(conn, SQL_FIND_ALL);
        while (rs.next()) {
            Aluno aluno = new Aluno();
            populateFields(aluno, rs);
            alunos.add(aluno);
        }
        if (alunos.isEmpty()) {
            throw new NoResultException("Nenhum aluno registada");
        }
        rs.close();
        return alunos;
    }

    @Override
    public Optional<Aluno> findById(Integer codigo) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        ResultSet rs = query(conn, SQL_FIND_BY_ID, codigo);
        if (rs.next()) {
            Aluno aluno = new Aluno();
            populateFields(aluno, rs);
            return Optional.of(aluno);
        }
        rs.close();
        return Optional.empty();
    }

    public List<Aluno> findByName(String name) throws SQLException, NoResultException {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        String param = (' ' + name + ' ').replace(' ', '%');
        ResultSet rs = query(conn, SQL_FIND_BY_NAME, param);
        while (rs.next()) {
            Aluno aluno = new Aluno();
            populateFields(aluno, rs);
            alunos.add(aluno);
        }
        rs.close();
        if (alunos.isEmpty()) {
            throw new NoResultException("Nenhum aluno com o nome " + name + " encontrada");
        }
        return alunos;
    }

    @Override
    public List<Aluno> search(Object param) throws SQLException, NoResultException {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        String format = (" " + param + " ").replace(" ", "%");
        ResultSet rs = query(conn, SQL_SEARCH, format, format, format);
        while (rs.next()) {
            Aluno aluno = new Aluno();
            populateFields(aluno, rs);
            alunos.add(aluno);
        }
        rs.close();
        if (alunos.isEmpty()) {
            throw new NoResultException("Nenhum aluno encontrado");
        }
        return alunos;
    }

}

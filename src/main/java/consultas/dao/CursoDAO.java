package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Curso;
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
 * @author <a href="mailto:caludiomendonca.operclaudio01@gmail.com">Cláudio
 * Mendonça</a>
 */
@Stateless
@SuppressWarnings("unused")
public class CursoDao extends Dao<Curso, String> {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final Comparator<Curso> COMPARATOR = Comparator.comparing(Curso::getName).thenComparing(Curso::getPreco);

    private static final String LIST_ALL = "SELECT * FROM tblcursos";
    private static final String LIST_BY_ID = "SELECT * FROM tblcursos WHERE CodigoDoCurso = ?";
    private static final String LIST_BY_NAME = "SELECT * FROM tblcursos WHERE NomeDoCurso = ?";
    private static final String SEARCH_QUERY = """
                                               SELECT * FROM tblcursos
                                               WHERE CodigoDoCurso LIKE ?
                                               OR NomeDoCurso LIKE ?
                                               OR PrecoUnitario LIKE ?
                                               """;

    public static void populatFields(Curso curso, ResultSet rs) throws SQLException {
        curso.setCodigo(rs.getString("CodigoDoCurso"));
        curso.setName(rs.getString("NomeDoCurso"));
        curso.setPreco(rs.getDouble("PrecoUnitario"));
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        try (Connection con = DBConecta.getConexao()) {
            ResultSet rs = query(con, LIST_ALL);
            while (rs.next()) {
                var curso = new Curso();
                populatFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro de leitura de dados: " + msg);
        }
        cursos.sort(COMPARATOR);
        return cursos;
    }

    @Override
    public Optional<Curso> findById(String id) {
        try (Connection conn = DBConecta.getConexao()) {
            ResultSet rs = query(conn, LIST_BY_ID, id);
            if (rs.next()) {
                Curso curso = new Curso();
                populatFields(curso, rs);
                return Optional.of(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar cursos por ID: " + msg);
        }
        return Optional.empty();
    }

    @Override
    public List<Curso> search(Object param) {
        List<Curso> cursos = new ArrayList<>();
        try (Connection conn = DBConecta.getConexao()) {
            String sql = "%" + param + "%";
            ResultSet rs = query(conn, SEARCH_QUERY, sql, sql, sql);
            while (rs.next()) {
                Curso curso = new Curso();
                populatFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao pesquisar cursos: " + msg);
        }
        cursos.sort(COMPARATOR);
        return cursos;
    }

}

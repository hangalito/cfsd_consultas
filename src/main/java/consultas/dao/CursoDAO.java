package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Curso;
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

@Stateless
public class CursoDao extends Dao<Curso, String> {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static void populateFields(Curso curso, ResultSet rs) throws SQLException {
        curso.setCodigo(rs.getString("CodigoDoCurso"));
        curso.setDescricao(rs.getString("NomeDoCurso"));
        curso.setPreco(rs.getDouble("PrecoUnitario"));
    }

    @Override
    public List<Curso> findAll() {
        var cursos = new ArrayList<Curso>();
        try (Connection conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblcursos");
            while (rs.next()) {
                Curso curso = new Curso();
                populateFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao listar os cursos na base de dados: " + msg);
        }
        return cursos;
    }

    @Override
    public Optional<Curso> findById(String id) {
        try (var conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblcursoso WHERE CodigoDoCurso = ?", id);
            if (rs.next()) {
                Curso curso = new Curso();
                populateFields(curso, rs);
                return Optional.of(curso);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao consultar a turma com o código " + id + ": " + msg);
        }
        return Optional.empty();
    }

    public List<Curso> findByName(String name) {
        var cursos = new ArrayList<Curso>();
        try (var conn = DBConecta.getConexao()) {
            var rs = query(conn, "SELECT * FROM tblcursos WHERE NomeDoCurso = ?", name);
            while (rs.next()) {
                Curso curso = new Curso();
                populateFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            var msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao pesquisar cursos de nome " + name + ": " + msg
            );
        }
        return cursos;
    }
}

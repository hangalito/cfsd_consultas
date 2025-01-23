package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Curso;
import jakarta.ejb.Stateless;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:caludiomendonca.operclaudio01@gmail.com">Cláudio
 * Mendonça</a>
 */
@Stateless
public class CursoDao {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static final String LIST_ALL = "SELECT * FROM TblCursos";
    public static final String LIST_BY_ID = "SELECT * FROM TblCursos WHERE CodigoDoCurso = ?";
    public static final String LIST_BY_NAME = "SELECT * FROM TblCursos WHERE NomeDoCurso LIKE ?";

    public static void populateFields(Curso curso, ResultSet rs) throws SQLException {
        curso.setCodigo(rs.getString("CodigoDoCurso"));
        curso.setName(rs.getString("NomeDoCurso"));
        curso.setPreco(rs.getDouble("PrecoUnitario"));

    }

    public List<Curso> selectAll() {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                var curso = new Curso();
                populateFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro de leitura de dados: " + msg);
        }

        return cursos;
    }

    public Optional<Curso> selectById(Integer codigo) {
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_BY_ID);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso();
                return Optional.of(curso);
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro de leitura de dados: " + msg);
        }

        return Optional.empty();
    }

    public List<Curso> selectByName(String name) {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_BY_NAME);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                var curso = new Curso();
                populateFields(curso, rs);
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex, () -> "Erro de leitura de dados: " + ex.getLocalizedMessage());
        }

        return cursos;

    }
}

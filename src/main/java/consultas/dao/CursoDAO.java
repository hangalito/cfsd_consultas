package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Curso;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author <a href="mailto:caludiomendonca.operclaudio01@gmail.com">Cláudio Mendonça</a>
 * 
 */
@Stateless
public class CursoDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static final String LIST_ALL = "select * from tblcursos";
    public static final String LIST_BY_ID = "select * from tblcursos where CodigoDoCurso = ?";
    public static final String LIST_BY_NAME = "select CodigoDoCurso, NomeDoCurso, PrecoUnitario from tblcursos where NomeDoCurso = ?";
    
    public static void populatFields(Curso curso, ResultSet rs) throws SQLException {
        curso.setCodigo(rs.getInt("CodigoDoCurso"));
        curso.setName(rs.getString("NomeDoCurso"));
        curso.setPreco(rs.getDouble("PrecoUnitario"));
        
    }

    /**
     *
     * @return 
     * @mostra lista contendo todos os cursos da dase de dados
     * @mostra lista contendo apenas o curso especificado por codigo
     * @mostra lista contendo apenas o curso especificado por nome
     */
    public List<Curso> selectAll() {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                var curso = new Curso();
                populatFields(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de leitura de dados" + ex.getLocalizedMessage());
        }
        return cursos;
    }
    
    public Optional<Curso> selectById(Integer codigo) {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_BY_ID);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                var curso = new Curso();
                return Optional.of(curso);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro de leitura de dados" + ex.getLocalizedMessage());
        }
        
        return Optional.empty();
    }

    public List<Curso> selectByName(String name) {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                var curso = new Curso();
                populatFields(curso, rs);
                cursos.add(curso);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro de leitura de dados" + ex.getLocalizedMessage());
        }
        
        return cursos;
        
    }    
}

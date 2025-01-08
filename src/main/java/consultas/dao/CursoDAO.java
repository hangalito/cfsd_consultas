package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static final String LIST_ALL = "select * from tblcursos";

    public List<Curso> listaTodos() {
        List<Curso> cursos = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
            Curso cur = new Curso();
            cur.setCodigo(rs.getInt("CodigoDoCurso"));
            cur.setDescricao(rs.getString("NomeDoCurso"));
            cur.setPreco(rs.getDouble("PrecoUnitario"));
            cursos.add(cur);
            }
        } catch (Throwable ex) {
            System.err.println("Erro de leitura de dados" + ex.getMessage());
        }
        return cursos;
    }
}

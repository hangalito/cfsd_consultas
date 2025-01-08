package consultas.dao;

import consultas.dbconexao.DBConecta;
import consultas.modelo.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private static final String LIST_ALL = "select * from tblturmas";

    public List<Turma> listarTodos() {
        List<Turma> turmas = new ArrayList<>();
        try {
            con = DBConecta.getConexao();
            ps = con.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()){
            Turma tur = new Turma();
            tur.setCodigo(rs.getString("CodigoDaTurma"));
            tur.setDescricao(rs.getString("NomeDaTurma"));
            turmas.add(tur);
            }
        } catch (Throwable ex) {
            System.err.println("Erro de leitura de dados" + ex.getMessage());
        }
        return turmas;
    }
}

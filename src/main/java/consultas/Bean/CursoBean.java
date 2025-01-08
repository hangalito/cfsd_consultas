package consultas.Bean;

import consultas.dao.CursoDAO;
import consultas.modelo.Curso;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "cursoBean")
@SessionScoped
public class CursoBean implements Serializable {

    private Curso curso = new Curso();
    private CursoDAO cursoDAO = new CursoDAO();
    private List<Curso> cursos = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        cursos = cursoDAO.listaTodos();
        
        

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

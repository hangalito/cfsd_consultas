package consultas.Bean;

import consultas.dao.CursoDao;
import consultas.modelo.Curso;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "cursoBean")
@RequestScoped
public class CursoBean implements Serializable {

    private Curso curso = new Curso();
    private CursoDao cursoDAO = new CursoDao();
    private List<Curso> cursos = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        cursos = cursoDAO.findAll();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoDao getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDao cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

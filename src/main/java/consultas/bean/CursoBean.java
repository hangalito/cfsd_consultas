package consultas.bean;

import consultas.dao.CursoDao;
import consultas.modelo.Curso;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author <a href="mailto:claudiomendonca.operclaudio01@gmail.com">Cláudio
 * Mendonça</a>
 * CDI responsável pela conexão da classe lógica a classe de visão Aqui são
 * definidos os métodos que serão carregados nas páginas
 */
@Named(value = "cursoBean")
@RequestScoped
public class CursoBean implements Serializable {

    private List<Curso> cursosPesquisados;
    @Inject
    private CursoDao cursoDAO;
    private String nome;
    private Curso curso = new Curso();
    private List<Curso> cursos;

    @PostConstruct
    public void init() {
        cursos = cursoDAO.selectAll();

    }

    public void buscarPorNome() {
        cursosPesquisados = cursoDAO.selectByName(nome);
    }

    public List<Curso> getCursosPesquisados() {
        return cursosPesquisados;
    }

    public void setCursosPesquisados(List<Curso> cursosPesquisados) {
        this.cursosPesquisados = cursosPesquisados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

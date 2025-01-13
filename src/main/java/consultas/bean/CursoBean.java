package consultas.Bean;

import consultas.dao.CursoDAO;
import consultas.modelo.Curso;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author <a href="mailto:claudiomendonca.operclaudio01@gmail.com">Cláudio Mendonça</a>
 * CDI responsável pela conexão da classe lógica a classe de visão
 * Aqui são definidos os métodos que serão carregados nas páginas
 */

@Named(value = "cursoBean")
@RequestScoped
public class CursoBean implements Serializable {

    
    
    private List<Curso> cursosPesquisados;
    @Inject
    private CursoDAO cursoDAO ;
    private String nome;
    private Curso curso = new Curso();
    private List<Curso> cursos;
    
    
    @PostConstruct
    public void init(){
        cursos = cursoDAO.selectAll();
    
    }
    public String buscarPorNome(){
            cursosPesquisados = cursoDAO.selectByName(nome);
            return null;
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

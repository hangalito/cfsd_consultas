package consultas.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

import consultas.dao.AlunoDao;
import consultas.modelo.Aluno;
import org.primefaces.PrimeFaces;

@Named(value = "alunoBean")
@RequestScoped
public class AlunoBean implements Serializable {

    @Inject
    private AlunoDao alunoDao;
    private List<Aluno> alunos;
    private List<Aluno> alunosPesquisados;
    private String nome;

    @PostConstruct
    public void init() {
        alunos = alunoDao.findAll();
    }

    public void pesquisarPorNome() {
        var searchedStudents = alunoDao.search(nome);
        alunosPesquisados = searchedStudents;
        PrimeFaces.current().ajax().update("tables-form:dt-alunos");
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunosPesquisados() {
        return alunosPesquisados;
    }

    public void setAlunosPesquisados(List<Aluno> alunosPesquisados) {
        this.alunosPesquisados = alunosPesquisados;
    }

}

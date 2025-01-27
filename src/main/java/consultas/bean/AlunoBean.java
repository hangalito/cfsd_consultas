package consultas.bean;

import consultas.dao.AlunoDao;
import consultas.modelo.Aluno;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named(value = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable {

    @Inject
    private AlunoDao alunoDao;
    private List<Aluno> alunos;
    private List<Aluno> alunosPesquisados;
    private String nome;
    private Aluno alunoSelecionado;

    @PostConstruct
    public void init() {
        alunos = alunoDao.findAll();
    }

    public void pesquisarPorNome() {
        alunosPesquisados = alunoDao.search(nome);
        PrimeFaces.current().ajax().update("tables-form:dt-alunos");
    }

    public void load() {
        assert alunoSelecionado != null;
        alunoSelecionado.fetchSubscriptions();
    }

    public String findCourse() {
        String courses = "";
        for (var inscricao : alunoSelecionado.getInscricoes()) {
            courses = inscricao.getDetalhes()
                    .stream()
                    .map(detail -> detail.getCurso().getName())
                    .collect(Collectors.joining(", "));
        }
        return courses;
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

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }
}

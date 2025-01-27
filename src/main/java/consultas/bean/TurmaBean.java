package consultas.bean;

import consultas.dao.TurmaDao;
import consultas.modelo.Turma;
import static consultas.util.LoggingUtil.debug;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.primefaces.PrimeFaces;

@Named(value = "turmaBean")
@SessionScoped
public class TurmaBean implements Serializable {

    private List<Turma> turmasPesquisadas;
    @Inject
    private TurmaDao dao;
    private String name;
    private Turma turma;
    private List<Turma> turmas;

    @PostConstruct
    public void inicializar() {
        turmas = dao.findAll();
    }

    public void loadStudents() {
        assert turma == null : "Selected class point to null value";
        turma.fetchStudents();
    }

    public List<Turma> getTurmasPesquisadas() {
        return turmasPesquisadas;
    }

    public void setTurmasPesquisadas(List<Turma> turmasPesquisadas) {
        this.turmasPesquisadas = turmasPesquisadas;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String buscarPorNome() {
        this.turmasPesquisadas = dao.search(name);
        PrimeFaces.current().ajax().update("tabelas:tbTurmas");
        return null;
    }

    public TurmaDao getDao() {
        return dao;
    }

    public void setDao(TurmaDao dao) {
        this.dao = dao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        debug("Classe set: {0}", this.turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}

package consultas.bean;

import consultas.dao.TurmaDao;
import consultas.modelo.Turma;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "turmaBean")
@SessionScoped
public class TurmaBean implements Serializable {

    private List<Turma> turmasPesquisadas;
    @Inject
    private String name;
    private TurmaDao dao;
    private Turma turma = new Turma();
    private List<Turma> turmas;

    @PostConstruct
    public void inicializar() {
        turmas = dao.findAll();
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
    
    public String buscarPorNome(){
        turmasPesquisadas = dao.findByName(name);
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
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}

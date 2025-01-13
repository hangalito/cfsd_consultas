package consultas.Bean;

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

    @Inject
    private TurmaDao dao;
    private Turma turma = new Turma();
    private List<Turma> turmas = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        turmas = dao.findAll();
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

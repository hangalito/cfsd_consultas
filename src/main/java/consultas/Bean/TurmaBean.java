
package consultas.Bean;

import consultas.dao.TurmaDAO;
import consultas.modelo.Turma;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value = "turmaBean")
@SessionScoped
public class TurmaBean implements Serializable {


  private Turma turma = new Turma();
  private TurmaDAO turmaDAO = new TurmaDAO();
  private List<Turma> turmas = new ArrayList<>();
  
  @PostConstruct
  public void inicializar(){
      turmas = turmaDAO.listarTodos();
  }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public TurmaDAO getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

  
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
  
  
}

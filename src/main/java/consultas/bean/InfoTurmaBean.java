package consultas.bean;

import consultas.dao.TurmaDao;
import consultas.modelo.Turma;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import static org.jfree.util.Log.debug;
import org.primefaces.PrimeFaces;

@Named(value = "infoTurmaBean")
@RequestScoped
public class InfoTurmaBean {

    @Inject
    private TurmaDao dao;
    private Turma turma;
    private String codigo;

    public void search() {
        dao.findById(codigo).ifPresentOrElse(turma -> {
            setTurma(turma);
            this.turma.fetchTeacher();
            this.turma.fetchStudents();
            PrimeFaces.current().ajax().update("result:dt-alunos", "result:basic-details");
            debug("Aluno encontrado");

        }, this::classNotFound);
    }

    private void classNotFound() {
        var severity = FacesMessage.SEVERITY_WARN;
        var summary = "Consultar turma";
        var detail = "Não foi encontrada nenhuma turma com o código: " + codigo;
        var message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().update("top:messages");
        debug("Aluno não encontrado");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}

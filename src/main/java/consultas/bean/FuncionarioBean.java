package consultas.bean;

import consultas.dao.FuncionarioDao;
import consultas.modelo.Funcionario;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;

@Named(value = "funcionarioBean")
@ViewScoped
public class FuncionarioBean implements Serializable {

    @Inject
    FuncionarioDao funcionarioDao;
    private List<Funcionario> funcionarios;
    private List<Funcionario> resultadoDaPesquisa = new ArrayList<>();
    private String query;

    @PostConstruct
    public void init() {
        funcionarios = funcionarioDao.findAll();
    }

    public void pesquisar() {
        resultadoDaPesquisa = funcionarioDao.search(query);
        if (resultadoDaPesquisa.isEmpty()) {
            var severity = FacesMessage.SEVERITY_WARN;
            var summary = "Pesquisar funcionários";
            var detail = "Nenhum funcionário encontrado";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
            PrimeFaces.current().ajax().update("top:messages");
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getResultadoDaPesquisa() {
        return resultadoDaPesquisa;
    }

    public void setResultadoDaPesquisa(List<Funcionario> resultadoDaPesquisa) {
        this.resultadoDaPesquisa = resultadoDaPesquisa;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

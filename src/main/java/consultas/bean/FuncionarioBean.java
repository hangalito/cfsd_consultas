package consultas.bean;

import consultas.dao.FuncionarioDao;
import consultas.modelo.Funcionario;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.PrimeFaces;

@Named(value = "funcionarioBean")
@RequestScoped
public class FuncionarioBean {

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
        PrimeFaces.current().ajax().update("dt-funcionarios");
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

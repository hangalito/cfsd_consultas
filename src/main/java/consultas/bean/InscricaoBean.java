package consultas.bean;

import consultas.dao.InscricaoDao;
import consultas.modelo.Inscricao;
import static consultas.util.LoggingUtil.debug;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Named(value = "inscricaoBean")
@RequestScoped
public class InscricaoBean {

    @Inject
    private InscricaoDao dao;
    private LocalDate start;
    private LocalDate end;
    private List<Inscricao> inscricoes = new ArrayList<>();
    private Inscricao inscricao;

    public void search() {
        inscricoes = dao.findBetweenDates(start, end);
    }

    public String select(Inscricao inscricao) {
        this.inscricao = inscricao;
        return select();
    }

    public String select() {
        debug("Inscrição selecionada: {0}", this.inscricao);
        return "detalhes-da-inscricao.faces";
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

}

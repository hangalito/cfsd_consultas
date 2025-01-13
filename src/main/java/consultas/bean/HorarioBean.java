package consultas.bean;

import consultas.dao.HorarioDao;
import consultas.modelo.Horario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

/**
 * CDI Managed Bean responsável por interligar a camada lógica à
 * camada de visão
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
@Named("horarioBean")
@RequestScoped
public class HorarioBean {
    @Inject
    private HorarioDao horarioDAO;
    private List<Horario> horarios;

    protected void init() {
        horarios = horarioDAO.findAll();
    }

    /**
     * Get horarios
     *
     * @return {@link List} of {@link Horario}
     */
    public List<Horario> getHorarios() {
        return horarios;
    }

    /**
     * Set horarios
     *
     * @param horarios {@link List} of {@link Horario}
     */
    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}

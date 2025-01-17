package consultas.bean;

import consultas.dao.HorarioDao;
import consultas.modelo.Horario;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

/**
 * CDI Managed Bean responsável por interligar a camada lógica à camada de visão
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
@Named(value = "horarioBean")
@ViewScoped
public class HorarioBean implements Serializable {

    @Inject
    private HorarioDao horarioDAO;
    private List<Horario> horarios;

    @PostConstruct
    protected void init() {
        Logger.getLogger(MethodHandles.lookup().lookupClass().getName())
                .info("Initializing HorarioBean class");
        horarios = horarioDAO.findAll();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}

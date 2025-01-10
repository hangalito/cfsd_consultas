package consultas.cdi;

import consultas.dao.HorarioDao;
import consultas.modelo.Horario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named(value="timetableBean")
@RequestScoped
public class TimeTableBean {
    @Inject private HorarioDao dao;
    private List<Horario> horarios;

    @PostConstruct
    public void init() {
        horarios = dao.findAll();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}

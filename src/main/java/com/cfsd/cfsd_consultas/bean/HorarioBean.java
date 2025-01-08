package com.cfsd.cfsd_consultas.bean;

import com.cfsd.cfsd_consultas.dao.HorarioDao;
import com.cfsd.cfsd_consultas.modelo.Horario;
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
    private HorarioDao dao;
    private List<Horario> horarios;

    @PostConstruct
    protected void init() {
        horarios = dao.findAll();
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

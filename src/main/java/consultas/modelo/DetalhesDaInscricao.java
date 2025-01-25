package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe <i>wrapper</i> para a dos detalhes das inscrições.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
public class DetalhesDaInscricao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;;
    private Turma turma;
    private Horario horario;
    private Funcionario professor;
    private LocalDateTime dataDeInicio;
    private LocalDateTime dataDeFim;
    private Double valorPago;
    private Double valorPago2;
    private String obs;
    private Integer notaFinal;
    private Curso curso;

    public DetalhesDaInscricao() {
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }

    public LocalDateTime getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDateTime dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDateTime getDataDeFim() {
        return dataDeFim;
    }

    public void setDataDeFim(LocalDateTime dataDeFim) {
        this.dataDeFim = dataDeFim;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorPago2() {
        return valorPago2;
    }

    public void setValorPago2(Double valorPago2) {
        this.valorPago2 = valorPago2;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        DetalhesDaInscricao that = (DetalhesDaInscricao) o;
        return Objects.equals(turma, that.turma) && Objects.equals(horario, that.horario) && Objects.equals(professor, that.professor) && Objects.equals(dataDeInicio, that.dataDeInicio) && Objects.equals(dataDeFim, that.dataDeFim) && Objects.equals(valorPago, that.valorPago) && Objects.equals(valorPago2, that.valorPago2) && Objects.equals(obs, that.obs) && Objects.equals(notaFinal, that.notaFinal) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(turma);
        result = 31 * result + Objects.hashCode(horario);
        result = 31 * result + Objects.hashCode(professor);
        result = 31 * result + Objects.hashCode(dataDeInicio);
        result = 31 * result + Objects.hashCode(dataDeFim);
        result = 31 * result + Objects.hashCode(valorPago);
        result = 31 * result + Objects.hashCode(valorPago2);
        result = 31 * result + Objects.hashCode(obs);
        result = 31 * result + Objects.hashCode(notaFinal);
        result = 31 * result + Objects.hashCode(curso);
        return result;
    }

    @Override
    public String toString() {
        return "DetalhesDaInscricao{" +
                "turma=" + turma +
                ", horario=" + horario +
                ", professor=" + professor +
                ", dataDeInicio=" + dataDeInicio +
                ", dataDeFim=" + dataDeFim +
                ", valorPago=" + valorPago +
                ", valorPago2=" + valorPago2 +
                ", obs='" + obs + '\'' +
                ", notaFinal=" + notaFinal +
                ", curso=" + curso +
                '}';
    }
}

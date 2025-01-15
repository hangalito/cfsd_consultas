package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblinscricoes`}
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
public class Inscricao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private LocalDate data;
    private Aluno aluno;
    private Funcionario funcionario;
    private Curso curso;
    private Turma turma;
    private Horario horario;
    private Funcionario professor;

    public Inscricao() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Inscricao inscricao = (Inscricao) object;
        return Objects.equals(codigo, inscricao.codigo) && Objects.equals(data, inscricao.data) && Objects.equals(aluno, inscricao.aluno) && Objects.equals(funcionario, inscricao.funcionario) && Objects.equals(curso, inscricao.curso) && Objects.equals(turma, inscricao.turma) && Objects.equals(horario, inscricao.horario) && Objects.equals(professor, inscricao.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, data, aluno, funcionario, curso, turma, horario, professor);
    }

    @Override
    public String toString() {
        return "Inscrição{" +
                "código=" + codigo +
                ", data=" + data +
                ", aluno=" + aluno +
                ", funcionário=" + funcionario +
                ", curso=" + curso +
                ", turma=" + turma +
                ", horário=" + horario +
                ", professor=" + professor +
                '}';
    }
}

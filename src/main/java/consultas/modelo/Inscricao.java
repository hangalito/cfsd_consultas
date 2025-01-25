package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblinscricoes`}
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
public class Inscricao implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private Integer codigo;
    private LocalDate data;
    private Aluno aluno;
    private Funcionario funcionario;
    private List<DetalhesDaInscricao> detalhes;

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

    public List<DetalhesDaInscricao> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalhesDaInscricao> detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inscricao inscricao = (Inscricao) o;
        return Objects.equals(codigo, inscricao.codigo) && Objects.equals(data, inscricao.data) && Objects.equals(aluno, inscricao.aluno) && Objects.equals(funcionario, inscricao.funcionario) && Objects.equals(detalhes, inscricao.detalhes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, data, aluno, funcionario, detalhes);
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "codigo=" + codigo +
                ", data=" + data +
                ", aluno=" + aluno +
                ", funcionario=" + funcionario +
                '}';
    }

    public void addDetail(DetalhesDaInscricao detalhesDaInscricao) {
        if (detalhes == null) {
            detalhes = new ArrayList<>();
        }
        detalhes.add(detalhesDaInscricao);
    }

    public void removeDetail(DetalhesDaInscricao detalhesDaInscricao) {
        if (detalhes != null) {
            detalhes.remove(detalhesDaInscricao);
        }
    }
}

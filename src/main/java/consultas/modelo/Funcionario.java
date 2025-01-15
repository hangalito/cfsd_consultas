package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblfuncionarios`} na base de
 * dados.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">
 * Bartolomeu Hangalo</a>
 */
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nome;
    private LocalDate dataDeNascimento;
    private LocalDate dataDeAdmissao;

    public Funcionario() {
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.dataDeNascimento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.dataDeNascimento, other.dataDeNascimento);
    }

    @Override
    public String toString() {
        return "Professor{" + "codigo=" + codigo + ", nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", dataDeAdmissao=" + dataDeAdmissao + '}';
    }

}

package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblOperacoes`}
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
public class Operacao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer chave;
    private String codigo;
    private String nome;

    public Operacao() {
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.length() > 50) {
            throw new IllegalArgumentException("O código de uma operação deve conter apenas 50 caracteres");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new IllegalArgumentException("O nome de uma operação deve conter apenas 50 caracteres");
        }
        this.nome = nome;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Operacao operacao = (Operacao) object;
        return Objects.equals(chave, operacao.chave) && Objects.equals(codigo, operacao.codigo) && Objects.equals(nome, operacao.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chave, codigo, nome);
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "chave=" + chave +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}

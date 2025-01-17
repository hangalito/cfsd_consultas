package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblHorarios`}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
public class Horario implements Serializable, Comparable<Horario> {

    @Serial
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nome;

    public Horario() {
    }

    public Horario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws IllegalArgumentException {
        if (codigo.length() > 50) {
            throw new IllegalArgumentException("O código de um horário deve conter apenas 50 caracteres");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new IllegalArgumentException("O nome de um horário deve conter apenas 50 caracteres");
        }
        this.nome = nome;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Horario horario = (Horario) object;
        return Objects.equals(codigo, horario.codigo) && Objects.equals(nome, horario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome);
    }

    @Override
    public String toString() {
        return "Horario{"
                + "codigo='" + codigo + '\''
                + ", nome='" + nome + '\''
                + '}';
    }

    @Override
    public int compareTo(Horario other) {
        return this.nome.compareTo(other.nome);
    }
}

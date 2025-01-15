package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblalunos`}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">
 * Bartolomeu Hangalo</a>
 */
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String nome;
    private String telefone;
    private String morada;
    private String localDeNascimento;
    private String nacionalidade;
    private String havilitacoesLiterarias;
    private String sexo;
    private String outrosDados;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalDeNascimento() {
        return localDeNascimento;
    }

    public void setLocalDeNascimento(String localDeNascimento) {
        this.localDeNascimento = localDeNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getHavilitacoesLiterarias() {
        return havilitacoesLiterarias;
    }

    public void setHavilitacoesLiterarias(String havilitacoesLiterarias) {
        this.havilitacoesLiterarias = havilitacoesLiterarias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOutrosDados() {
        return outrosDados;
    }

    public void setOutrosDados(String outrosDados) {
        this.outrosDados = outrosDados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.morada);
        hash = 37 * hash + Objects.hashCode(this.localDeNascimento);
        hash = 37 * hash + Objects.hashCode(this.nacionalidade);
        hash = 37 * hash + Objects.hashCode(this.havilitacoesLiterarias);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Objects.hashCode(this.outrosDados);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.localDeNascimento, other.localDeNascimento)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.havilitacoesLiterarias, other.havilitacoesLiterarias)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.outrosDados, other.outrosDados)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }
    
    

}

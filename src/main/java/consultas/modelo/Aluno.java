package consultas.modelo;

import consultas.dao.InscricaoDao;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Classe responsável por mapear a tabela {@code `tblalunos`}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">
 * Bartolomeu Hangalo</a>
 */
public class Aluno implements Serializable, Comparable<Aluno> {

    @Serial
    private static final long serialVersionUID = 2L;

    private Integer codigo;
    private String nome;
    private String telefone;
    private String morada;
    private String localDeNascimento;
    private String nacionalidade;
    private String habilitacoesLiterarias;
    private String sexo;
    private String outrosDados;

    private List<Inscricao> inscricoes;

    public Aluno() {
    }

    public Aluno(Integer codigo) {
        this.codigo = codigo;
    }

    public Aluno(String nome) {
        this.nome = nome;
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

    public String getHabilitacoesLiterarias() {
        return habilitacoesLiterarias;
    }

    public void setHabilitacoesLiterarias(String habilitacoesLiterarias) {
        this.habilitacoesLiterarias = habilitacoesLiterarias;
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

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Aluno aluno = (Aluno) object;
        return Objects.equals(codigo, aluno.codigo) && Objects.equals(nome, aluno.nome) && Objects.equals(telefone, aluno.telefone) && Objects.equals(morada, aluno.morada) && Objects.equals(localDeNascimento, aluno.localDeNascimento) && Objects.equals(nacionalidade, aluno.nacionalidade) && Objects.equals(habilitacoesLiterarias, aluno.habilitacoesLiterarias) && Objects.equals(sexo, aluno.sexo) && Objects.equals(outrosDados, aluno.outrosDados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, telefone, morada, localDeNascimento, nacionalidade, habilitacoesLiterarias, sexo, outrosDados);
    }

    @Override
    public String toString() {
        return "Aluno{"
                + "codigo=" + codigo
                + ", nome='" + nome + '\''
                + ", telefone='" + telefone + '\''
                + ", morada='" + morada + '\''
                + ", localDeNascimento='" + localDeNascimento + '\''
                + ", nacionalidade='" + nacionalidade + '\''
                + ", habilitacoesLiterarias='" + habilitacoesLiterarias + '\''
                + ", sexo='" + sexo + '\''
                + ", outrosDados='" + outrosDados + '\''
                + '}';
    }

    @Override
    public int compareTo(Aluno other) {
        return this.nome.compareTo(other.nome);
    }

    public void fetchSubscriptions() {
        setInscricoes(new InscricaoDao().findByStudent(this));
    }
}

package com.cfsd.cfsd_consultas.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe responsável por mapear a tabela {@code `tblTurmas`}
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu Hangalo</a>
 */
public class Turma implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nome;

    public Turma() {
    }

    public Turma(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws IllegalArgumentException {
        if (codigo.length() > 50) {
            throw new IllegalArgumentException("O código da turma deve conter apenas 50 caracteres");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new IllegalArgumentException("O nome de uma turma deve conter apenas 50 caracteres");
        }
        this.nome = nome;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Turma turma = (Turma) object;
        return Objects.equals(codigo, turma.codigo) && Objects.equals(nome, turma.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}

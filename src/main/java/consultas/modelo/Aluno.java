package consultas.modelo;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe responsável por mapear a tabela {@code `tblalunos`}.
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">
 * Bartolomeu Hangalo</a>
 */
public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    Integer codigo;
    String nome;
    String telefone;
    String morada;
    String localDeNascimento;
    String nacionalidade;
    String havilitacoesLiterarias;
    String sexo;
    String outrosDados;

}

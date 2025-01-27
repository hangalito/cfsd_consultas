package consultas.dao;

import consultas.modelo.Aluno;
import consultas.modelo.Inscricao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscricaoDaoTest {

    static InscricaoDao dao;

    @BeforeAll
    static void setUp() {
        dao = new InscricaoDao();
    }

    @Test
    public void testFindBetweenDates() {
        var start = LocalDate.of(2020, 1, 1);
        var end = LocalDate.of(2020, 12, 31);
        var dao = new InscricaoDao();
        var subscriptions = dao.findBetweenDates(start, end);
        boolean isBound = true;

        for (consultas.modelo.Inscricao subscription : subscriptions) {
            if (subscription.getData().isBefore(start) || subscription.getData().isAfter(end)) {
                isBound = false;
                break;
            }
        }
        assertTrue(isBound);
    }

    @Test
    public void testFindByStudent() {
        var student = new Aluno(1); // ID do registo de Bartolomeu Hangalo
        student.fetchSubscriptions();
        var inscricoes = student.getInscricoes();
        var match = true;
        for (Inscricao inscricao : inscricoes) {
            if (!inscricao.getAluno().getCodigo().equals(student.getCodigo())) {
                match = false;
                break;
            }
        }
        assertTrue(match);
    }
}

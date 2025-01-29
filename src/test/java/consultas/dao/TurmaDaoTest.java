package consultas.dao;

import consultas.modelo.Turma;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TurmaDaoTest {

    static TurmaDao turmaDao;

    @BeforeAll
    static void setUp() {
        turmaDao = new TurmaDao();
    }

    @Test
    void searchTurma() {
        var query = "10";
        var result = turmaDao.search(query);
        assertNotNull(result);
    }

    @Test
    void findAll() {
        assertNotNull(turmaDao.findAll());
    }

    @Test
    void findById() {
        assertInstanceOf(Optional.class, turmaDao.findById(""), "Devia retorna uma instância de 'java.util.Optional'");
    }

    @Test
    void findByName() {
        var name = "infor".toLowerCase();
        var result = turmaDao.findByName(name);
        boolean match = true;
        for (var turma : result) {
            if (!turma.getNome().toLowerCase().contains(name)) {
                match = false;
                break;
            }
        }
        assertTrue(match, "Algumas turma não satisfazem o critério");
    }

    @Test
    void findByStudent() {
    }

    /**
     * @implNote Este teste deve ser reajustado posteriormente.
     * O teste está fortemente dependente dos dados na base de dados
     * e pode falhar se os dados na base de dados forem alterados.
     */
    @Test
    void setAlunos() {
        var turma = new Turma("INFOR");
        turmaDao.setAlunos(turma);
        int[] expected = {1, 2, 3};
        int[] actual = new int[3];
        for (int i = 0; i < turma.getAlunos().size(); i++) {
            actual[i] = turma.getAluno(i).getCodigo();
        }
        assertArrayEquals(expected, actual, """
                Segundo os dados na base de dados, o código dos alunos desta turma deviam ser apenas 1, 2 e 3
                Se os dados na base de dados foram alterados, actualize o teste ou modifique-o para que não fique demasiado dependente da BD.
                """);
    }

    @Test
    void setTeacherTest() {
        var code = "INFOR";
        var turma = new Turma(code);
        turma.fetchTeacher();
        assertNotNull(turma.getFormador());
        assertEquals(6, turma.getFormador().getCodigo());
    }
}

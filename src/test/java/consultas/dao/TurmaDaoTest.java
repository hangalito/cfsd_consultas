package consultas.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}

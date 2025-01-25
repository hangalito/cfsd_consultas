package consultas.dao;

import junit.framework.TestCase;

import java.time.LocalDate;

public class InscricaoDaoTest extends TestCase {
    public void testFindBetweenDates() {
        var start = LocalDate.of(2020, 1, 1);
        var end = LocalDate.of(2020, 12, 31);
        var dao = new InscricaoDao();
        var subscriptions = dao.findBetweenDates(start, end);
        boolean isBound = true;

	if (!subscriptions.isEmpty()) {
            for (consultas.modelo.Inscricao subscription : subscriptions) {
                if (subscription.getData().isBefore(start) || subscription.getData().isAfter(end)) {
                    isBound = false;
                    break;
                }
            }
            assertTrue(isBound);
	} else {
	    assertFalse(true);
	}
    }
}

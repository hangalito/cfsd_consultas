package consultas.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {
    public String getAge(LocalDate start) {
        var now = LocalDate.now();
        var period = Period.between(start, now);
        return "" + period.getYears() + " anos";
    }
}

package consultas.util;


import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Método utilitário para logging
 *
 * @author <a href="mailto:bartolomeujose.manilson@gmail.com">Bartolomeu
 * Hangalo</a>
 */
public class LoggingUtil {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static void severe(String msg) {
        LOG.severe(msg);
    }

    public static void severe(Throwable thrown, String msg) {
        LOG.log(Level.SEVERE, thrown, () -> msg);
    }

    public static void warning(String msg) {
        LOG.warning(msg);
    }

    public static void debug(String msg, Object... params) {
        LOG.log(Level.INFO, msg, params);
    }
}

package consultas.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ApplicationScoped
public class FacesMessageUtil {

    private static final Severity INFO = FacesMessage.SEVERITY_INFO;
    private static final Severity WARNING = FacesMessage.SEVERITY_WARN;
    private static final Severity ERROR = FacesMessage.SEVERITY_ERROR;

    private void display() {
        PrimeFaces.current().ajax().update("messages:growl");
    }

    public void info(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(INFO, summary, detail));
        display();
    }

    public void info(String summary) {
        info(summary, summary);
    }

    public void warning(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(WARNING, summary, detail));
        display();
    }

    public void warning(String summary) {
        warning(summary, summary);
    }

    public void error(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(ERROR, summary, detail));
        display();
    }

    public void error(String summary) {
        error(summary, summary);
    }

}

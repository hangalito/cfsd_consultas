package consultas.exceptions;

public class NoResultException extends Exception {
    public NoResultException(String message) {
        super(message);
    }

    public NoResultException() {
        this("Nenhum resultado encontrado");
    }
}

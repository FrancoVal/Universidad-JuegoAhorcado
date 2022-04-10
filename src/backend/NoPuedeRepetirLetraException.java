package backend;

public class NoPuedeRepetirLetraException extends Exception {
    public NoPuedeRepetirLetraException(String mensaje) {
        super(mensaje);
    }
}
package backend;

public class NoHayMasIntentosException extends Exception {
    public NoHayMasIntentosException(String mensaje) {
        super(mensaje);
    }
}
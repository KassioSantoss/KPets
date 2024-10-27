package brcomkassin.pets.exceptions;

public class PetSpawnException extends RuntimeException {
    public PetSpawnException(String message) {
        super(message);
    }

    public PetSpawnException(String message, Throwable cause) {
        super(message, cause);
    }

}

package brcomkassin.pets.exceptions;

public class PetSpawningException extends RuntimeException {

    public PetSpawningException() {
        super("Pet não foi spawnado");
    }

    public PetSpawningException(String message) {
        super(message);
    }

    public PetSpawningException(String message, Throwable cause) {
        super(message, cause);
    }

}

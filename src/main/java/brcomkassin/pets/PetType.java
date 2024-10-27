package brcomkassin.pets;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PetType {

    EVIL_PET("Evil Pet", "cubee-evil"),
    NONE("none", "none");

    private final String name;
    private final String modelId;

    public static PetType getByName(String name) {
        final PetType[] values = values();
        return Arrays
                .stream(values)
                .filter(v -> v.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(NONE);
    }
}

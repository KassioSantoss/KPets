package brcomkassin.pets;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PetType {

    EVIL_PET("&4Evil Pet", "cube-evil"),
    NONE(null, null);

    private final String name;
    private final String modelId;

    public static PetType getByName(String name) {
        final PetType[] values = values();
        return Arrays
                .stream(values)
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElse(NONE);
    }
}

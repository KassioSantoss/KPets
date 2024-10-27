package brcomkassin.pets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetType {

    EVIL_PET(new EvilPet(), "&4 Evil Pet", "cubee-evil"),
    NONE(null, null, null);

    private final Pet pet;
    private final String name;
    private final String id;

    public static PetType getByName(String name) {
        try {
            return PetType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }

}

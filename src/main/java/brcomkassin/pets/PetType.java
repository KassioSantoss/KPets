package brcomkassin.pets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetType {

    EVIL_PET(new EvilPet(),"&4 Evil Pet", "cubee-evil");

    private final Pet pet;
    private final String name;
    private final String id;

}

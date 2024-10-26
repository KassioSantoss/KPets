package brcomkassin.pets;

import lombok.Getter;
import java.util.*;

public class PetRenderedCache {
    @Getter
    private final static Map<UUID, Pet> PET_MAP = new HashMap<>();
    @Getter
    private final static List<PetRendered> PET_RENDEREDS = new ArrayList<>();

    public static void addOwnerAndPet(UUID uuid, Pet pet) {
        PetRenderedCache.getPET_MAP().put(uuid, pet);
        PetRenderedCache.getPET_RENDEREDS().add(new PetRendered(uuid, pet.getId()));
    }

}

package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import brcomkassin.utils.Message;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

    public static void removePet(UUID ownerUuid){
        Player player = Bukkit.getPlayer(ownerUuid);

        if (player == null) return;

        if (!PetRenderedCache.getPET_MAP().containsKey(ownerUuid)) {
            Message.Chat.send(player, "&4Você não possui Pet no momento!");
            return;
        }
        PetRenderedCache.getPET_MAP().get(ownerUuid).getEntity().remove();
        PetRenderedCache.getPET_MAP().remove(ownerUuid);
    }

}

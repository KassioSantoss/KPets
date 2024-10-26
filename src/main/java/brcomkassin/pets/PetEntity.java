package brcomkassin.pets;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PetEntity {

    public static final Map<UUID, Pet> PET_MAP = new HashMap<>();

    public static Pet spawnPet(Player player, Pet pet) {
        if (PET_MAP.containsKey(player.getUniqueId())) {
            PET_MAP.get(player.getUniqueId()).remove();
        }
        pet.spawn(player.getLocation());
        PET_MAP.put(player.getUniqueId(), pet);
        player.sendMessage("Pet: " + pet.getName() + " foi spawnado!");
        return pet;
    }

    public static void removePet(Player player) {
        Pet pet = PET_MAP.remove(player.getUniqueId());
        if (pet != null) pet.remove();
    }

    public static Pet getPet(UUID playerUuid) {
        return PET_MAP.get(playerUuid);
    }

}

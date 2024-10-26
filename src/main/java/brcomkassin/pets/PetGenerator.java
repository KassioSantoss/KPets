package brcomkassin.pets;

import brcomkassin.pets.utils.PetRenderedCache;
import brcomkassin.utils.Message;
import org.bukkit.entity.Player;

public final class PetGenerator {

    public static void spawnPet(Player player, Pet pet) {
        if (PetRenderedCache.getPET_MAP().get(player.getUniqueId()) != null) {
            Message.Chat.send(player, "&4Você já possui um pet!");
            Message.Chat.send(player, "&4Use /pet remove para remover seu pet!");
            return;
        }

        pet.spawn(player);
        Message.Chat.send(player, "&6&lPet: " + pet.getName().toUpperCase() + " &6foi spawnado!");
    }

}

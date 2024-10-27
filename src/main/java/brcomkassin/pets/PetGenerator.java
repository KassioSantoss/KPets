package brcomkassin.pets;

import brcomkassin.pets.utils.PetRenderedCache;
import brcomkassin.pets.utils.PetSummonConfigurer;
import brcomkassin.utils.Message;
import org.bukkit.entity.Player;

public final class PetGenerator {

    public static void spawnPet(Player player, PetType type) {
        final String playerName = player.getName();
        final boolean hasPet = PetRenderedCache.getPets().containsKey(player.getName());

        if (hasPet) {

            final String name = type.getName();

            Pet pet = PetSummonConfigurer.of()
                    .forPlayer(player)
                    .withCustomName(name)
                    .withType(type)
                    .setVisible(false)
                    .setCanMove(false)
                    .setCustomNameVisible(true)
                    .build();

            PetRenderedCache.addOwnerAndPet(player, pet);

            Message.Chat.send(player, "&6&lPet: " + pet.getName().toUpperCase() + " &6foi spawnado!");
            return;
        }

        Message.Chat.send(player, "&4Você já possui um pet!");
        Message.Chat.send(player, "&4Use /pet remove para remover seu pet!");
    }
}

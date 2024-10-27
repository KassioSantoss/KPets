package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import brcomkassin.utils.Message;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class PetRenderedCache {

    @Getter private final static Map<String, Pet> pets;
    @Getter private final static Set<PetRendered> renders;

    static {
        pets = new HashMap<>();
        renders = new HashSet<>();
    }

    public static void addOwnerAndPet(Player player, Pet pet) {
        final String playerName = player.getName();

        pets.put(playerName, pet);

        final PetRendered rendered = new PetRendered(player, pet);
        renders.add(rendered);
    }

    public static boolean hasPet(Player player) {
        final String playerName = player.getName();
        return pets.containsKey(playerName);
    }

    public static void removePet(Player player){
        final String playerName = player.getName();

        boolean hasPet = pets.containsKey(playerName);
        if (hasPet) {
            pets.get(playerName).getEntity().remove();
            pets.remove(playerName);
        }

        Message.Chat.send(player, "&4Você não possui Pet no momento!");
    }
}

package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import org.bukkit.entity.Player;

public record PetRendered(Player owner, Pet pet) {

    @Override
    public Player owner() {
        return owner;
    }

    @Override
    public Pet pet() {
        return pet;
    }
}

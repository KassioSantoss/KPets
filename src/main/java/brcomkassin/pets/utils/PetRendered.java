package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter public record PetRendered(Player owner, Pet pet) { }

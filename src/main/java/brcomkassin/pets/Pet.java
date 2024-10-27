package brcomkassin.pets;

import brcomkassin.pets.utils.PetRenderedCache;
import brcomkassin.utils.Message;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public abstract class Pet {

    private String name;
    private String id;
    private UUID owner;
    private ArmorStand entity;

    public abstract void spawn(Player player);

    public void removePet(UUID ownerUuid) {
        PetRenderedCache.removePet(ownerUuid);
    }

}

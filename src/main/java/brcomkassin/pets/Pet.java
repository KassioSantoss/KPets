package brcomkassin.pets;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import java.util.UUID;

@Setter
@Getter
public abstract class Pet {
    private UUID owner;
    protected ArmorStand entity;

    public Pet(UUID owner) {
        this.owner = owner;
    }

    public abstract void spawn(Location location);

    void tick() {
    }

    public void remove() {
        if (entity != null && !entity.isDead()){
            entity.remove();
        }
    }

}

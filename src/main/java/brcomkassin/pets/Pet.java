package brcomkassin.pets;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;


@Setter
@Getter
public abstract class Pet {
    private ArmorStand entity;
    private String name;
    private String id;

    public Pet(String id) {
        this.id = id;
    }

    public abstract void spawn(Location location);

    void tick() {
    }

    public void remove() {
        if (entity != null && !entity.isDead()) {
            entity.remove();
        }
    }

    public void setName(String name) {
        this.name = ChatColor.translateAlternateColorCodes('&', name);
    }
}

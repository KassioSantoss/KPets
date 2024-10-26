package brcomkassin.pets;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class WaterPet extends Pet {

    public WaterPet(UUID owner) {
        super(owner);
    }

    @Override
    public void spawn(Location location) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setCanMove(false);
        armorStand.setVisible(false);
        armorStand.setItem(EquipmentSlot.HEAD, new ItemStack(Material.PLAYER_HEAD));
        this.entity = armorStand;
    }
}

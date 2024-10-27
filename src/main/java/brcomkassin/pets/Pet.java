package brcomkassin.pets;

import brcomkassin.utils.Message;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
        Player player = Bukkit.getPlayer(ownerUuid);

        if (player == null) return;

        if (!PetRenderedCache.getPET_MAP().containsKey(ownerUuid)) {
            Message.Chat.send(player, "&4Você não possui Pet no momento!");
            return;
        }
        PetRenderedCache.getPET_MAP().get(ownerUuid).getEntity().remove();
        PetRenderedCache.getPET_MAP().remove(ownerUuid);
    }

}

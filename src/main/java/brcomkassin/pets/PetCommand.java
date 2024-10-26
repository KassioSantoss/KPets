package brcomkassin.pets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) return true;

        UUID uuid = player.getUniqueId();

        if (PetEntity.getPet(uuid) != null) {
            player.sendMessage("Voce já possui um pet ativo!");
            return true;
        }
        Pet waterPet = PetEntity.spawnPet(player, new WaterPet(uuid));

        return false;
    }
}

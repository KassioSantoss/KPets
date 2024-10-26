package brcomkassin.pets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;

        if (args.length < 1) {
            player.sendMessage("Uso correto: /pet <tipo>");
            return true;
        }

        PetType petType;

        try {
            petType = PetType.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            player.sendMessage("Não existe nenhum pet com esse nome!");
            return true;
        }

        PetGenerator.spawnPet(player, petType.getPet());

        return false;
    }
}

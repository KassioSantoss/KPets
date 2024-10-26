package brcomkassin.pets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.UUID;

public class PetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(commandSender instanceof Player player)) return true;

        UUID uuid = player.getUniqueId();

        if (PetEntity.getPet(uuid) != null) {
            player.sendMessage("Voce já possui um pet ativo!");
            return true;
        }
        if (args.length < 1) {
            player.sendMessage("Uso: /pet <tipo>");
            return true;
        }

        PetType petType;
        try {
            petType = PetType.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            player.sendMessage("Não existe nenhum pet com esse nome!");
            return true;
        }

        switch (petType) {
            case EVIL_PET -> PetEntity.spawnPet(player, petType.getPet());
            default -> player.sendMessage("Este tipo de pet ainda não está disponível.");
        }
        return true;
    }
}

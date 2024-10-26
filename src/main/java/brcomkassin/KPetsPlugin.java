package brcomkassin;

import brcomkassin.pets.PetCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class KPetsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("pet").setExecutor(new PetCommand());
    }

    @Override
    public void onDisable() {

    }

}

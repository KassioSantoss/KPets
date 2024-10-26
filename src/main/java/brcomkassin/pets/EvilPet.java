package brcomkassin.pets;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public final class EvilPet extends Pet {

    @Override
    public void spawn(Player player) {
        ArmorStand baseEntity = player.getLocation().getWorld().spawn(player.getLocation(), ArmorStand.class);
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(baseEntity);
        ActiveModel activeModel = ModelEngineAPI.createActiveModel(PetType.EVIL_PET.getId());
        baseEntity.setVisible(false);
        baseEntity.setCanMove(false);
        baseEntity.setCustomNameVisible(true);
        baseEntity.setCustomName(PetType.EVIL_PET.getName());
        modeledEntity.addModel(activeModel, true);
        setName(PetType.EVIL_PET.getName());
        setId(PetType.EVIL_PET.getId());
        setEntity(baseEntity);
    }
}

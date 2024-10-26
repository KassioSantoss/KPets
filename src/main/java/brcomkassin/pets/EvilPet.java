package brcomkassin.pets;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class EvilPet extends Pet {

    public EvilPet(String id) {
        super(id);
    }

    @Override
    public void spawn(Location location) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setCanMove(false);
        armorStand.setVisible(false);
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(armorStand);
        ActiveModel activeModel = ModelEngineAPI.createActiveModel(PetType.EVIL_PET.getPet().getId());
        modeledEntity.addModel(activeModel, true);
        setEntity(armorStand);
        setName(PetType.EVIL_PET.getName());
    }
}

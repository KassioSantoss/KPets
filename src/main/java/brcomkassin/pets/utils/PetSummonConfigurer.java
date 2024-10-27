package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import brcomkassin.pets.PetType;
import brcomkassin.pets.exceptions.PetSpawningException;
import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import lombok.Data;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.UUID;

@SuppressWarnings("deprecation")
@Data(staticConstructor = "of") public final class PetSummonConfigurer {

    private Player player;
    private String customName;
    private String modelId;
    private boolean isVisible = false;
    private boolean canMove = false;
    private boolean customNameVisible = true;

    public PetSummonConfigurer forPlayer(Player player) {
        this.player = player;
        return this;
    }

    public PetSummonConfigurer withCustomName(String customName) {
        this.customName = customName;
        return this;
    }

    public PetSummonConfigurer withType(PetType type) {
        this.modelId = type.getModelId();
        return this;
    }

    public PetSummonConfigurer setVisible(boolean visible) {
        this.isVisible = visible;
        return this;
    }

    public PetSummonConfigurer setCanMove(boolean canMove) {
        this.canMove = canMove;
        return this;
    }

    public PetSummonConfigurer setCustomNameVisible(boolean customNameVisible) {
        this.customNameVisible = customNameVisible;
        return this;
    }

    public Pet build() {
        if (player == null) {
            throw new PetSpawningException("O jogador deve existir para gerar um Pet.");
        }
        if (customName == null) {
            throw new PetSpawningException("O nome personalizado do Pet não pode ser nulo.");
        }
        if (modelId == null) {
            throw new PetSpawningException("O ID do modelo do Pet não pode ser nulo.");
        }

        try {
            ArmorStand baseEntity = player.getLocation().getWorld().spawn(player.getLocation(), ArmorStand.class);
            baseEntity.setVisible(isVisible);
            baseEntity.setCanMove(canMove);
            baseEntity.setCustomNameVisible(customNameVisible);
            baseEntity.setCustomName(customName);

            ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(baseEntity);
            ActiveModel activeModel = ModelEngineAPI.createActiveModel(modelId);
            modeledEntity.addModel(activeModel, true);

            final UUID owner = player.getUniqueId();

            final Pet pet = new Pet();
            pet.setName(customName);
            pet.setEntity(baseEntity);
            pet.setOwner(owner);

            PetRenderedCache.addOwnerAndPet(player, pet);

            return pet;
        } catch (Exception e) {
            throw new PetSpawningException("Falha ao gerar o pet devido a um erro inesperado.", e);
        }
    }
}
package brcomkassin.pets.utils;

import brcomkassin.pets.Pet;
import brcomkassin.pets.exceptions.PetSpawnException;
import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class PetBuilder<T extends Pet> {
    private final Supplier<T> petSupplier;
    private Player player;
    private String customName;
    private String modelId;
    private boolean isVisible = false;
    private boolean canMove = false;
    private boolean customNameVisible = true;

    public static <T extends Pet> PetBuilder<? extends T> getInstance(Supplier<T> supplier) {
        return new PetBuilder<>(supplier);
    }

    public PetBuilder(Supplier<T> petSupplier) {
        this.petSupplier = petSupplier;
    }

    public PetBuilder<T> forPlayer(Player player) {
        this.player = player;
        return this;
    }

    public PetBuilder<T> withCustomName(String customName) {
        this.customName = customName;
        return this;
    }

    public PetBuilder<T> withModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public PetBuilder<T> setVisible(boolean visible) {
        this.isVisible = visible;
        return this;
    }

    public PetBuilder<T> setCanMove(boolean canMove) {
        this.canMove = canMove;
        return this;
    }

    public PetBuilder<T> setCustomNameVisible(boolean customNameVisible) {
        this.customNameVisible = customNameVisible;
        return this;
    }

    public T build() {
        if (player == null) {
            throw new PetSpawnException("O jogador deve existir para gerar um Pet.");
        }
        if (customName == null) {
            throw new PetSpawnException("O nome personalizado do Pet não pode ser nulo.");
        }
        if (modelId == null) {
            throw new PetSpawnException("O ID do modelo do Pet não pode ser nulo.");
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

            T pet = petSupplier.get();
            pet.setName(customName);
            pet.setEntity(baseEntity);
            pet.setOwner(player.getUniqueId());

            PetRenderedCache.addOwnerAndPet(player.getUniqueId(), pet);
            return pet;

        } catch (Exception e) {
            throw new PetSpawnException("Falha ao gerar o pet devido a um erro inesperado.", e);
        }
    }
}
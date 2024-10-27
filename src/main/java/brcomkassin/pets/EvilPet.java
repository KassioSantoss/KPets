package brcomkassin.pets;

import brcomkassin.pets.utils.PetBuilder;
import org.bukkit.entity.Player;

public final class EvilPet extends Pet {

    @Override
    public void spawn(Player player) {
        String customName = PetType.EVIL_PET.getName();
        String modeledId = PetType.EVIL_PET.getId();
        System.out.println("Custom Name: " + customName);
        System.out.println("ModeledId: " + modeledId);

       EvilPet pet = PetBuilder.getInstance(EvilPet::new)
                .forPlayer(player)
                .withCustomName(customName)
                .withModelId(modeledId)
                .setVisible(false)
                .setCanMove(false)
                .setCustomNameVisible(true)
                .build();

       pet.setName(customName);
       pet.setId(modeledId);
    }

}

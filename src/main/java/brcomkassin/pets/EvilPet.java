package brcomkassin.pets;

import brcomkassin.pets.utils.PetBuilder;
import org.bukkit.entity.Player;

public final class EvilPet extends Pet {

    @Override
    public void spawn(Player player) {
        EvilPet pet = new PetBuilder<>(EvilPet::new)
                .forPlayer(player)
                .withCustomName(PetType.EVIL_PET.getName())
                .withModelId(PetType.EVIL_PET.getId())
                .setVisible(false)
                .setCanMove(false)
                .setCustomNameVisible(true)
                .build();

        pet.setName(PetType.EVIL_PET.getName());
        pet.setId(PetType.EVIL_PET.getId());
        pet.setOwner(player.getUniqueId());
    }

}

package brcomkassin.pets;

import lombok.Data;
import org.bukkit.entity.ArmorStand;

import java.util.UUID;

@Data public class Pet {

    private String name;
    private String id;
    private UUID owner;
    private PetType type;
    private ArmorStand entity;

}

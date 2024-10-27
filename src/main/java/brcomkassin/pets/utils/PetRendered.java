package brcomkassin.pets.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public final class PetRendered {

    private UUID owner;
    private String idPet;

}

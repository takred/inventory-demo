package takred.inventorydemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ItemInInventory {
    @Id
    private UUID id = UUID.randomUUID();
    private UUID idItem;
    private UUID idPerson;
    private boolean itemOn = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdItem() {
        return idItem;
    }

    public void setIdItem(UUID idItem) {
        this.idItem = idItem;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public boolean getItemOn() {
        return itemOn;
    }

    public void setItemOn(boolean itemOn) {
        this.itemOn = itemOn;
    }
}

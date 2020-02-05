package takred.inventorydemo;

import lombok.Data;

import java.util.UUID;

@Data
public class AddInInventoryItemParameters {
    private UUID personId;
    private String nameItem;

    public AddInInventoryItemParameters(UUID personId, String nameItem) {
        this.personId = personId;
        this.nameItem = nameItem;
    }

    public AddInInventoryItemParameters() {}
}

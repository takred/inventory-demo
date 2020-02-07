package takred.inventorydemo;

import lombok.Data;

import java.util.UUID;

@Data
public class AddInInventoryItemParameters {
    private UUID personId;
    private String itemName;

    public AddInInventoryItemParameters(UUID personId, String itemName) {
        this.personId = personId;
        this.itemName = itemName;
    }

    public AddInInventoryItemParameters() {}
}

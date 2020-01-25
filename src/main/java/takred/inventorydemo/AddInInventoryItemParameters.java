package takred.inventorydemo;

import lombok.Data;

@Data
public class AddInInventoryItemParameters {
    private String namePerson;
    private String nameItem;

    public AddInInventoryItemParameters(String namePerson, String nameItem) {
        this.namePerson = namePerson;
        this.nameItem = nameItem;
    }

    public AddInInventoryItemParameters() {}
}

package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemListDto {
    private List<Item> parameters;

    public ItemListDto(List<Item> parameters) {
        this.parameters = new ArrayList<>(parameters);
    }

    public ItemListDto() {}
}

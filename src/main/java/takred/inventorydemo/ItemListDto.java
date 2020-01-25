package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemListDto {
    private List<ItemDto> parameters;

    public ItemListDto(List<ItemDto> parameters) {
        this.parameters = new ArrayList<>(parameters);
    }

    public ItemListDto() {}
}

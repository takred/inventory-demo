package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.entity.Item;

import java.util.List;

@Data
public class ItemListDto {
    private List<Item> parameters;

//    public List<Item> getParameters() {
//        return parameters;
//    }
}

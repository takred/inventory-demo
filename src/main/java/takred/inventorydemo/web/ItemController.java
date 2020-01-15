package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.ItemListDto;
import takred.inventorydemo.entity.Item;
import takred.inventorydemo.service.ItemService;

@RestController
@RequestMapping(value = "/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "add_item")
    public String addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PostMapping(value = "add_items")
    public void addItems(@RequestBody ItemListDto itemListDto) {
        itemService.addItems(itemListDto);
    }
}

package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.ItemListDto;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;
import takred.inventorydemo.service.ItemService;

import java.util.List;

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

    @GetMapping(value = "get_all_items")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }
}

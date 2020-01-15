package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.AddInInventoryItemParameters;
import takred.inventorydemo.ItemCombination;
import takred.inventorydemo.ItemOnParameters;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;
import takred.inventorydemo.service.ItemInInventoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ItemInInventoryController {
    private final ItemInInventoryService itemInInventoryService;

    public ItemInInventoryController(ItemInInventoryService itemInInventoryService) {
        this.itemInInventoryService = itemInInventoryService;
    }

    @RequestMapping(value = "get_person_items/{namePerson}")
    public List<ItemCombination> getPersonItems(@PathVariable("namePerson") String namePerson) {
        return itemInInventoryService.getPersonItems(namePerson);
    }

    @PostMapping(value = "add_item_in_inventory")
    public String addItemInInventory(@RequestBody AddInInventoryItemParameters parameters) {
        return itemInInventoryService.addItemInInventory(parameters);
    }

    @PostMapping(value = "on_item")
    public String itemOn(@RequestBody ItemOnParameters parameters) {
        return itemInInventoryService.onItem(parameters);
    }

    @RequestMapping(value = "get_only_on_item/{namePerson}")
    public List<ItemDto> getOnlyOnItem(@PathVariable("namePerson") String namePerson) {
        return itemInInventoryService.getOnlyOnItem(namePerson);
    }
}

package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.mapper.ItemMapperMapstruct;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.ItemListDto;
import takred.inventorydemo.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final AllItemRepository allItemRepository;
    private final ItemMapperMapstruct itemMapperMapstruct;

    public ItemService(AllItemRepository allItemRepository, ItemMapperMapstruct itemMapperMapstruct) {
        this.allItemRepository = allItemRepository;
        this.itemMapperMapstruct = itemMapperMapstruct;
    }

    public String addItem(Item item) {
        Item item1 = allItemRepository.findByName(item.getName());
        if (item1 == null) {
            allItemRepository.save(item);
            return "Предмет успешно добавлен.";
        }
        return "Такое название предмета уже есть!";
    }

    public void addItems(ItemListDto itemListDto) {
        for (int i = 0; i < itemListDto.getParameters().size(); i++) {
            addItem(itemMapperMapstruct.map(itemListDto.getParameters().get(i)));
        }
    }

    public List<ItemDto> getAllItems() {
        return new ArrayList<>(itemMapperMapstruct.map(allItemRepository.findAll()));
    }
}

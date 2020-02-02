package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.mapper.ItemMapper;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.ItemListDto;
import takred.inventorydemo.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final AllItemRepository allItemRepository;
    private final ItemMapper itemMapper;

    public ItemService(AllItemRepository allItemRepository, ItemMapper itemMapper) {
        this.allItemRepository = allItemRepository;
        this.itemMapper = itemMapper;
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
            addItem(itemMapper.map(itemListDto.getParameters().get(i)));
        }
    }

    public List<ItemDto> getAllItems() {
        return new ArrayList<>(itemMapper.map(allItemRepository.findAll()));
    }
}

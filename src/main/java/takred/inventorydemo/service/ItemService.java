package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.ItemDto;
import takred.inventorydemo.entity.Item;

@Service
public class ItemService {
    private final AllItemRepository allItemRepository;

    public ItemService(AllItemRepository allItemRepository) {
        this.allItemRepository = allItemRepository;
    }

    public String addItem(Item item) {
        Item item1 = allItemRepository.findByName(item.getName());
        if (item1 == null) {
            allItemRepository.save(item);
            return "Предмет успешно добавлен.";
        }
        return "Такое название предмета уже есть!";
    }

    public void addItems(ItemDto itemDto) {
        for (int i = 0; i < itemDto.getParameters().size(); i++) {
            addItem(itemDto.getParameters().get(i));
        }
    }
}

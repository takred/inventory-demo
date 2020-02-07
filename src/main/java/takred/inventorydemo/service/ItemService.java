package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.mapper.ItemMapper;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.ItemListDto;
import takred.inventorydemo.entity.Item;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void createItemsIfNotExists() {
        Item jacket = new Item();
        jacket.setName("Куртка");
        jacket.setDamage(1);
        jacket.setArmor(10);
        jacket.setItemCode("JACKET");
        Item boots = new Item();
        boots.setName("Сапоги");
        boots.setDamage(1);
        boots.setArmor(5);
        boots.setItemCode("BOOTS");
        saveIfNotExists(jacket);
        saveIfNotExists(boots);
    }

    public String addItem(Item item) {
        if (!allItemRepository.existsByItemCode(item.getItemCode())) {
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

    public void saveIfNotExists(Item item) {
        if (!allItemRepository.existsByItemCode(item.getItemCode())) {
            allItemRepository.save(item);
        }
    }
}

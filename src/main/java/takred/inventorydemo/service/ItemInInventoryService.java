package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.AddInInventoryItemParameters;
import takred.inventorydemo.ItemCombination;
import takred.inventorydemo.ItemOnParameters;
import takred.inventorydemo.entity.Item;
import takred.inventorydemo.entity.ItemInInventory;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.repository.ItemInInventoryRepository;
import takred.inventorydemo.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemInInventoryService {
    private final ItemInInventoryRepository itemInInventoryRepository;
    private final AllItemRepository allItemRepository;
    private final PersonRepository personRepository;

    public ItemInInventoryService(ItemInInventoryRepository itemInInventoryRepository, AllItemRepository allItemRepository, PersonRepository personRepository) {
        this.itemInInventoryRepository = itemInInventoryRepository;
        this.allItemRepository = allItemRepository;
        this.personRepository = personRepository;
    }

    public List<ItemCombination> getPersonItems(String namePerson) {
        Person person = personRepository.findByName(namePerson);
        if (person == null) {
            return new ArrayList<>();
        }
        List<ItemInInventory> allIdItemInPersonInventory = itemInInventoryRepository.findByIdPerson(person.getId());
        if (allIdItemInPersonInventory == null) {
            return new ArrayList<>();
        }
        List<ItemCombination> allItemInPersonInventory = new ArrayList<>();
        for (int i = 0; i < allIdItemInPersonInventory.size(); i++) {
            UUID idItemInCurrentElement = allIdItemInPersonInventory.get(i).getIdItem();
            UUID idObject = allIdItemInPersonInventory.get(i).getId();
            ItemCombination itemCombination = new ItemCombination(allItemRepository.findById(idItemInCurrentElement).get(), idObject);
//            allItemInPersonInventory.add(allItemRepository.findById(idItemInCurrentElement).get());
            allItemInPersonInventory.add(itemCombination);
        }
        return allItemInPersonInventory;
    }

    public String addItemInInventory(AddInInventoryItemParameters parameters) {
        Person person = personRepository.findByName(parameters.getNamePerson());

        if (person == null) {
            return "Такого персонажа нет!";
        }
        Item item = allItemRepository.findByName(parameters.getNameItem());

        if (item == null) {
            return "Такого предмета нет!";
        }
        ItemInInventory itemInInventory = new ItemInInventory();
        itemInInventory.setIdPerson(person.getId());
        itemInInventory.setIdItem(item.getId());
        itemInInventoryRepository.save(itemInInventory);
        return "Мы положили предмет к вам в инвентарь.";
    }

    public String onItem(ItemOnParameters parameters) {
        Person person = personRepository.findByName(parameters.getNamePerson());
        if (person == null) {
            return "Такого персонажа нет!";
        }
        List<ItemInInventory> allIdItemInPersonInventory = itemInInventoryRepository.findByIdPerson(person.getId());
        if (allIdItemInPersonInventory == null) {
            return "Ваш инвентарь пуст.";
        }
        ItemInInventory itemInInventory = new ItemInInventory();
        for (int i = 0; i < allIdItemInPersonInventory.size(); i++) {
            if (allIdItemInPersonInventory.get(i).getId().equals(parameters.getIdObject())) {
                itemInInventory = allIdItemInPersonInventory.get(i);
                break;
            }
            if (i + 1 == allIdItemInPersonInventory.size()) {
                return "Такого предмета у вас нет!";
            }
        }
        if (itemInInventory.getItemOn()) {
            return "Этот предмет и так надет!";
        }
        Integer sumOn = 0;
        for (int i = 0; i < allIdItemInPersonInventory.size(); i++) {
            if (allIdItemInPersonInventory.get(i).getItemOn()) {
                sumOn++;
            }
        }
        if (sumOn > 4) {
            return "Вы и так надели максимальное кол-во предметов(5)!";
        }
        itemInInventory.setItemOn(true);
        itemInInventoryRepository.save(itemInInventory);
        return "Успешно надето.";
    }

    public List<Item> getOnlyOnItem(String namePerson) {
        Person person = personRepository.findByName(namePerson);
        if (person == null) {
            return new ArrayList<>();
        }
        List<ItemInInventory> allIdItemInPersonInventory = itemInInventoryRepository.findByIdPerson(person.getId());
        if (allIdItemInPersonInventory == null) {
            return new ArrayList<>();
        }
        List<Item> allOnItem = new ArrayList<>();
        for (int i = 0; i < allIdItemInPersonInventory.size(); i++) {
            if (allIdItemInPersonInventory.get(i).getItemOn()) {
                UUID idItemInCurrentElement = allIdItemInPersonInventory.get(i).getIdItem();
                allOnItem.add(allItemRepository.findById(idItemInCurrentElement).get());
            }
        }
        return allOnItem;
    }

}

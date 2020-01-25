package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.DropMonsterListDto;
import takred.inventorydemo.dto.DropMonsterDto;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.DropMonster;
import takred.inventorydemo.entity.Item;
import takred.inventorydemo.mapper.DropMonsterMapperMapstruct;
import takred.inventorydemo.mapper.ItemMapperMapstruct;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.repository.DropMonsterRepository;
import takred.inventorydemo.repository.MonsterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DropMonsterService {
    private final DropMonsterRepository dropMonsterRepository;
    private final DropMonsterMapperMapstruct dropMonsterMapperMapstruct;
    private final ItemMapperMapstruct itemMapperMapstruct;
    private final MonsterRepository monsterRepository;
    private final AllItemRepository allItemRepository;

    public DropMonsterService(DropMonsterRepository dropMonsterRepository, DropMonsterMapperMapstruct dropMonsterMapperMapstruct, ItemMapperMapstruct itemMapperMapstruct, MonsterRepository monsterRepository, AllItemRepository allItemRepository) {
        this.dropMonsterRepository = dropMonsterRepository;
        this.dropMonsterMapperMapstruct = dropMonsterMapperMapstruct;
        this.itemMapperMapstruct = itemMapperMapstruct;
        this.monsterRepository = monsterRepository;
        this.allItemRepository = allItemRepository;
    }

    public void addDropMonster(DropMonsterDto dto) {
        DropMonster dropMonster = new DropMonster();
        dropMonster.setMonsterId(dto.getMonsterId());
        dropMonster.setItemId(dto.getItemId());
        dropMonster.setWeight(dto.getWeight());
        dropMonsterRepository.save(dropMonster);
    }

    public void addDropsMonsters(DropMonsterListDto dropMonsterListDto) {
        for (int i = 0; i < dropMonsterListDto.getParameters().size(); i++) {
            addDropMonster(dropMonsterListDto.getParameters().get(i));
        }
    }

    public boolean dropCheck() {
        Integer number = ThreadLocalRandom.current().nextInt(1, 100);
        if (number <= 10) {
            return true;
        }
        return false;
    }

    public boolean tableNotEmpty(UUID monsterId) {
        List<DropMonster> items = new ArrayList<>(dropMonsterRepository.findByMonsterId(monsterId));
        if (items.size() > 0) {
            return true;
        }
        return false;
    }

    public ItemDto dropItem(UUID monsterId) {
        List<DropMonster> dropMonsters = new ArrayList<>(dropMonsterRepository.findByMonsterId(monsterId));
        Integer weightSum = 0;
        for (int i = 0; i < dropMonsters.size(); i++) {
            weightSum = weightSum + dropMonsters.get(i).getWeight();
        }
        Integer weightDrop = ThreadLocalRandom.current().nextInt(1, weightSum);
        ItemDto itemDto = new ItemDto();
        for (int i = 0; i < dropMonsters.size(); i++) {
            if (weightDrop <= dropMonsters.get(i).getWeight()) {
                itemDto = itemMapperMapstruct.map(allItemRepository.findById(dropMonsters.get(i).getItemId()).get());
            }
        }
        return itemDto;
    }
}

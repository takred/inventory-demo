package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.DropMonsterListDto;
import takred.inventorydemo.builder.DropMonsterBuilder;
import takred.inventorydemo.dto.DropMonsterDto;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.DropMonster;
import takred.inventorydemo.entity.Monster;
import takred.inventorydemo.mapper.DropMonsterMapper;
import takred.inventorydemo.mapper.ItemMapper;
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
    private final DropMonsterMapper dropMonsterMapper;
    private final ItemMapper itemMapper;
    private final MonsterRepository monsterRepository;
    private final AllItemRepository allItemRepository;

    public DropMonsterService(DropMonsterRepository dropMonsterRepository, DropMonsterMapper dropMonsterMapper, ItemMapper itemMapper, MonsterRepository monsterRepository, AllItemRepository allItemRepository) {
        this.dropMonsterRepository = dropMonsterRepository;
        this.dropMonsterMapper = dropMonsterMapper;
        this.itemMapper = itemMapper;
        this.monsterRepository = monsterRepository;
        this.allItemRepository = allItemRepository;
    }

    public void addDropMonster(DropMonsterDto dto) {
        DropMonster dropMonster = new DropMonsterBuilder()
                .withMonsterId(monsterRepository.findByMonsterCode(dto.getMonsterCode()).getId())
                .withItemId(allItemRepository.findByItemCode(dto.getItemCode()).getId())
                .withWeight(dto.getWeight())
                .build();
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

    public ItemDto dropItem(String monsterCode) {
        Monster monster = monsterRepository.findByMonsterCode(monsterCode);
        List<DropMonster> dropMonsters = dropMonsterRepository.findByMonsterId(monster.getId());
        int weightSum = 0;
        for (int i = 0; i < dropMonsters.size(); i++) {
            weightSum = weightSum + dropMonsters.get(i).getWeight();
        }
        int weightDrop = ThreadLocalRandom.current().nextInt(1, weightSum);
        for (int i = 0; i < dropMonsters.size(); i++) {
            if (weightDrop <= dropMonsters.get(i).getWeight()) {
                return itemMapper.map(allItemRepository.findById(dropMonsters.get(i)
                        .getItemId()).orElse(null));
            }
        }
        throw new  RuntimeException("До этого места доходить не должно.");
    }
}

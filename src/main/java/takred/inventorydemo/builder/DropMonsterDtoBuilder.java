package takred.inventorydemo.builder;

import takred.inventorydemo.dto.DropMonsterDto;

public class DropMonsterDtoBuilder {
    private DropMonsterDto dropMonsterDto;

    public DropMonsterDtoBuilder() {
        dropMonsterDto = new DropMonsterDto();
    }

    public DropMonsterDtoBuilder withMonsterCode(String monsterCode) {
        dropMonsterDto.setMonsterCode(monsterCode);
        return this;
    }

    public DropMonsterDtoBuilder withItemCode(String itemCode) {
        dropMonsterDto.setItemCode(itemCode);
        return this;
    }

    public DropMonsterDtoBuilder withWeight(Integer weight) {
        dropMonsterDto.setWeight(weight);
        return this;
    }

    public DropMonsterDto build() {
        return dropMonsterDto;
    }
}

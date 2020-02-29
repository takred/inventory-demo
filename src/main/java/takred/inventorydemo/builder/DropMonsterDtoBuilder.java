package takred.inventorydemo.builder;

import takred.inventorydemo.dto.DropMonsterDto;

public class DropMonsterDtoBuilder {
    private String monsterCode;
    private String itemCode;
    private Integer weight;


//    public DropMonsterDtoBuilder() {
//        dropMonsterDto = new DropMonsterDto();
//    }

    public DropMonsterDtoBuilder withMonsterCode(String monsterCode) {
        this.monsterCode = monsterCode;
        return this;
    }

    public DropMonsterDtoBuilder withItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public DropMonsterDtoBuilder withWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public DropMonsterDto build() {
        return new DropMonsterDto(monsterCode, itemCode, weight);
    }
}

package takred.inventorydemo.builder;

import takred.inventorydemo.dto.ItemInInventoryDto;

import java.util.UUID;

public class ItemInInventoryDtoBuilder {
    private UUID id;
    private UUID itemId;
    private UUID personId;
    private boolean itemOn;

    public ItemInInventoryDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemInInventoryDtoBuilder withItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemInInventoryDtoBuilder withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public ItemInInventoryDtoBuilder withItemOn(boolean itemOn) {
        this.itemOn = itemOn;
        return this;
    }

    public ItemInInventoryDto build() {
        return new ItemInInventoryDto(id, itemId, personId, itemOn);
    }
}


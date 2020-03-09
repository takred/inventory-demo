package takred.inventorydemo.builder;

import takred.inventorydemo.dto.BattleLogDto;

import java.util.UUID;

public class BattleLogDtoBuilder {
    private UUID personId;
    private UUID battleId;
    private String message;
    private Integer turn;
    private UUID id;

    public BattleLogDtoBuilder withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public BattleLogDtoBuilder withBattleId(UUID battleId) {
        this.battleId = battleId;
        return this;
    }

    public BattleLogDtoBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public BattleLogDtoBuilder withTurn(Integer turn) {
        this.turn = turn;
        return this;
    }

    public BattleLogDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public BattleLogDto build() {
        return new BattleLogDto(personId, battleId, message, turn, id);
    }
}

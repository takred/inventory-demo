package takred.inventorydemo.builder;

import takred.inventorydemo.dto.BattleDto;

import java.util.List;
import java.util.UUID;

public class BattleDtoBuilder {
    private UUID personId;
    private UUID monsterId;
    private String monsterName;
    private Integer battleNumber;
    private UUID winner;
    private List<String> battleLog;
    private boolean lvlUp;
    private String error;
    private UUID id;

    public BattleDtoBuilder withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public BattleDtoBuilder withMonsterId(UUID monsterId) {
        this.monsterId = monsterId;
        return this;
    }

    public BattleDtoBuilder withMonsterName(String monsterName) {
        this.monsterName = monsterName;
        return this;
    }

    public BattleDtoBuilder withBattleNumber(Integer battleNumber) {
        this.battleNumber = battleNumber;
        return this;
    }

    public BattleDtoBuilder withWinner(UUID winner) {
        this.winner = winner;
        return this;
    }

    public BattleDtoBuilder withBattleLog(List<String> battleLog) {
        this.battleLog = battleLog;
        return this;
    }

    public BattleDtoBuilder withLvlUp(boolean lvlUp) {
        this.lvlUp = lvlUp;
        return this;
    }

    public BattleDtoBuilder withError(String error) {
        this.error = error;
        return this;
    }

    public BattleDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public BattleDto build() {
        return new BattleDto(personId, monsterId, monsterName,
                battleNumber, winner, battleLog, lvlUp, error, id);
    }
}

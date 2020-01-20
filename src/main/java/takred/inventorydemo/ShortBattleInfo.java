package takred.inventorydemo;

import lombok.Data;

import java.util.UUID;

@Data
public class ShortBattleInfo {
    private UUID battleId;
    private String info;

    public UUID getBattleId() {
        return battleId;
    }

    public void setBattleId(UUID battleId) {
        this.battleId = battleId;
    }
}

package takred.inventorydemo;

import java.util.UUID;

public class ShortBattleInfo {
    private UUID battleId;
    private String info;

    public UUID getBattleId() {
        return battleId;
    }

    public void setBattleId(UUID battleId) {
        this.battleId = battleId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

package takred.inventorydemo;

import lombok.Data;

import java.util.UUID;

@Data
public class ActResultDto {
    private Integer hpLostMonster;
    private Integer hpLostPeron;
    private UUID winner;
    private boolean lvlUp;
    private String message;

    public ActResultDto(String string) {
        hpLostMonster = null;
        hpLostPeron = null;
        winner = null;
        message = string;
    }

    public ActResultDto() {}
}

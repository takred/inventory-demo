package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.dto.DropMonsterDto;

import java.util.List;

@Data
public class DropMonsterListDto {
    private List<DropMonsterDto> parameters;
}

package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.entity.Monster;

import java.util.List;

@Data
public class MonsterListDto {
    private List<Monster> parameters;

//    public List<Monster> getParameters() {
//        return parameters;
//    }
}

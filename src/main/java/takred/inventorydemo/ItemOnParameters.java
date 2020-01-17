package takred.inventorydemo;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemOnParameters {
    private String namePerson;
    private UUID idObject;

//    public String getNamePerson() {
//        return namePerson;
//    }
//
//    public UUID getIdObject() {
//        return idObject;
//    }
}

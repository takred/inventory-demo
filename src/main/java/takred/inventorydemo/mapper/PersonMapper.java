package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto map(Person entity);
}

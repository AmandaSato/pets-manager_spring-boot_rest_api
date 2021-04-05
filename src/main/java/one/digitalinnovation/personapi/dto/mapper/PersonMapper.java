package one.digitalinnovation.personapi.dto.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// Utilizando o 'Mapstruct' será feita automaticamente a conversão do objeto DTO, para o
// objeto do Banco de dados.


@Mapper(componentModel = "spring")
public interface PersonMapper {

    // Instruções de mapeamneto do Parâmetro BirthDate, já que possui formatações
    // diferentes em cada objeto.
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}

package one.digitalinnovation.petapi.dto.mapper;

import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// Utilizando o 'Mapstruct' será feita automaticamente a conversão do objeto DTO, para o
// objeto do Banco de dados.


@Mapper(componentModel = "spring")
public interface PetMapper {

    // Instruções de mapeamneto do Parâmetro BirthDate, já que possui formatações
    // diferentes em cada objeto.
    @Mapping(target = "petBirthDate", source = "petBirthDate", dateFormat = "dd-MM-yyyy")
    Pet toModel(PetDTO dto);

    PetDTO toDTO(Pet dto);
}

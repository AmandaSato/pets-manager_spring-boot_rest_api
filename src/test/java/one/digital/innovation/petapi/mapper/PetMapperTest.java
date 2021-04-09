package one.digital.innovation.petapi.mapper;

import one.digitalinnovation.petapi.dto.mapper.PetMapper;
import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.dto.request.PhoneDTO;
import one.digitalinnovation.petapi.entities.Pet;
import one.digitalinnovation.petapi.entities.Phone;
import one.digital.innovation.petapi.utils.PetUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PetMapperTest {

    @Autowired
    private PetMapper petMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PetDTO petDTO = PetUtils.createFakeDTO();
        Pet pet = petMapper.toModel(petDTO);

        assertEquals(petDTO.getPetName(), pet.getPetName());
        assertEquals(petDTO.getOwnerName(), pet.getOwnerName());
        assertEquals(petDTO.getCpf(), pet.getCpf());

        Phone phone = pet.getPhones().get(0);
        PhoneDTO phoneDTO = petDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Pet pet = PetUtils.createFakeEntity();
        PetDTO petDTO = petMapper.toDTO(pet);

        assertEquals(pet.getPetName(), petDTO.getPetName());
        assertEquals(pet.getOwnerName(), petDTO.getOwnerName());
        assertEquals(pet.getCpf(), petDTO.getCpf());

        Phone phone = pet.getPhones().get(0);
        PhoneDTO phoneDTO = petDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }
}

package one.digital.innovation.petapi.services;

import one.digitalinnovation.petapi.dto.mapper.PetMapper;
import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.petapi.entities.Pet;
import one.digitalinnovation.petapi.repositories.PetRepository;
import one.digitalinnovation.petapi.services.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digital.innovation.petapi.utils.PetUtils.createFakeDTO;
import static one.digital.innovation.petapi.utils.PetUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetMapper petMapper;

    @InjectMocks
    private PetService petService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PetDTO petDTO = createFakeDTO();
        Pet expectedSavedPet = createFakeEntity();

        when(petMapper.toModel(petDTO)).thenReturn(expectedSavedPet);
        when(petRepository.save(any(Pet.class))).thenReturn(expectedSavedPet);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPet.getId());
        MessageResponseDTO successMessage = petService.create(petDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Pet successfully created with ID " + savedPersonId)
                .build();
    }

}

package one.digitalinnovation.petapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.petapi.dto.mapper.PetMapper;
import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.petapi.entities.Pet;
import one.digitalinnovation.petapi.exception.PetNotFoundException;
import one.digitalinnovation.petapi.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Cria-se a Classe de Serviços como uma Boa Prática, para realizar separação de responsabilidades.

// Não cabe ao nosso Controller aplicar Regras de Negócio. Por isso, criamos uma classe responsável
// unicamente por essa função.

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public MessageResponseDTO create(PetDTO petDTO) {
        Pet pet = petMapper.toModel(petDTO);
        Pet savedPet = petRepository.save(pet);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPet.getId());

        return messageResponse;
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));

        return petMapper.toDTO(pet);
    }

    public List<PetDTO> listAll() {
        List<Pet> pet = petRepository.findAll();
        return pet.stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PetDTO personDTO) throws PetNotFoundException {
        petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));

        Pet updatedPerson = petMapper.toModel(personDTO);
        Pet savedPerson = petRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PetNotFoundException {
        petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));

        petRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}

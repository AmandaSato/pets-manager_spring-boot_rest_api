package one.digitalinnovation.petapi.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.petapi.exception.PetNotFoundException;
import one.digitalinnovation.petapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")

@AllArgsConstructor(onConstructor = @__(@Autowired))
// @Autowired faz uma injeção da implementação

public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PetDTO petDTO) {
        return petService.create(petDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }

    @GetMapping
    public List<PetDTO> listAll() {
        return petService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) throws PetNotFoundException {
        return petService.update(id, petDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PetNotFoundException {
        petService.delete(id);
    }
}

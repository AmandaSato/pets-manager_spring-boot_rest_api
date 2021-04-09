package one.digitalinnovation.petapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.util.List;

// DTO
// É o objeto responsável por receber todos os dados de entrada e mapea-los.
// É uma forma de receber os dados sem mapea-los diretamente na respectiva Entity.
// Isso permite fazer uma validação (em temppo de execução) mais cuidadosa e controlar
// melhor as mensagens de erro exibidas para o usuário.

//Anotações do Lombok:
// Permitem realizar os métodos getter e setter de forma facilitada.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String petName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String breed;

    @NotEmpty
    @Pattern(regexp="\\d{2},\\d{2}kg")
    private String petWeight;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String ownerName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String petBirthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}

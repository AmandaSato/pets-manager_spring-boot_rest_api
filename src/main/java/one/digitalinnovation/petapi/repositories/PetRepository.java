package one.digitalinnovation.petapi.repositories;

import one.digitalinnovation.petapi.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

// Vantagens de extender a classe JpaRepository:
// Não precisa abrir e fechar conexão com Bancos de dados
// Faz todo o gerenciamento do Banco de dados

// Atributos
// Person -> entidade que queremos representar
// Long -> tipo de dado
public interface PetRepository extends JpaRepository<Pet, Long> {
}

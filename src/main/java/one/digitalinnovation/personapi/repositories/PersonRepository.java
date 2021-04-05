package one.digitalinnovation.personapi.repositories;

import one.digitalinnovation.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// Vantagens de extender a classe JpaRepository:
// Não precisa abrir e fechar conexão com Bancos de dados
// Faz todo o gerenciamento do Banco de dados

// Atributos
// Person -> entidade que queremos representar
// Long -> tipo de dado
public interface PersonRepository extends JpaRepository<Person, Long> {
}

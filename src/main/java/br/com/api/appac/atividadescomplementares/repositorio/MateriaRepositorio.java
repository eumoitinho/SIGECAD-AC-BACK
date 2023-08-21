package br.com.api.appac.atividadescomplementares.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.materia.Materia;

@Repository
public interface MateriaRepositorio extends CrudRepository<Materia, Long> {
    // Esta interface "MateriaRepositorio" estende a interface "CrudRepository" do Spring Data JPA.
    // Isso fornece métodos básicos de CRUD (Create, Read, Update, Delete) para a entidade "Materia".
    // A anotação "@Repository" indica que esta interface é um repositório Spring gerenciado.
    // Não foram adicionados métodos personalizados neste exemplo, apenas os métodos padrão.
}

package br.com.api.appac.atividadescomplementares.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.cursos.Curso;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long> {
    // Esta interface "CursoRepositorio" estende a interface "CrudRepository" do Spring Data JPA.
    // Isso fornece métodos básicos de CRUD (Create, Read, Update, Delete) para a entidade "Curso".
    // A anotação "@Repository" indica que esta interface é um repositório Spring gerenciado.
    // Não foram adicionados métodos personalizados neste exemplo, apenas os métodos padrão.
}

package br.com.api.appac.atividadescomplementares.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.cursos.Curso;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long> {
    
}

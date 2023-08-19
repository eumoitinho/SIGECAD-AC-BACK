package br.com.api.appac.atividadescomplementares.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.materia.Materia;

@Repository
public interface MateriaRepositorio extends CrudRepository<Materia, Long> {

}

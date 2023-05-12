package mateus.CRUD.model.repository;

import mateus.CRUD.model.entity.Manga;
import org.springframework.data.repository.CrudRepository;

public interface MangaRepository extends CrudRepository<Manga,Integer> {
}

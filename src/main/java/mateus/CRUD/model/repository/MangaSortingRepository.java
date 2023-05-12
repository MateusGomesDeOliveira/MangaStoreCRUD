package mateus.CRUD.model.repository;

import mateus.CRUD.model.entity.Manga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MangaSortingRepository extends PagingAndSortingRepository<Manga,Integer> {
    public Iterable<Manga> findByTitleContaining(String title);
    public Iterable<Manga> findByAuthorContaining(String author);
    @Query("SELECT m FROM Manga m WHERE m.oneShot = true")
    public Iterable<Manga> findAllOneShotManga();
    @Query("SELECT m FROM Manga m WHERE m.price <= :price")
    public Iterable<Manga> findPriceLessThan(@Param("price")double price);
}


package jwd.knjizara.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.Pivo;

@Repository
public interface PivoRepository 
	extends JpaRepository<Pivo, Long> {

	Page<Pivo> findByPivaraId(Long mestoId, Pageable pageRequest);

	@Query("SELECT k FROM Pivo k WHERE "
			+ "(:naziv IS NULL or k.naziv like :naziv ) AND "
			+ "(:minI IS NULL OR k.IBU  >= :minI  ) AND "
			+ "(:maxI IS NULL OR k.IBU <= :maxI) AND "
			+ "(:pivaraNaziv IS NULL OR k.pivara.naziv  like :pivaraNaziv ) AND"
			+ "(:kolicina IS NULL OR k.kolicina = :kolicina)"
			)

	Page<Pivo> pretraga(
			@Param("naziv") String naziv, 
			@Param("minI") Double minI, //pisac
			@Param("maxI") Double maxI,
			@Param("pivaraNaziv") String pivaraNaziv,
			@Param("kolicina") Integer kolicina,
			Pageable pageRequest);
	
	

	// pretraga dugme NESTALO
	@Query("SELECT k FROM Pivo k WHERE  k.kolicina = 0" )
	Page<Pivo> nestalo(Pageable pageRequest);
}

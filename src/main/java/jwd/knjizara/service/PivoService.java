package jwd.knjizara.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.knjizara.model.Pivo;

public interface PivoService {
	Page<Pivo> findAll(int pageNum);
	Pivo findOne(Long id);
	void save(Pivo pivo);
	void remove(Long id);
	Page<Pivo> findByPivaraId(int pageNum, Long pivaraId);
	Page<Pivo> pretraga(
			@Param("naziv") String naziv, 
			//@Param("vrsta") String vrsta, 
			@Param("minI") Double minI, 
			@Param("maxI") Double maxI,
//			@Param("maxKolicina") Integer maxKolicina,
			@Param("pivaraNaziv") String pivaraNaziv,
			@Param("kolicina") Integer kolicina,
			int page);
	
	
	// dugme nestalo
	Page<Pivo> nestalo(int page);
	
//	Page<Pivo> pretraga( 
//			@Param("naziv") String naziv, 
//			@Param("minI") Double pisac, 
//			@Param("maxI") Double maxK,
//			@Param("pivaraNaziv") String pivaraNaziv,
//			@Param("kolicina") Integer kolicina,
//			int page);
}

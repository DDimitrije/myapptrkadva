package jwd.knjizara.service;

import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import jwd.knjizara.model.Trkac;

public interface TrkacService {

	Page<Trkac> findAll(int pageNum);
	Trkac findOne(Long id);
	void save(Trkac trkac);
	void remove(Long id);
	Page<Trkac> findByTrkaId(int pageNum, Long trkaId);
	Page<Trkac> pretraga(@Param("ime") String ime, 
			@Param("prezime") String prezime, 
			@Param("pol") String pol,
			@Param("velicinaMajce") String velicinaMajce,
			@Param("adresa") String adresa,
			@Param("grad") String grad,
			@Param("drzava") String drzava,
			@Param("najBoljeVreme") String najBoljeVreme,
			@Param("klub") String klub,
			int page);
			
	// dugme nestalo
	//Page<Trkac> nestalo(int page);

}

package jwd.knjizara.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Trka;

public interface TrkaService {

//	Page<Trka> findAll(int pageNum);
//	Trka findOne(Long id);
//	void save(Trka trka);
//	void remove(Long id);
	
	List<Trka> findAll();
	Trka findOne(Long id);
	void save(Trka trka);
	void remove(Long id);

	
	
	//Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId);//pivaraID

	Page<Trka> pretraga(
			@Param("duzinaStaze") String duzinaStaze,  
			@Param("kategorija") String kategorija, 
			int page);
	
	
	//Page<Manifestacija> pretraga(String naziv, Date datumOdrzavanja, String mestoOdrzavanja, int page);
	
}

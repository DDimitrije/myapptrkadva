package jwd.knjizara.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Trka;
import jwd.knjizara.model.Trkac;
import jwd.knjizara.repository.TakmicenjaGodinaRepository;
import jwd.knjizara.repository.TrkaRepository;
import jwd.knjizara.service.TakmicenjaGodinaService;
import jwd.knjizara.service.TrkaService;
/*
public class JpaTrkaServiceImpl implements TrkaService {
	@Autowired
	private TrkaRepository trkaRepository;
	
	@Override
	public Page<Trka> findAll(int pageNum) {
		return trkaRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Trka findOne(Long id) {
		return trkaRepository.findOne(id);
	}

	@Override
	public void save(Trka trka) {
		trkaRepository.save(trka);
	}

	@Override
	public void remove(Long id) {
		trkaRepository.delete(id);
	}

//	@Override
//	public Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId) {
//
//		return trkaRepository.findByManifestacijaId(manifestacijaId, new PageRequest(pageNum, 5));
//	}

	@Override
	public Page<Trka> pretraga(String duzinaStaze, String kategorija,  int page) {// String
																														// nazivPivare,
																										// Strin																												// nazivPivare
//		if (naziv != null) {
//			naziv = "%" + naziv + "%";
//		}
		return trkaRepository.pretraga(duzinaStaze, kategorija,  new PageRequest(page, 5));// nazivPivare
		//String duzinaStaze, @Param("kategorija") String kategorija,
		//Pageable pageRequest																							// nazivPivare,
																										// kolicina
																											// ,
	}

	// dugme nestalo
//	@Override
//	public Page<Manifestacija> nestalo(int page) {
//
//		return manifestacijaRepository.nestalo(new PageRequest(page, 5));
//	}
	

}*/
import jwd.knjizara.model.Trka;
import jwd.knjizara.repository.TrkaRepository;
import jwd.knjizara.service.TrkaService;


@Service
@Transactional
public class JpaTrkaServiceImpl implements TrkaService {
	
	@Autowired
	private TrkaRepository trkaRepository;

	@Override
	public List<Trka> findAll() {
		return trkaRepository.findAll();
	}

	@Override
	public Trka findOne(Long id) {
		return trkaRepository.findOne(id);
	}

	@Override
	public void save(Trka trka) {
		trkaRepository.save(trka);
	}

	@Override
	public void remove(Long id) {
		trkaRepository.delete(id);
	}

//	@Override
//	public Page<Trka> pretraga(String duzinaStaze, String kategorija, int page) {
//		// TODO Auto-generated method stub
//		return trkaRepository.pretraga(duzinaStaze, kategorija,  new PageRequest(page, 5));
//	}
	
}

package jwd.knjizara.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.repository.ManifestacijaRepository;
import jwd.knjizara.service.ManifestacijaService;

@Service
@Transactional
public class JpaManifestacijaServiceImpl implements ManifestacijaService {

	@Autowired
	private ManifestacijaRepository manifestacijaRepository;
	
	@Override
	public Page<Manifestacija> findAll(int pageNum) {
		return manifestacijaRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Manifestacija findOne(Long id) {
		return manifestacijaRepository.findOne(id);
	}

	@Override
	public void save(Manifestacija manifestacija) {
		manifestacijaRepository.save(manifestacija);
	}

	@Override
	public void remove(Long id) {
		manifestacijaRepository.delete(id);
	}

	@Override
	public Page<Manifestacija> findByTakmicenjaGodinaId(int pageNum, Long takmicenjaGodinaId) {

		return manifestacijaRepository.findByTakmicenjaGodinaId(takmicenjaGodinaId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Manifestacija> pretraga(String naziv, String datumOdrzavanja, String mestoOdrzavanja,  int page) {																							
																																																					// nazivPivare
//		if (naziv != null) {
//			naziv = "%" + naziv + "%";
//		}
		return manifestacijaRepository.pretraga(naziv, datumOdrzavanja, mestoOdrzavanja,  new PageRequest(page, 5));																																																																										
	}
}

package jwd.knjizara.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import jwd.knjizara.model.Pivo;
import jwd.knjizara.repository.PivoRepository;
import jwd.knjizara.service.PivoService;

@Service
@Transactional
public class JpaPivoServiceImpl implements PivoService {
	
	@Autowired
	private PivoRepository pivoRepository;

	@Override
	public Page<Pivo> findAll(int pageNum) {
		return pivoRepository.findAll(
				new PageRequest(pageNum, 5));
	}

	@Override
	public Pivo findOne(Long id) {
		return pivoRepository.findOne(id);
	}

	@Override
	public void save(Pivo pivo) {
		pivoRepository.save(pivo);
	}

	@Override
	public void remove(Long id) {
		pivoRepository.delete(id);
	}

	@Override
	public Page<Pivo> findByPivaraId(int pageNum, Long pivaraId) {
		
		return pivoRepository.findByPivaraId(pivaraId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Pivo> pretraga(String naziv, Double minI, Double maxI, String pivaraNaziv, Integer kolicina, int page) {//String nazivPivare, Integer kolicina,  String nazivPivare
		if(naziv != null ){
			naziv = "%" + naziv + "%";
		}
		return pivoRepository.pretraga(naziv,  minI, maxI,  pivaraNaziv, kolicina, new PageRequest(page, 5));//nazivPivare nazivPivare,  kolicina ,
	}
	
	// dugme nestalo
	@Override
	public Page<Pivo> nestalo(int page) {
		
		return pivoRepository.nestalo(new  PageRequest(page, 5));
	}

}

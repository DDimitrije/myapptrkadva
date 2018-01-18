package jwd.knjizara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Pivo;

import jwd.knjizara.model.KupovinaPivo;
import jwd.knjizara.repository.PivoRepository;
import jwd.knjizara.repository.KupovinaPivoRepository;
import jwd.knjizara.service.KupovinaPivoService;

@Service
public class JpaKupovinaPivoServiceImpl implements KupovinaPivoService{
	
	@Autowired
	private KupovinaPivoRepository kupovinaPivoRepository;
	@Autowired
	private PivoRepository pivoRepository;
	
	@Override
	public KupovinaPivo buyABook(Long pivoId) {
		
		if(pivoId == null) {
			throw new IllegalArgumentException("Id of a book cannot be null!");
		}
		
		Pivo pivo = pivoRepository.findOne(pivoId);
		if(pivo == null) {
			throw new IllegalArgumentException("There is no book with given id!");
		}
		
		if(pivo.getKolicina() > 0) {
			
			KupovinaPivo kupovina = new KupovinaPivo();
			kupovina.setPivo(pivo);
			
			pivo.setKolicina(pivo.getKolicina() - 1);
			
			kupovinaPivoRepository.save(kupovina);
			pivoRepository.save(pivo);
			
			return kupovina;
		}
		
		return null;
		
	}
}

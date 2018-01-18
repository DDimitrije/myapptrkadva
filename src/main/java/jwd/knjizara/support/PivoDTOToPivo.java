package jwd.knjizara.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Pivo;
import jwd.knjizara.service.PivoService;
import jwd.knjizara.service.PivaraService;
import jwd.knjizara.web.dto.PivoDTO;


@Component
public class PivoDTOToPivo 
	implements Converter<PivoDTO, Pivo>{
	
	@Autowired
	private PivoService pivoService;
	@Autowired
	private PivaraService pivaraService;
	
	
	@Override
	public Pivo convert(PivoDTO source) {
		Pivo pivo;
		if(source.getId()==null){
			pivo = new Pivo();
			pivo.setPivara(pivaraService.findOne(source.getPivaraId()));
			//pivo.setVrstaPiva(vrstaService.findOne(source.getVrstaPivaId()));
		}else{
			pivo = pivoService.findOne(source.getId());
		}
		pivo.setNaziv(source.getNaziv());
		pivo.setVrsta(source.getVrsta());
		pivo.setIBU(source.getIBU());
		pivo.setKolicina(source.getKolicina());
		pivo.setProcenat_alkohola(source.getProcenat_alkohola());
		pivo.setPivara(pivaraService.findOne(source.getPivaraId()));
		
		
//		pivo.setId(source.getId());
//		pivo.setNaziv(source.getNaziv());
//		pivo.setProcenat_alkohola(source.getProcenat_alkohola());
//		pivo.setIBU(source.getIBU());
//		pivo.setKolicina(source.getKolicina());
//		
//		pivo.setPivaraId(source.getPivaraId());
//		pivo.setPivara(source.getPivaraNaziv());
		return pivo;
	}

}

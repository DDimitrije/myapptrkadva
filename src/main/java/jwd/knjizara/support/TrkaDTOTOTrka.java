package jwd.knjizara.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Trka;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.service.PivaraService;
import jwd.knjizara.service.TrkaService;
import jwd.knjizara.web.dto.TrkaDTO;

@Component
public class TrkaDTOTOTrka implements Converter<TrkaDTO, Trka> {

	@Autowired
	private TrkaService trkaService;
	@Autowired
	//private ManifestacijaService manifestacijaService;

	@Override
	public Trka convert(TrkaDTO source) {
		Trka trka;
		if (source.getId() == null) {
			trka = new Trka();
	//		trka.setManifestacija(manifestacijaService.findOne(source.getManifestacijaId()));
			// trka.setVrstaPiva(vrstaService.findOne(source.getVrstaPivaId()));
		} else {
			trka = trkaService.findOne(source.getId());
		}
		trka.setDuzinaStaze(source.getDuzinaStaze());
		trka.setKategorija(source.getKategorija());
//		trka.setIBU(source.getIBU());
//		trka.setKolicina(source.getKolicina());
//		trka.setProcenat_alkohola(source.getProcenat_alkohola());
	//	trka.setManifestacija(manifestacijaService.findOne(source.getManifestacijaId()));

		// trka.setId(source.getId());
		// trka.setNaziv(source.getNaziv());
		// trka.setProcenat_alkohola(source.getProcenat_alkohola());
		// trka.setIBU(source.getIBU());
		// trka.setKolicina(source.getKolicina());
		//
		// trka.setPivaraId(source.getPivaraId());
		// trka.setPivara(source.getPivaraNaziv());
		return trka;
	}

}

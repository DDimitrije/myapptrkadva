package jwd.knjizara.support;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.service.TakmicenjaGodinaService;
import jwd.knjizara.web.dto.ManifestacijaDTO;


@Component
public class ManifestacijaDTOTOManifestacija implements Converter<ManifestacijaDTO, Manifestacija> {

	@Autowired
	private ManifestacijaService manifestacijaService;
	@Autowired
	private TakmicenjaGodinaService takmicenjaGodinaService;

	@Override
	public Manifestacija convert(ManifestacijaDTO source) {
		Manifestacija manifestacija;
		if (source.getId() == null) {
			manifestacija = new Manifestacija();
			manifestacija.setTakmicenjaGodina(takmicenjaGodinaService.findOne(source.getTakmicenjaGodinaId()));
			// pivo.setVrstaPiva(vrstaService.findOne(source.getVrstaPivaId()));
		} else {
			manifestacija = manifestacijaService.findOne(source.getId());
		}
		manifestacija.setNaziv(source.getNaziv());
		manifestacija.setDatumOdrzavanja(source.getDatumOdrzavanja());
		manifestacija.setMestoOdrzavanja(source.getMestoOdrzavanja());
		manifestacija.setTakmicenjaGodina(takmicenjaGodinaService.findOne(source.getTakmicenjaGodinaId()));
		//manifestacija.setTakmicenjaGodina(source.getTakmicenjaGodinaId());
		
//		private String naziv;
//		@Column
//		private Date datumOdrzavanja;
//		@Column
//		private String mestoOdrzavanja;	
//		
//		@ManyToOne(fetch=FetchType.EAGER)
//		private TakmicenjaGodina takmicenjaGodina;
//		--------------
//		pivo.setKolicina(source.getKolicina());
//		pivo.setProcenat_alkohola(source.getProcenat_alkohola());
//		pivo.setPivara(pivaraService.findOne(source.getPivaraId()));

		// pivo.setId(source.getId());
		// pivo.setNaziv(source.getNaziv());
		// pivo.setProcenat_alkohola(source.getProcenat_alkohola());
		// pivo.setIBU(source.getIBU());
		// pivo.setKolicina(source.getKolicina());
		//
		// pivo.setPivaraId(source.getPivaraId());
		// pivo.setPivara(source.getPivaraNaziv());
		return manifestacija;
	}
}

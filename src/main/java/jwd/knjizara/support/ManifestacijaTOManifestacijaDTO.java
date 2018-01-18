package jwd.knjizara.support;

import java.util.ArrayList;

import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.web.dto.ManifestacijaDTO;

@Component
public class ManifestacijaTOManifestacijaDTO implements Converter<Manifestacija, ManifestacijaDTO> {

	@Override
	public ManifestacijaDTO convert(Manifestacija source) {
		ManifestacijaDTO dto = new ManifestacijaDTO();
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setDatumOdrzavanja(source.getDatumOdrzavanja());
		dto.setMestoOdrzavanja(source.getMestoOdrzavanja());
		dto.setTakmicenjaGodinaId(source.getTakmicenjaGodina().getId());
//		dto.setTakmicenja(takmicenjaGodinaId);(source.getPivara().getNaziv());
//		dto.setProcenat_alkohola(source.getProcenat_alkohola());
//		dto.setKolicina(source.getKolicina());
//		dto.setPivaraId(source.getPivara().getId());
//		dto.setPivaraNaziv(source.getPivara().getNaziv());

		return dto;
	}

	public List<ManifestacijaDTO> convert(List<Manifestacija> manifestacije) {
		List<ManifestacijaDTO> ret = new ArrayList<>();

		for (Manifestacija k : manifestacije) {
			ret.add(convert(k));
		}

		return ret;
	}
}

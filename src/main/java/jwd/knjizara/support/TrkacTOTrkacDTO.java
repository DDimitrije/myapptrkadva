package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Trkac;
import jwd.knjizara.web.dto.TrkacDTO;

@Component
public class TrkacTOTrkacDTO implements Converter<Trkac, TrkacDTO> {

	@Override
	public TrkacDTO convert(Trkac source) {
		TrkacDTO dto = new TrkacDTO();
		dto.setId(source.getId());
		dto.setPrezime(source.getPrezime());
		dto.setPol(source.getPol());
		dto.setVelicinaMajce(source.getVelicinaMajce());
		dto.setAdresa(source.getAdresa());
		dto.setGrad(source.getGrad());
		dto.setDrzava(source.getDrzava());
		dto.setNajBoljeVreme(source.getNajBoljeVreme());
		dto.setKlub(source.getKlub());
		
		
		dto.setTrkaId(source.getTrka().getId());
//		dto.setTrkaNaziv(source.getTrka().getManifestacija().getNaziv());
		// dto.setVrstaPivaId(source.getVrstaPiva().getId());
		// dto.setVrstaPivaNaziv(source.getVrstaPiva().getNaziv());

		return dto;
	}

	public List<TrkacDTO> convert(List<Trkac> trkaci) {
		List<TrkacDTO> ret = new ArrayList<>();

		for (Trkac k : trkaci) {
			ret.add(convert(k));
		}

		return ret;
	}

}

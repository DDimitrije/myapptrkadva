package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Pivara;
import jwd.knjizara.web.dto.PivaraDTO;

@Component
public class PivaraToPivaraDTO 
	implements Converter<Pivara, PivaraDTO> {

	@Override
	public PivaraDTO convert(Pivara pivara) {
		PivaraDTO pivaraDTO = new PivaraDTO();
		pivaraDTO.setId(pivara.getId());
		pivaraDTO.setNaziv(pivara.getNaziv());
		pivaraDTO.setPIB(pivara.getPIB());
		pivaraDTO.setDrzava(pivara.getDrzava());
		return pivaraDTO;
	}

	public List<PivaraDTO> convert(List<Pivara> pivare) {
		List<PivaraDTO> ret = new ArrayList<>();
		
		for(Pivara i: pivare){
			ret.add(convert(i));
		}
		
		return ret;
	}
}
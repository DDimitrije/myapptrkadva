package jwd.knjizara.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.KupovinaPivo;
import jwd.knjizara.web.dto.KupovinaPivoDTO;

@Component
public class KupovinaPivoToKupovinaPivoDTO implements Converter<KupovinaPivo, KupovinaPivoDTO> {

	@Override
	public KupovinaPivoDTO convert(KupovinaPivo arg0) {
		
		KupovinaPivoDTO dto = new KupovinaPivoDTO();
		dto.setId(arg0.getId());
		
		return dto;
	}

}

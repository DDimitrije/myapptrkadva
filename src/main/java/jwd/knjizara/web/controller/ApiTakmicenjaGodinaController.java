package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.service.TakmicenjaGodinaService;
import jwd.knjizara.support.ManifestacijaTOManifestacijaDTO;
import jwd.knjizara.support.TakmicenjaGodinaTOTakmicenjaGodinaDTO;
import jwd.knjizara.web.dto.ManifestacijaDTO;
import jwd.knjizara.web.dto.TakmicenjaGodinaDTO;

@RestController
@RequestMapping(value = "/api/takmicenjagodina")
public class ApiTakmicenjaGodinaController {// pivarai
	@Autowired
	private TakmicenjaGodinaService takmicenjaGodinaService;
	@Autowired
	private ManifestacijaService manifestacijaService;
	@Autowired
	private TakmicenjaGodinaTOTakmicenjaGodinaDTO toDTO;
	@Autowired
	private ManifestacijaTOManifestacijaDTO toManifestacijaDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TakmicenjaGodinaDTO>> get() {
		return new ResponseEntity<>(toDTO.convert(takmicenjaGodinaService.findAll()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TakmicenjaGodinaDTO> get(@PathVariable Long id) {

		TakmicenjaGodina takmicenjaGodina = takmicenjaGodinaService.findOne(id);

		if (takmicenjaGodina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(takmicenjaGodina), HttpStatus.OK);
	}

	@RequestMapping(value = "/{takmicenjaGodinaId}/manifestacije")
	public ResponseEntity<List<ManifestacijaDTO>> manifestacijaTakmicenjaGodina(@PathVariable Long takmicenjaGodinaId,
			@RequestParam(defaultValue = "0") int pageNum) {
		Page<Manifestacija> manifestacije = manifestacijaService.findByTakmicenjaGodinaId(pageNum, takmicenjaGodinaId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(manifestacije.getTotalPages()));
		return new ResponseEntity<>(toManifestacijaDTO.convert(manifestacije.getContent()), headers, HttpStatus.OK);
		
		
		
	}
}

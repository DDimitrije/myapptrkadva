package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.knjizara.model.Pivo;
import jwd.knjizara.model.KupovinaPivo;
import jwd.knjizara.service.PivoService;
import jwd.knjizara.service.KupovinaPivoService;
import jwd.knjizara.support.PivoDTOToPivo;
import jwd.knjizara.support.PivoToPivoDTO;
import jwd.knjizara.support.KupovinaPivoToKupovinaPivoDTO;
import jwd.knjizara.web.dto.PivoDTO;
import jwd.knjizara.web.dto.KupovinaPivoDTO;

@RestController
@RequestMapping("/api/piva")
public class ApiPivoController {
	@Autowired
	private PivoService pivoService;
	@Autowired
	private KupovinaPivoService kupovinaPivoService;
	@Autowired
	private PivoToPivoDTO toPivoDTO;
	@Autowired
	private KupovinaPivoToKupovinaPivoDTO toKupovinaDTO;
	@Autowired
	private PivoDTOToPivo toPivo;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PivoDTO>> get(
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) String vrsta,
			@RequestParam(required=false) Double minI,
			@RequestParam(required=false) Double maxI,
			//@RequestParam(required=false) Integer maxKolicina,
			@RequestParam(required=false) String pivaraNaziv,
			@RequestParam(required=false) Integer kolicina,
			@RequestParam Boolean proveraNestalo, // dugme nestalo
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Pivo> piva;
		//(String naziv, Double minI, Double maxI, String pivaraNaziv, Integer kolicina, int page
		if(naziv != null || minI != null || maxI != null || pivaraNaziv!= null ||  kolicina!= null) { //|| nazivPivare != null ||  kolicina != null) {
			piva = pivoService.pretraga(naziv, minI, maxI,pivaraNaziv, kolicina, pageNum); //nazivPivare,  kolicina, pageNum); //nazivPivare,
		//Dugme Nestalo
		}else{
			if(proveraNestalo == true){
				piva = pivoService.nestalo(pageNum);
			}else{
			piva = pivoService.findAll(pageNum);
		}
	}	
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(piva.getTotalPages()) );
		return  new ResponseEntity<>(
				toPivoDTO.convert(piva.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<PivoDTO> get(
			@PathVariable Long id){
		Pivo pivo = pivoService.findOne(id);
		
		if(pivo==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toPivoDTO.convert(pivo),
				HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PivoDTO> add(
			@RequestBody PivoDTO novaPivo){
		
		Pivo pivo = toPivo.convert(novaPivo); 
		pivoService.save(pivo);
		
		return new ResponseEntity<>(toPivoDTO.convert(pivo),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}/kupovina")
	public ResponseEntity<KupovinaPivoDTO> buy(@PathVariable Long id){
		
		KupovinaPivo k = kupovinaPivoService.buyABook(id);
		
		if(k == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(toKupovinaDTO.convert(k), HttpStatus.CREATED);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<PivoDTO> edit(
			@PathVariable Long id,
			@RequestBody PivoDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Pivo pivo = toPivo.convert(izmenjen); 
		pivoService.save(pivo);
		
		return new ResponseEntity<>(toPivoDTO.convert(pivo),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<PivoDTO> delete(@PathVariable Long id){
		pivoService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

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

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.support.ManifestacijaDTOTOManifestacija;
import jwd.knjizara.support.ManifestacijaTOManifestacijaDTO;
import jwd.knjizara.web.dto.KnjigaDTO;
import jwd.knjizara.web.dto.ManifestacijaDTO;


	
@RestController
@RequestMapping("/api/manifestacija")
public class ApiMenifestacijaController {
		@Autowired
		private ManifestacijaService manifestacijaService;
		@Autowired
		private ManifestacijaTOManifestacijaDTO toMenifestacijaDTO;
		@Autowired
		private ManifestacijaDTOTOManifestacija toManifestacija;
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<ManifestacijaDTO>> get(
				@RequestParam(required=false) String naziv,
				@RequestParam(required=false) String datumOdrzavanja,
				@RequestParam(required=false) String mestoOdrzavanja,
				@RequestParam(defaultValue="0") int pageNum){
			

			Page<Manifestacija> manifestacije;
			if(naziv != null || datumOdrzavanja != null || mestoOdrzavanja != null ) { 
				manifestacije = manifestacijaService.pretraga(naziv, datumOdrzavanja, mestoOdrzavanja, pageNum); 
			//Dugme Nestalo
			}else{
				manifestacije = manifestacijaService.findAll(pageNum);
		}	
			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", Integer.toString(manifestacije.getTotalPages()) );
			return  new ResponseEntity<>(
					toMenifestacijaDTO.convert(manifestacije.getContent()),
					headers,
					HttpStatus.OK);
		}	
		
		@RequestMapping(method=RequestMethod.GET, value="/{id}")
		public ResponseEntity<ManifestacijaDTO> get(
				@PathVariable Long id){
			Manifestacija manifestacija = manifestacijaService.findOne(id);
			
			if(manifestacija==null){
				return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(
					toMenifestacijaDTO.convert(manifestacija),
					HttpStatus.OK);	
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<ManifestacijaDTO> add(
				@RequestBody ManifestacijaDTO novaManifestacija){
			
			Manifestacija manifestacija = toManifestacija.convert(novaManifestacija); 
			manifestacijaService.save(manifestacija);
			
			return new ResponseEntity<>(toMenifestacijaDTO.convert(manifestacija),
					HttpStatus.CREATED);
		}
		
//		@RequestMapping(method=RequestMethod.POST, value="/{id}/kupovina")
//		public ResponseEntity<KupovinaManifestacijaDTO> buy(@PathVariable Long id){
//			
//			KupovinaManifestacija k = kupovinaManifestacijaService.buyABook(id);
//			
//			if(k == null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}else {
//				return new ResponseEntity<>(toKupovinaDTO.convert(k), HttpStatus.CREATED);
//			}
//			
//		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/{id}")
		public ResponseEntity<ManifestacijaDTO> edit(
				@PathVariable Long id,
				@RequestBody ManifestacijaDTO izmenjen){
			
			if(!id.equals(izmenjen.getId())){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Manifestacija manifestacija = toManifestacija.convert(izmenjen); 
			manifestacijaService.save(manifestacija);
			
			return new ResponseEntity<>(toMenifestacijaDTO.convert(manifestacija),
					HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
		public ResponseEntity<ManifestacijaDTO> delete(@PathVariable Long id){
			manifestacijaService.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
}

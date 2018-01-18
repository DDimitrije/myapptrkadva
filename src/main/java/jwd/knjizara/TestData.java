package jwd.knjizara;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.Pivara;
import jwd.knjizara.model.Pivo;
import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Izdavac;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.service.PivaraService;
import jwd.knjizara.service.PivoService;
import jwd.knjizara.service.TakmicenjaGodinaService;
import jwd.knjizara.service.IzdavacService;

@Component
public class TestData {
	@Autowired
	private IzdavacService izdavacService;
	@Autowired
	private PivaraService pivaraService;
	@Autowired
	private KnjigaService knjigaService;
	@Autowired
	private PivoService pivoService;
	@Autowired
	private TakmicenjaGodinaService takmicenjaGodinaService;
	@Autowired
	private ManifestacijaService manifestacijaService;

	@PostConstruct
	public void init() {
		
		Izdavac i1 = new Izdavac();
		i1.setNaziv("Polet");
		i1.setEmail("polet@gmail.com");
		i1.setTelefon("0667612312");
		izdavacService.save(i1);
		
		Izdavac i2 = new Izdavac();
		i2.setNaziv("Delfi");
		i2.setEmail("delfi@gmail.com");
		i2.setTelefon("0661233211");
		izdavacService.save(i2);
		
		Knjiga k1 = new Knjiga();
		k1.setISBN("1100110011");
		k1.setNaziv("Faust");
		k1.setKolicina(10);
		k1.setPisac("Johan Volfgang Gete");
		k1.setIzdavac(i2);
		k1.setCena(1231.00);
		knjigaService.save(k1);
		
		Knjiga k2 = new Knjiga();
		k2.setISBN("12312312");
		k2.setNaziv("Tako je govorio Zaratustra");
		k2.setKolicina(15);
		k2.setPisac("Fridrih Nice");
		k2.setIzdavac(i2);
		k2.setCena(1250.00);
		knjigaService.save(k2);
		
		Pivara p1 = new Pivara();
		p1.setNaziv("Polet");
		p1.setPIB("2334334");
		p1.setDrzava("Srbija");
		pivaraService.save(p1);
		
		Pivara p2 = new Pivara();
		p2.setNaziv("Delfi");
		p2.setPIB("12344");
		p2.setDrzava("Rusija");
		pivaraService.save(p2);
		
		Pivo pi1 = new Pivo();
		pi1.setIBU(3.0);
		pi1.setNaziv("Faust");
		pi1.setKolicina(10);
		pi1.setVrsta("Johan Volfgang Gete");
		pi1.setProcenat_alkohola(4.5);
		pi1.setPivara(p1);
		pivoService.save(pi1);
		
		Pivo pi2 = new Pivo();
		pi2.setIBU(4.0);
		pi2.setNaziv("Tako je govorio Zaratustra");
		pi2.setKolicina(15);
		pi2.setVrsta("Fridrih");
		pi2.setProcenat_alkohola(3.7);
		pi2.setPivara(p2);
		pivoService.save(pi2);
		
		
		TakmicenjaGodina tg1 = new TakmicenjaGodina();
		tg1.setNazivTrke("Polet1");
		takmicenjaGodinaService.save(tg1);
		
		TakmicenjaGodina tg2 = new TakmicenjaGodina();
		tg2.setNazivTrke("Polet2");
		takmicenjaGodinaService.save(tg2);
		
		
		Manifestacija m1 = new Manifestacija();
		m1.setNaziv("1100110011");
		m1.setTakmicenjaGodina(tg1);
		m1.setDatumOdrzavanja("2012-05-20T09:00:00.00"); //new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z")
		m1.setMestoOdrzavanja("mesto odrzavanja 1");
		manifestacijaService.save(m1);
		
		Manifestacija m2 = new Manifestacija();
		m2.setNaziv("12312312");
		m2.setTakmicenjaGodina(tg2);
		m2.setDatumOdrzavanja("2013-05-20T09:00:00.00");
		m2.setMestoOdrzavanja("mesto odrzavanja 2");
		manifestacijaService.save(m2);
	}
}
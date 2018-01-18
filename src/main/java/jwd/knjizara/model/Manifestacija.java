package jwd.knjizara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table
public class Manifestacija{
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private String datumOdrzavanja;
	@Column
	private String mestoOdrzavanja;	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TakmicenjaGodina takmicenjaGodina;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Pivara pivara;
	
//	@OneToMany(mappedBy="manifestacija",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	private List<Trka> trke = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getDatumOdrzavanja() {
		return datumOdrzavanja;
	}
	public void setDatumOdrzavanja(String datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}
	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}
	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}
	
	public TakmicenjaGodina getTakmicenjaGodina() {
		return takmicenjaGodina;
	}
	public void setTakmicenjaGodina(TakmicenjaGodina takmicenjaGodina) {
		this.takmicenjaGodina = takmicenjaGodina;
	}
	
	
//	public List<Trka> getTrke() {
//		return trke;
//	}
//	public void setTrke(List<Trka> trke) {
//		this.trke = trke;
//	}
//-----------	
	
//	public List<Trkac> getTrkaci() {
//		return trkaci;
//	}
//	public void setTrkaci(List<Trkac> trkaci) {
//		this.trkaci = trkaci;
//	}
//	public void addTrkac(Trkac trkac){
//		this.trkaci.add(trkac);		
//		if(!this.equals(trkac.getManifestacija())){
//			trkac.setManifestacija(this);
//		}
//	}
	
}

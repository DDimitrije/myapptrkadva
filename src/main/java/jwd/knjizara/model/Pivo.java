package jwd.knjizara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Pivo {	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private String vrsta;
	@Column
	private Double IBU;
	@Column
	private Integer kolicina;
	@Column
	private Double procenat_alkohola;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Pivara pivara;
	
	@OneToMany(mappedBy="pivo",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<KupovinaPivo> kupovine = new ArrayList<>();
	
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
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public Double  getIBU() {
		return IBU;
	}
	public void setIBU(Double IBU) {
		this.IBU = IBU;
	}	
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public Double getProcenat_alkohola() {
		return procenat_alkohola;
	}
	public void setProcenat_alkohola(Double procenat_alkohola) {
		this.procenat_alkohola = procenat_alkohola;
	}
	public Pivara getPivara() {
		return pivara;
	}
	public void setPivara(Pivara pivara) {
		this.pivara = pivara;
		if(pivara!=null && !pivara.getPiva().contains(this)){
			pivara.getPiva().add(this);
		}
	}
	public List<KupovinaPivo> getKupovine() {
		return kupovine;
	}
	public void setKupovine(List<KupovinaPivo> kupovine) {
		this.kupovine = kupovine;
	}
	public void addKupovina(KupovinaPivo kupovina){
		this.kupovine.add(kupovina);
		
		if(!this.equals(kupovina.getPivo())){
			kupovina.setPivo(this);
		}
	}
	
//	public VrstaPiva getVrstaPiva() {
//		return vrstaPiva;
//	}
//
//	public void setVrstaPiva(VrstaPiva vrstaPiva) {
//		this.vrstaPiva = vrstaPiva;
//	}
}


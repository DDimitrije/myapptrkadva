package jwd.knjizara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pivara {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private String PIB;
	@Column
	private String Drzava;	
	@OneToMany(mappedBy="pivara",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Pivo> piva = new ArrayList<>();
	
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
	public String getPIB() {
		return PIB;
	}
	public void setPIB(String PIB) {
		this.PIB = PIB;
	}
	public String getDrzava() {
		return Drzava;
	}
	public void setDrzava(String Drzava) {
		this.Drzava = Drzava;
	}
	public List<Pivo> getPiva() {
		return piva;
	}
	public void setPiva(List<Pivo> piva) {
		this.piva = piva;
	}
	public void addPivo(Pivo pivo){
		this.piva.add(pivo);
		
		if(!this.equals(pivo.getPivara())){
			pivo.setPivara(this);
		}
	}
}

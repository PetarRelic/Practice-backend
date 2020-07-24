package it.eng.petarrelic.vezba.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studenti")
public class Student extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "ime", nullable = false, length = 50)
	private String ime;
	
	@Column(name = "prezime", nullable = false, length = 68)
	private String prezime;
	
	@Column(name = "datumRodjenja", nullable = false)
	private Date datumRodjenja;
	
	@ManyToOne
	@JoinColumn(name = "gradID")
	private Grad grad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public Grad getGrad() {
		return grad;
	}
	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", ime=");
		builder.append(ime);
		builder.append(", prezime=");
		builder.append(prezime);
		builder.append(", datumRodjenja=");
		builder.append(datumRodjenja);
		builder.append(", grad=");
		builder.append(grad);
		builder.append("]");
		return builder.toString();
	}
}

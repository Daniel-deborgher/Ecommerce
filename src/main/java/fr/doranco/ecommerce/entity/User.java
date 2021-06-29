package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.persistence.NamedQueries;

@Entity
@Table(name = "utilisateur", catalog = "hibernate_db_anot")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "Select u From User u"),
	@NamedQuery(name = "User.findByEmail", query = "Select u From User u Where email =: email")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotEmpty
	@Column(name = "email", length = 45, nullable = false, unique = true)
	private String email;

	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adresse> adresses;
	
	public User() {
		this.adresses = new HashSet<Adresse>();
	}

	public User(String nom, String prenom, Date dateNaissance,String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.adresses = new HashSet<Adresse>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNaissance="
				+ dateNaissance + ", adresses=" + adresses + "]";
	}

	
}

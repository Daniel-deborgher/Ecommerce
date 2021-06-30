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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
	
	/**
	 * 
	 */
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
	
	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@NotNull
	@Column(name = "isActif", nullable = false)
	private Boolean isActif;
	
	@NotEmpty
	@Column(name = "profil", length = 25, nullable = false)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", length = 45, nullable = false, unique = true)
	private String email;
	
	@NotEmpty
	@Column(name = "password", length = 45, nullable = false, unique = true)
	private String password;
	
	@NotEmpty
	@Column(name = "telephone", length = 15, nullable = false, unique = true)
	private String telephone;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adresse> adresses;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CartePaiement> cartePaiement;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commande> commandes;
	
	public Utilisateur() {
		this.adresses = new HashSet<Adresse>();
		this.cartePaiement = new HashSet<CartePaiement>();
		this.commentaires = new HashSet<Commentaire>();
		this.commandes = new HashSet<Commande>();
	}
	
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, Boolean isActif, String profil, String email,
			String password, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.adresses = new HashSet<Adresse>();
		this.cartePaiement = new HashSet<CartePaiement>();
		this.commentaires = new HashSet<Commentaire>();
		this.commandes = new HashSet<Commande>();
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + ", adresses=" + adresses + "]";
	}

}

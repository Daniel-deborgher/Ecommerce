package fr.doranco.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CartePaiement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom_proprietaire", length = 25, nullable = false)
	private String nomProprietaire;
	
	@NotEmpty
	@Column(name = "prenom_proprietaire", length = 25, nullable = false)
	private String prenomProprietaire;
	
	@NotNull
	@Column(name = "numero", length = 30, nullable = false)
	private Integer numero;
	
	@NotNull
	@Column(name = "date_fin_validite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinValidite;
	
	@NotEmpty
	@Column(name = "cryptogramme", length = 5, nullable = false)
	private Integer cryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	public CartePaiement() {
		
	}
	
	public CartePaiement(String nomProprietaire, String prenomProprietaire, Integer numero, Date dateFinValidite,
			Integer cryptogramme, Utilisateur utilisateur) {
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
		this.utilisateur = utilisateur;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public Integer getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(Integer cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + numero + ", dateFinValidite=" + dateFinValidite + ", cryptogramme="
				+ cryptogramme + ", utilisateur=" + utilisateur + "]";
	}
	
	
}

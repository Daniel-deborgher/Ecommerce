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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "commande", catalog = "hibernate_db_anot")
public class Commande implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id	// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "numero", length = 4, nullable = false)
	private String numero;
	
	
	@NotNull
	@Column(name = "date_creation", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	@NotNull
	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;
	
	@NotNull
	@Column(name = "total-remise", nullable = false)
	private Integer totalRemise; 
	
	@NotNull
	@Column(name = "fraise-expedition", nullable = false)
	private Integer fraiseExpedition; 
	
	@NotNull
	@Column(name = "total-general", nullable = false)
	private Integer totalGeneral; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_livraison_id", nullable = false)
	private Adresse adresseLivraison; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_facturation_id", nullable = false)
	private Adresse adresseFacturation; 
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "carte_paiement_id", nullable = false)
//	private CartePaiement cartePaiement; 
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LigneDeCommande> ligneDeCommande;

	
	
	
	public Commande(LigneDeCommande ligneDeCommande) {
		this.ligneDeCommande = new HashSet<LigneDeCommande>();
	}

	public Commande(String numero, Date dateCreation, Date dateLivraison, Integer totalRemise, Integer fraiseExpedition,
			Integer totalGeneral) {
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraiseExpedition = fraiseExpedition;
		this.totalGeneral = totalGeneral;
		this.ligneDeCommande = new HashSet<LigneDeCommande>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Integer getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(Integer totalRemise) {
		this.totalRemise = totalRemise;
	}

	public Integer getFraiseExpedition() {
		return fraiseExpedition;
	}

	public void setFraiseExpedition(Integer fraiseExpedition) {
		this.fraiseExpedition = fraiseExpedition;
	}

	public Integer getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(Integer totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<LigneDeCommande> getLigneDeCommande() {
		return ligneDeCommande;
	}
	
	

}


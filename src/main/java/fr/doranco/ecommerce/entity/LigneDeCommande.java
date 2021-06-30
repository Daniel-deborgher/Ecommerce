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
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
public class LigneDeCommande implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "quantite", nullable = false)
	private Integer quantite;
	
	@NotEmpty
	@Column(name = "prix_unitaire", nullable = false)
	private Integer prixUnitaire;
	
	@NotEmpty
	@Column(name = "remise_article", nullable = false)
	private Integer remiseArticle;
	
	
	
	@ManyToOne
	@JoinColumn(name = "commande", nullable = false)
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	public LigneDeCommande() {
		
	}

	public LigneDeCommande(Integer id, Integer quantite, Integer prixUnitaire, Integer remiseArticle,
			fr.doranco.ecommerce.entity.Commande commande, fr.doranco.ecommerce.entity.Article article) {
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Integer getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Integer remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	


}


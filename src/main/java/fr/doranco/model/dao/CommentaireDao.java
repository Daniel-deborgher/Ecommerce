//package fr.doranco.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import fr.doranco.ecommerce.entity.Commentaire;
//
//import fr.doranco.ecommerce.model.EcommerceDataSource;
//
//
//public class CommentaireDao implements ICommentaireDao {
//
//	@Override
//	public Commentaire get(Class<Commentaire> entity, Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Commentaire> getAll(Class<Commentaire> entity) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Commentaire addCommentaire(Commentaire commentaire) throws Exception {
//		if (commentaire == null 
//				|| commentaire.getTexte() == null
//				|| commentaire.getTexte().isEmpty() 
//				|| commentaire.getNote() == null 
//				) {
//
//			throw new IllegalArgumentException("Les paramètres ne doivent pas être nuls ou vides !");
//		}
//
//		Connection connexion = null;
//		try {
//			connexion = EcommerceDataSource.getConnexion();
//			String requete = "INSERT INTO commentaire(texte, note )"
//					+ "VALUES(?, ?)";
//			PreparedStatement ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
//			
//			ps.setString(1, commentaire.getTexte());
//			ps.setInt(2, commentaire.getNote());
//			
//
//			ps.executeUpdate();
//			ResultSet rs = ps.getGeneratedKeys();
//			if (rs.next()) {
//				commentaire.setId(rs.getInt(1));
//			}
//
//		} finally {
//			if (connexion != null) {
//				connexion.close();
//			}
//		}
//		return commentaire;
//	}
//
//	@Override
//	public Commentaire getCommentaireById(Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateCommentaire(Commentaire commentaire) throws Exception {
//		if (commentaire == null 
//				|| commentaire.getTexte() == null
//				|| commentaire.getTexte().isEmpty() 
//				|| commentaire.getNote() == null 
//				) {
//
//			throw new IllegalArgumentException("Les paramètres ne doivent pas être nuls ou vides !");
//		}
//
//		Connection connexion = null;
//		try {
//			connexion = EcommerceDataSource.getConnexion();
//			String requete = "UPDATE commentaire SET texte = ?, note = ?";
//			PreparedStatement ps = connexion.prepareStatement(requete);
//			
//			ps.setString(1, commentaire.getTexte());
//			ps.setInt(2, commentaire.getNote());
//
//			int nbLines = ps.executeUpdate();
//			
//			if (nbLines != 1) {
//				throw new SQLException("Erreur lors de la mise à jour de l'utilisateur (id = " + commentaire.getId() + ")");
//			}
//
//		} finally {
//			if (connexion != null) {
//				connexion.close();
//			}
//		}
//		
//	}
//
//	@Override
//	public void removeCommentaire(Integer id) throws Exception {
//		if (id == null || id <= 0) {
//			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
//		}
//
//		Connection connexion = null;
//		try {
//			connexion = EcommerceDataSource.getConnexion();
//			String requete = "DELETE FROM commentaire WHERE id = ? ";
//			PreparedStatement ps = connexion.prepareStatement(requete);
//			ps.setInt(1, id);
//
//			int nbLines = ps.executeUpdate();
//			
//			if (nbLines != 1) {
//				throw new SQLException("Erreur lors de la suppression de l'utilisateur (id = " + id + ")");
//			}
//
//		} finally {
//			if (connexion != null) {
//				connexion.close();
//			}
//		}
//		
//	}
//
//	@Override
//	public List<Commentaire> getCommentaires() throws Exception {
//		Connection connexion = null;
//		List<Commentaire> commentaires = new ArrayList<Commentaire>();
//		try {
//			connexion = EcommerceDataSource.getConnexion();
//			String requete = "SELECT * FROM commentaire";
//			PreparedStatement ps = connexion.prepareStatement(requete);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Commentaire commentaire = new Commentaire();
//				commentaire.setId(rs.getInt("id"));
//				commentaire.setTexte(rs.getString("texte"));
//				commentaire.setNote(rs.getInt("note"));
//				commentaires.add(commentaire);
//			}
//
//		} finally {
//			if (connexion != null) {
//				connexion.close();
//			}
//		}
//		return commentaires;
//	}
//	}
//

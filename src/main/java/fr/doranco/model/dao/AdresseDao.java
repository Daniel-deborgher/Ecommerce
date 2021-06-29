package fr.doranco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.model.EcommerceDataSource;

public class AdresseDao implements IAdresseDao {

	public AdresseDao() {
	}

	@Override
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur) throws Exception {

		if (adresse == null
				|| adresse.getNumero() == null || adresse.getNumero() <= 0
				|| adresse.getRue() == null || adresse.getRue().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().isEmpty()
				|| adresse.getCodePostal() == null || adresse.getCodePostal().isEmpty()
				|| idUtilisateur == null || idUtilisateur <= 0) {

			throw new IllegalArgumentException("Les paramètres ne doivent pas être nuls ou vides !");
		}

		Connection connexion = null;
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "INSERT INTO adresse(numero, rue, ville, code_postal, user_id) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setString(4, adresse.getCodePostal());
			ps.setInt(5, idUtilisateur);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				adresse.setId(rs.getInt(1));
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
		return adresse;
	}

	@Override
	public Adresse getAdresse(Integer id) throws Exception {
		
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre id doit être non nul et positif !");
		}

		Connection connexion = null;
		Adresse adresse = null;
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "SELECT * FROM adresse WHERE id = ?";
			PreparedStatement ps = connexion.prepareStatement(requete);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				adresse = new Adresse();
				adresse.setId(id);
				adresse.setNumero(rs.getInt("numero"));
				adresse.setRue(rs.getString("rue"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostal(rs.getString("code_postal"));
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
		return adresse;

	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		
		if (adresse == null
				|| adresse.getId() == null || adresse.getId() <= 0
				|| adresse.getNumero() == null || adresse.getNumero() <= 0
				|| adresse.getRue() == null || adresse.getRue().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().isEmpty()
				|| adresse.getCodePostal() == null || adresse.getCodePostal().isEmpty()) {

			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}

		Connection connexion = null;
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "UPDATE adresse SET numero = ?, rue = ?, ville = ?, code_postal = ? WHERE id = ?";
			PreparedStatement ps = connexion.prepareStatement(requete);
			ps.setInt(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setString(4, adresse.getCodePostal());
			ps.setInt(5, adresse.getId());

			int nbLines = ps.executeUpdate();
			if (nbLines != 1) {
				throw new SQLException("Erreur lors de la mise à jour de l'adresse (id = " + adresse.getId() + ")");
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}

	}

	@Override
	public void removeAdresse(Integer id) throws Exception {
		
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre id doit être non nul et positif !");
		}

		Connection connexion = null;
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "DELETE FROM adresse WHERE id = ?";
			PreparedStatement ps = connexion.prepareStatement(requete);
			ps.setInt(1, id);

			int nbLines = ps.executeUpdate();
			if (nbLines != 1) {
				throw new SQLException("Erreur lors de la suppression de l'adresse (id = " + id + ")");
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
	}

	@Override
	public Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception {
		
		if (idUtilisateur == null || idUtilisateur <= 0) {
			throw new IllegalArgumentException("Le paramètre id doit être non nul et positif !");
		}

		Set<Adresse> adresses = new HashSet<Adresse>();
		Connection connexion = null;
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "SELECT * FROM adresse WHERE user_id = ?";
			PreparedStatement ps = connexion.prepareStatement(requete);
			ps.setInt(1, idUtilisateur);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(rs.getInt("id"));
				adresse.setNumero(rs.getInt("numero"));
				adresse.setRue(rs.getString("rue"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostal(rs.getString("code_postal"));
				adresses.add(adresse);
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
		return adresses;
	}

	@Override
	public Set<String> getNomsVillesUtilisateurs() throws Exception {

		Connection connexion = null;
		Set<String> villes = new HashSet<String>();
		try {
			connexion = EcommerceDataSource.getConnexion();
			String requete = "SELECT DISTINCT a.ville as ville FROM utilisateur e, adresse a WHERE e.id = a.user_id";
			PreparedStatement ps = connexion.prepareStatement(requete);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				villes.add(rs.getString("ville"));
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
		return villes;
	}

}

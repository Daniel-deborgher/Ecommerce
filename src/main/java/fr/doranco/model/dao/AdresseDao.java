package fr.doranco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.model.EcommerceDataSource;

public class AdresseDao implements IAdresseDao {

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


	
	

}

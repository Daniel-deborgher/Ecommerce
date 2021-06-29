package fr.doranco.ecommerce.model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class EcommerceDataSource {

	private EcommerceDataSource() {
	}
	
	public static Connection getConnexion() throws Exception {
		
		String user = "root";
		String password = "root";
		// On peut mettre 'localhost' � la place de '127.0.0.1'
		String url = "jdbc:mysql://127.0.0.1:3306/ecommerce_doranco_db";
		// on met cecode au cas o� il m'affiche une erreur de type le Driver n'a pas �t� retrouv�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connexion = DriverManager.getConnection(url, user, password);
		return connexion;
	}
}

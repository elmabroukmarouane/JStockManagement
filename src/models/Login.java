package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login {
	public void connexionDB(String email, String password) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = connexion.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count++;
			}
			if(count > 0) {
				new views.Home().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,
						"Wrong email or password !!!", "Login",
						JOptionPane.ERROR_MESSAGE);
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class UserDbManagement {
	public Vector<User> listUsers(){
		
		Vector<User> Liste_Users_All = new Vector<User>();
		Connexion.ouvrir_Connexion(
				"jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps = null;
		try {
			ps = connexion
					.prepareStatement("SELECT * FROM users ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Liste_Users_All.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Liste_Users_All;
		
	}
	
	public void addUser(String name, String email, String password) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("INSERT INTO users VALUES (null, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			int nb_data = ps.executeUpdate();
			if(nb_data > 0){
				JOptionPane.showMessageDialog(null, "Record added successfully !", "Add Informations !", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Operation not completed, make sure of your inputs !", "Add Informations !", JOptionPane.ERROR_MESSAGE);
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(int id, String name, String email, String password) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setInt(4, id);		
			int nb_data = ps.executeUpdate();
			if(nb_data > 0){
				JOptionPane.showMessageDialog(null, "Record updated successfully !", "Update Informations !", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Operation not completed, make sure of your inputs !", "Update Informations !", JOptionPane.ERROR_MESSAGE);
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("DELETE FROM users WHERE id = ?");
			ps.setInt(1, id);
			int nb_data = ps.executeUpdate();
			if(nb_data > 0){
				JOptionPane.showMessageDialog(null, "Record deleted successfully !", "Delete Informations !", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Operation not completed, make sure of your inputs !", "Delete Informations !", JOptionPane.ERROR_MESSAGE);
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<User> searchUser(String name) {
		Vector<User> searchUsersList = new Vector<User>();
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("SELECT * FROM users WHERE name like ? ORDER BY id DESC");
			ps.setString(1, '%' + name + '%');
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				searchUsersList.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchUsersList;
	}
}

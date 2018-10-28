package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CategorieDbManegement {
	public Vector<Categorie> listCategories(){
		
		Vector<Categorie> Liste_Categories_All = new Vector<Categorie>();
		Connexion.ouvrir_Connexion(
				"jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps = null;
		try {
			ps = connexion
					.prepareStatement("SELECT * FROM Categories ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Liste_Categories_All.add(new Categorie(rs.getInt("id"), rs.getString("name")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Liste_Categories_All;
		
	}
	
	public void addCategorie(String name) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("INSERT INTO categories VALUES (null, ?)");
			ps.setString(1, name);
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

	public void updateCategorie(int id, String name) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
			ps.setString(1, name);
			ps.setInt(2, id);		
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

	public void deleteCategorie(int id) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("DELETE FROM categories WHERE id = ?");
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
	
	public Vector<Categorie> searchCategorie(String name) {
		Vector<Categorie> searchCategoriesList = new Vector<Categorie>();
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("SELECT * FROM categories WHERE name like ? ORDER BY id DESC");
			ps.setString(1, '%' + name + '%');
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				searchCategoriesList.add(new Categorie(rs.getInt("id"), rs.getString("name")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchCategoriesList;
	}
}

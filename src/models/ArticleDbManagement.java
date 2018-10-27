package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ArticleDbManagement {
	public Vector<Article> listArticles(){
		
		Vector<Article> Liste_Articles_All = new Vector<Article>();
		Connexion.ouvrir_Connexion(
				"jdbc:mysql://localhost:3306/wsn_data_class", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps = null;
		try {
			ps = connexion
					.prepareStatement("SELECT * FROM articles");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getInt("category_id"), rs.getString("name"), rs.getFloat("price"), rs.getInt("qte"));
				Liste_Articles_All.add(article);
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Liste_Articles_All;
		
	}
	
	public void addArticle(int category_id, String name, float price, int qte) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/wsn_data_class", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("INSERT INTO articles VALUES (null, ?, ?, ?, ?)");
			ps.setInt(1, category_id);
			ps.setString(2, name);
			ps.setFloat(3, price);
			ps.setInt(4, qte);
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

	public void updateArticle(int id, int category_id, String name, float price, int qte) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("UPDATE articles SET category_id = ?, name = ?, price = ?, qte = ? WHERE id = ?");
			ps.setInt(1, category_id);
			ps.setString(2, name);
			ps.setFloat(3, price);
			ps.setInt(4, qte);
			ps.setInt(5, id);
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

	public void deleteArticle(int id) {
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("DELETE FROM articles WHERE id = ?");
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
	
	public Vector<Article> searchArticle(String name) {
		Vector<Article> Liste_Article_Rech = new Vector<Article>();
		Connexion.ouvrir_Connexion("jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps=null;
		try {
			ps = connexion.prepareStatement("SELECT * FROM articles WHERE name like %'?'%");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Liste_Article_Rech.add(new Article(rs.getInt("id"), rs.getInt("category_id"), rs.getString("name"), rs.getFloat("price"), rs.getInt("qte")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Liste_Article_Rech;
	}
	
	public Vector<Categorie> Categorie_List() {
		Vector<Categorie> categoriesList = new Vector<Categorie>();
		Connexion.ouvrir_Connexion(
				"jdbc:mysql://localhost:3306/jstock_management", "root", "");
		Connection connexion = Connexion.getConn();
		PreparedStatement ps = null;
		try {
			ps = connexion
					.prepareStatement("SELECT * FROM categories");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				categoriesList.add(new Categorie(rs.getInt("id"), rs.getString("name")));
			}
			ps.close();
			Connexion.fermer_Connexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoriesList;
	}
}

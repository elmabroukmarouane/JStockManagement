package jtabpack;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import models.Article;

public class jTableArticleModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] nomcolonnes = new String[]{"ID", "Categorie ID", "Article Name", "Price", "Quantity"};
	private Vector<String[]> table_valeurs = new Vector<String[]>();
	
	public int getColumnCount() {
		return nomcolonnes.length;
	}

	public int getRowCount() {
		return table_valeurs.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return table_valeurs.get(rowIndex)[columnIndex];
	}
	
	public String getColumnName(int column) {
		return nomcolonnes[column];
	}
	
	public void setData(Vector<Article> articles){
		table_valeurs =new Vector<String[]>();
		for(Article article:articles){
			table_valeurs.add(new String[]{
				String.valueOf(article.getId()),
				String.valueOf(article.getCategory_id()),
				article.getName(),
				String.valueOf(article.getPrice()),
				String.valueOf(article.getQte())
			});
		}
		fireTableChanged(null);
	}
	
}

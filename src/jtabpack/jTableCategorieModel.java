package jtabpack;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import models.Categorie;

public class jTableCategorieModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] nomcolonnes = new String[]{"ID", "Category Name"};
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
	
	public void setData(Vector<Categorie> categories){
		table_valeurs =new Vector<String[]>();
		for(Categorie categorie:categories){
			table_valeurs.add(new String[]{
				String.valueOf(categorie.getId()),
				categorie.getName()
			});
		}
		fireTableChanged(null);
	}
	
}

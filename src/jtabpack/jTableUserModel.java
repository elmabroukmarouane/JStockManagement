package jtabpack;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import models.User;

public class jTableUserModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] nomcolonnes = new String[]{"ID", "Name", "Email", "Password"};
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
	
	public void setData(Vector<User> Users){
		table_valeurs =new Vector<String[]>();
		for(User User:Users){
			table_valeurs.add(new String[]{
				String.valueOf(User.getId()),
				User.getName(),
				User.getEmail(),
				User.getPassword()
			});
		}
		fireTableChanged(null);
	}
	
}

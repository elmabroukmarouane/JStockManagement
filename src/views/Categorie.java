/*
 * Categorie.java
 *
 * Created on __DATE__, __TIME__
 */

package views;

import jtabpack.jTableCategorieModel;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import models.CategorieDbManegement;

/**
 *
 * @author  __USER__
 */
public class Categorie extends javax.swing.JFrame {

	Vector<models.Categorie> categoriesList = new Vector<models.Categorie>();
	jTableCategorieModel jTableCategorieModelTable = new jTableCategorieModel();
	CategorieDbManegement categorieDbManegement = new CategorieDbManegement();
	Boolean update = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form Categorie */
	public Categorie() {
		initComponents();
		initFunctionality();
	}

	public void showData() {
		categoriesTable.setModel(jTableCategorieModelTable);
		categoriesList = categorieDbManegement.listCategories();
		jTableCategorieModelTable.setData(categoriesList);
		categoryIdTxt.setVisible(false);
	}

	public void showSearch() {
		String searchTxt = categoryNameSearchTxt.getText();
		Vector<models.Categorie> searchList = new Vector<models.Categorie>();
		searchList = categorieDbManegement.searchCategorie(searchTxt);
		jTableCategorieModelTable.setData(searchList);
	}

	public void refresh() {
		categoriesList = categorieDbManegement.listCategories();
		jTableCategorieModelTable.setData(categoriesList);
	}

	public void searchEvent() {
		categoryNameSearchTxt.getDocument().addDocumentListener(
				new DocumentListener() {

					@Override
					public void removeUpdate(DocumentEvent e) {
						if(!categoryNameSearchTxt.getText().equals("")) {
							showSearch();
						} else {
							refresh();
						}
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						showSearch();
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						showSearch();
					}
				});
	}

	public void clearTxtFunction() {
		categoryIdTxt.setText("");
		categoryNameTxt.setText("");
		update = false;
		saveBtn.setText("Save");
	}

	public void clearEvent() {
		clearBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int option = JOptionPane.showConfirmDialog(null,
						"Are you sure to clear text fields ?",
						"Clear Text Fields", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					clearTxtFunction();
				}
			}
		});
	}

	public void saveFunction() {
		if (!categoryNameTxt.getText().equals("")) {
			categorieDbManegement.addCategorie(categoryNameTxt.getText());
			refresh();
		} else {
			JOptionPane.showMessageDialog(null,
					"Please complete all fields !!!", "Add Information",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void editCategorie() {
		int ligneSelectionne = categoriesTable.getSelectedRow();
		categoryIdTxt.setText(String.valueOf(categoriesTable.getValueAt(
				ligneSelectionne, 0)));
		categoryNameTxt.setText(String.valueOf(categoriesTable.getValueAt(
				ligneSelectionne, 1)));
		update = true;
		saveBtn.setText("Update");
	}

	public void editCategorieEvent() {
		categoriesTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				editCategorie();
			}
		});
	}

	public void updateFunction() {
		if (!categoryNameTxt.getText().equals("")
				&& !categoryIdTxt.getText().equals("")) {
			categorieDbManegement.updateCategorie(Integer
					.parseInt(categoryIdTxt.getText()), categoryNameTxt
					.getText());
			refresh();
		} else {
			JOptionPane.showMessageDialog(null,
					"Please complete all fields !!!", "Update Information",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saveOrUpdateEvent() {
		saveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int option = JOptionPane.showConfirmDialog(null,
						"Are you sure to save this categorie ?",
						"CRUD Informations", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					if (update == false) {
						saveFunction();
					} else {
						updateFunction();
					}
					clearTxtFunction();
				}
			}
		});
	}

	public void deleteFunction() {
		if (!categoryNameTxt.getText().equals("")
				&& !categoryIdTxt.getText().equals("")) {
			categorieDbManegement.deleteCategorie(Integer
					.parseInt(categoryIdTxt.getText()));
			refresh();
		} else {
			JOptionPane.showMessageDialog(null,
					"Please select a row from the table to delete !!!",
					"Delete Information", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteEvent() {
		deleteBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int option = JOptionPane.showConfirmDialog(null,
						"Are you sure to delete this categorie ?",
						"Delete Informations", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					deleteFunction();
					clearTxtFunction();
				}
			}
		});
	}
	
	public void initFunctionality() {
		setLocationRelativeTo(null);
		showData();
		searchEvent();
		editCategorieEvent();
		saveOrUpdateEvent();
		deleteEvent();
		clearEvent();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		managementPanel = new javax.swing.JPanel();
		categoryNameLb = new javax.swing.JLabel();
		categoryNameTxt = new javax.swing.JTextField();
		saveBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();
		clearBtn = new javax.swing.JButton();
		categoryIdTxt = new javax.swing.JTextField();
		searchPanel = new javax.swing.JPanel();
		categoryNameSearchLb = new javax.swing.JLabel();
		categoryNameSearchTxt = new javax.swing.JTextField();
		listPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		categoriesTable = new javax.swing.JTable();

		setTitle("Categories Management");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36));
		jLabel1.setText("Categories Management");

		managementPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Management Zone "));

		categoryNameLb.setText("Category Name");

		saveBtn.setText("Save");

		deleteBtn.setText("Delete");

		clearBtn.setText("Clear");

		javax.swing.GroupLayout managementPanelLayout = new javax.swing.GroupLayout(
				managementPanel);
		managementPanel.setLayout(managementPanelLayout);
		managementPanelLayout
				.setHorizontalGroup(managementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								managementPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(categoryNameLb)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																categoryNameTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																396,
																Short.MAX_VALUE)
														.addComponent(
																categoryIdTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(saveBtn)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deleteBtn)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(clearBtn)
										.addContainerGap()));
		managementPanelLayout
				.setVerticalGroup(managementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								managementPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																categoryNameLb)
														.addComponent(saveBtn)
														.addComponent(deleteBtn)
														.addComponent(clearBtn)
														.addComponent(
																categoryNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(26, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								managementPanelLayout
										.createSequentialGroup()
										.addContainerGap(37, Short.MAX_VALUE)
										.addComponent(
												categoryIdTxt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												14,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		searchPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Search Zone "));

		categoryNameSearchLb.setText("Category Name");

		javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(
				searchPanel);
		searchPanel.setLayout(searchPanelLayout);
		searchPanelLayout
				.setHorizontalGroup(searchPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								searchPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(categoryNameSearchLb)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												categoryNameSearchTxt,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												385, Short.MAX_VALUE).addGap(
												225, 225, 225)));
		searchPanelLayout
				.setVerticalGroup(searchPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								searchPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												searchPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																categoryNameSearchLb)
														.addComponent(
																categoryNameSearchTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(28, Short.MAX_VALUE)));

		listPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Categories List "));

		categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(categoriesTable);

		javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(
				listPanel);
		listPanel.setLayout(listPanelLayout);
		listPanelLayout.setHorizontalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				listPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 686,
								Short.MAX_VALUE).addContainerGap()));
		listPanelLayout.setVerticalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				listPanelLayout.createSequentialGroup().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						144, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				listPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				managementPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				searchPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				173,
																				173,
																				173)
																		.addComponent(
																				jLabel1)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												managementPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(1, 1, 1)
										.addComponent(
												searchPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												listPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable categoriesTable;
	private javax.swing.JTextField categoryIdTxt;
	private javax.swing.JLabel categoryNameLb;
	private javax.swing.JLabel categoryNameSearchLb;
	private javax.swing.JTextField categoryNameSearchTxt;
	private javax.swing.JTextField categoryNameTxt;
	private javax.swing.JButton clearBtn;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel listPanel;
	private javax.swing.JPanel managementPanel;
	private javax.swing.JButton saveBtn;
	private javax.swing.JPanel searchPanel;
	// End of variables declaration//GEN-END:variables

}
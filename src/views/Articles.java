/*
 * Categorie.java
 *
 * Created on __DATE__, __TIME__
 */

package views;

import jtabpack.jTableArticleModel;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import models.ArticleDbManagement;
import models.CategorieDbManegement;

import models.Categorie;

/**
 *
 * @author  __USER__
 */
public class Articles extends javax.swing.JFrame {

	Vector<models.Article> ArticlesList = new Vector<models.Article>();
	jTableArticleModel jTableArticleModelTable = new jTableArticleModel();
	ArticleDbManagement ArticleDbManegement = new ArticleDbManagement();
	CategorieDbManegement categorieDbManegement = new CategorieDbManegement();
	Boolean update = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form Article */
	public Articles() {
		initComponents();
		initFunctionality();
	}

	public void showData() {
		ArticlesTable.setModel(jTableArticleModelTable);
		ArticlesList = ArticleDbManegement.listArticles();
		jTableArticleModelTable.setData(ArticlesList);
		articleIdTxt.setVisible(false);
	}

	public void fillCategoriesCbx() {
		categoryIdCbx.removeAllItems();
		Vector<models.Categorie> categoriesList = new Vector<models.Categorie>();
		categoriesList = categorieDbManegement.listCategories();
		for (Categorie categorie : categoriesList) {
			categoryIdCbx.addItem(String.valueOf(categorie.getId()));
		}
	}

	public void showSearch() {
		String searchTxt = articleNameSearchTxt.getText();
		Vector<models.Article> searchList = new Vector<models.Article>();
		searchList = ArticleDbManegement.searchArticle(searchTxt);
		jTableArticleModelTable.setData(searchList);
	}

	public void refresh() {
		ArticlesList = ArticleDbManegement.listArticles();
		jTableArticleModelTable.setData(ArticlesList);
	}

	public void searchEvent() {
		articleNameSearchTxt.getDocument().addDocumentListener(
				new DocumentListener() {

					@Override
					public void removeUpdate(DocumentEvent e) {
						if (!articleNameSearchTxt.getText().equals("")) {
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
		articleIdTxt.setText("");
		articleNameTxt.setText("");
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
		if (!articleNameTxt.getText().equals("")) {
			ArticleDbManegement.addArticle(Integer
					.parseInt((String) categoryIdCbx.getSelectedItem()
							.toString()), articleNameTxt.getText(), Float
					.parseFloat(priceTxt.getText()), Integer
					.parseInt(quantityTxt.getText()));
			refresh();
		} else {
			JOptionPane.showMessageDialog(null,
					"Please complete all fields !!!", "Add Information",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void editArticle() {
		int ligneSelectionne = ArticlesTable.getSelectedRow();
		articleIdTxt.setText(String.valueOf(ArticlesTable.getValueAt(
				ligneSelectionne, 0)));
		articleNameTxt.setText(String.valueOf(ArticlesTable.getValueAt(
				ligneSelectionne, 1)));
		update = true;
		saveBtn.setText("Update");
	}

	public void editArticleEvent() {
		ArticlesTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				editArticle();
			}
		});
	}

	public void updateFunction() {
		if (!articleNameTxt.getText().equals("")
				&& !articleIdTxt.getText().equals("")) {
			ArticleDbManegement.updateArticle(Integer.parseInt(articleIdTxt
					.getText()), Integer.parseInt((String) categoryIdCbx
					.getSelectedItem().toString()), articleNameTxt.getText(),
					Float.parseFloat(priceTxt.getText()), Integer
							.parseInt(quantityTxt.getText()));
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
						"Are you sure to save this Article ?",
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
		if (!articleNameTxt.getText().equals("")
				&& !articleIdTxt.getText().equals("")) {
			ArticleDbManegement.deleteArticle(Integer.parseInt(articleIdTxt
					.getText()));
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
						"Are you sure to delete this Article ?",
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
		fillCategoriesCbx();
		searchEvent();
		editArticleEvent();
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
		articleNameLb = new javax.swing.JLabel();
		articleNameTxt = new javax.swing.JTextField();
		saveBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();
		clearBtn = new javax.swing.JButton();
		articleIdTxt = new javax.swing.JTextField();
		priceLb = new javax.swing.JLabel();
		priceTxt = new javax.swing.JTextField();
		qteLb = new javax.swing.JLabel();
		quantityTxt = new javax.swing.JTextField();
		categoryIdCbx = new javax.swing.JComboBox();
		categoriIdLb = new javax.swing.JLabel();
		searchPanel = new javax.swing.JPanel();
		articleNameSearchLb = new javax.swing.JLabel();
		articleNameSearchTxt = new javax.swing.JTextField();
		listPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		ArticlesTable = new javax.swing.JTable();

		setTitle("Articles Management");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36));
		jLabel1.setText("Articles Management");

		managementPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Management Zone "));

		articleNameLb.setText("Article Name");

		saveBtn.setText("Save");

		deleteBtn.setText("Delete");

		clearBtn.setText("Clear");

		priceLb.setText("Price");

		qteLb.setText("Quantity");

		categoryIdCbx.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		categoriIdLb.setText("Category");

		javax.swing.GroupLayout managementPanelLayout = new javax.swing.GroupLayout(
				managementPanel);
		managementPanel.setLayout(managementPanelLayout);
		managementPanelLayout
				.setHorizontalGroup(managementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								managementPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																articleNameLb)
														.addComponent(
																categoriIdLb)
														.addComponent(priceLb)
														.addComponent(qteLb))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																categoryIdCbx,
																0, 374,
																Short.MAX_VALUE)
														.addComponent(
																articleNameTxt,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE)
														.addComponent(
																priceTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE)
														.addComponent(
																quantityTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																managementPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				saveBtn)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				deleteBtn)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				clearBtn))
														.addComponent(
																articleIdTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		managementPanelLayout
				.setVerticalGroup(managementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								managementPanelLayout
										.createSequentialGroup()
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																managementPanelLayout
																		.createSequentialGroup()
																		.addGap(
																				43,
																				43,
																				43)
																		.addGroup(
																				managementPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								saveBtn)
																						.addComponent(
																								deleteBtn)
																						.addComponent(
																								clearBtn))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				articleIdTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				14,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																managementPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				managementPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								categoriIdLb)
																						.addComponent(
																								categoryIdCbx,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				managementPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								articleNameLb)
																						.addComponent(
																								articleNameTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				managementPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								priceLb)
																						.addComponent(
																								priceTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				managementPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								qteLb)
																						.addComponent(
																								quantityTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(21, Short.MAX_VALUE)));

		searchPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Search Zone "));

		articleNameSearchLb.setText("Article Name");

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
										.addComponent(articleNameSearchLb)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												articleNameSearchTxt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												374,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(219, Short.MAX_VALUE)));
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
																articleNameSearchLb)
														.addComponent(
																articleNameSearchTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(28, Short.MAX_VALUE)));

		listPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Articles List "));

		ArticlesTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(ArticlesTable);

		javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(
				listPanel);
		listPanel.setLayout(listPanelLayout);
		listPanelLayout.setHorizontalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				listPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 655,
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
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								listPanel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								searchPanel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								managementPanel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				175,
																				175,
																				175)
																		.addComponent(
																				jLabel1)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
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
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

		listPanel.getAccessibleContext().setAccessibleName(" Articles List ");

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable ArticlesTable;
	private javax.swing.JTextField articleIdTxt;
	private javax.swing.JLabel articleNameLb;
	private javax.swing.JLabel articleNameSearchLb;
	private javax.swing.JTextField articleNameSearchTxt;
	private javax.swing.JTextField articleNameTxt;
	private javax.swing.JLabel categoriIdLb;
	private javax.swing.JComboBox categoryIdCbx;
	private javax.swing.JButton clearBtn;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel listPanel;
	private javax.swing.JPanel managementPanel;
	private javax.swing.JLabel priceLb;
	private javax.swing.JTextField priceTxt;
	private javax.swing.JLabel qteLb;
	private javax.swing.JTextField quantityTxt;
	private javax.swing.JButton saveBtn;
	private javax.swing.JPanel searchPanel;
	// End of variables declaration//GEN-END:variables

}
/*
 * Categorie.java
 *
 * Created on __DATE__, __TIME__
 */

package views;

import jtabpack.jTableUserModel;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.UserDbManagement;

/**
 *
 * @author  __USER__
 */
public class Users extends javax.swing.JFrame {

	Vector<models.User> UsersList = new Vector<models.User>();
	jTableUserModel jTableUserModelTable = new jTableUserModel();
	UserDbManagement UserDbManegement = new UserDbManagement();
	Boolean update = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form User */
	public Users() {
		initComponents();
		initFunctionality();
	}

	public void showData() {
		UsersTable.setModel(jTableUserModelTable);
		UsersList = UserDbManegement.listUsers();
		jTableUserModelTable.setData(UsersList);
		userIdTxt.setVisible(false);
	}

	public void showSearch() {
		String searchTxt = nameSearchTxt.getText();
		Vector<models.User> searchList = new Vector<models.User>();
		searchList = UserDbManegement.searchUser(searchTxt);
		jTableUserModelTable.setData(searchList);
	}

	public void refresh() {
		UsersList = UserDbManegement.listUsers();
		jTableUserModelTable.setData(UsersList);
	}

	public void searchEvent() {
		nameSearchTxt.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!nameSearchTxt.getText().equals("")) {
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
		userIdTxt.setText("");
		nameTxt.setText("");
		emailTxt.setText("");
		passwordTxt.setText("");
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
		if (!nameTxt.getText().equals("") && !emailTxt.getText().equals("")
				&& !passwordTxt.getText().equals("")) {
			UserDbManegement.addUser(nameTxt.getText(), emailTxt.getText(),
					passwordTxt.getText());
			refresh();
		} else {
			JOptionPane.showMessageDialog(null,
					"Please complete all fields !!!", "Add Information",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void editUser() {
		int ligneSelectionne = UsersTable.getSelectedRow();
		userIdTxt.setText(String.valueOf(UsersTable.getValueAt(
				ligneSelectionne, 0)));
		nameTxt.setText(String.valueOf(UsersTable.getValueAt(ligneSelectionne,
				1)));
		emailTxt.setText(String.valueOf(UsersTable.getValueAt(ligneSelectionne,
				2)));
		passwordTxt.setText(String.valueOf(UsersTable.getValueAt(
				ligneSelectionne, 3)));
		update = true;
		saveBtn.setText("Update");
	}

	public void editUserEvent() {
		UsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				editUser();
			}
		});
	}

	public void updateFunction() {
		if (!nameTxt.getText().equals("") && !emailTxt.getText().equals("")
				&& !passwordTxt.getText().equals("")
				&& !userIdTxt.getText().equals("")) {
			UserDbManegement.updateUser(Integer.parseInt(userIdTxt.getText()),
					nameTxt.getText(), emailTxt.getText(), passwordTxt
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
						"Are you sure to save this User ?",
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
		if (!nameTxt.getText().equals("") && !emailTxt.getText().equals("")
				&& !passwordTxt.getText().equals("")
				&& !userIdTxt.getText().equals("")) {
			UserDbManegement.deleteUser(Integer.parseInt(userIdTxt.getText()));
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
						"Are you sure to delete this User ?",
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
		editUserEvent();
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
		nameLb = new javax.swing.JLabel();
		nameTxt = new javax.swing.JTextField();
		saveBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();
		clearBtn = new javax.swing.JButton();
		userIdTxt = new javax.swing.JTextField();
		emailLb = new javax.swing.JLabel();
		emailTxt = new javax.swing.JTextField();
		passwordLb = new javax.swing.JLabel();
		passwordTxt = new javax.swing.JTextField();
		searchPanel = new javax.swing.JPanel();
		nameSearchLb = new javax.swing.JLabel();
		nameSearchTxt = new javax.swing.JTextField();
		listPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		UsersTable = new javax.swing.JTable();

		setTitle("Articles Management");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36));
		jLabel1.setText("Users Management");

		managementPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Management Zone "));

		nameLb.setText("Name");

		saveBtn.setText("Save");

		deleteBtn.setText("Delete");

		clearBtn.setText("Clear");

		emailLb.setText("Email");

		passwordLb.setText("Password");

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
										.addGap(31, 31, 31)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(nameLb)
														.addComponent(emailLb)
														.addComponent(
																passwordLb))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																nameTxt,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE)
														.addComponent(
																emailTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE)
														.addComponent(
																passwordTxt,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE))
										.addGap(18, 18, 18)
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
																userIdTxt,
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
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(nameLb)
														.addComponent(
																nameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(emailLb)
														.addComponent(
																emailTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(saveBtn)
														.addComponent(deleteBtn)
														.addComponent(clearBtn))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																passwordLb)
														.addComponent(
																passwordTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																userIdTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																14,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(10, Short.MAX_VALUE)));

		searchPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Search Zone "));

		nameSearchLb.setText("Name");

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
										.addComponent(nameSearchLb)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												nameSearchTxt,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												374,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(262, Short.MAX_VALUE)));
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
																nameSearchLb)
														.addComponent(
																nameSearchTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(28, Short.MAX_VALUE)));

		listPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Users List "));

		UsersTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(UsersTable);

		javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(
				listPanel);
		listPanel.setLayout(listPanelLayout);
		listPanelLayout.setHorizontalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				listPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 661,
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
																		.addGap(
																				191,
																				191,
																				191)
																		.addComponent(
																				jLabel1))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				searchPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				listPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				managementPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
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
												122,
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

		listPanel.getAccessibleContext().setAccessibleName("Users List ");

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable UsersTable;
	private javax.swing.JButton clearBtn;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JLabel emailLb;
	private javax.swing.JTextField emailTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel listPanel;
	private javax.swing.JPanel managementPanel;
	private javax.swing.JLabel nameLb;
	private javax.swing.JLabel nameSearchLb;
	private javax.swing.JTextField nameSearchTxt;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JLabel passwordLb;
	private javax.swing.JTextField passwordTxt;
	private javax.swing.JButton saveBtn;
	private javax.swing.JPanel searchPanel;
	private javax.swing.JTextField userIdTxt;
	// End of variables declaration//GEN-END:variables

}
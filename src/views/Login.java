/*
 * Login.java
 *
 * Created on __DATE__, __TIME__
 */

package views;

import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class Login extends javax.swing.JFrame {

	models.Login login = new models.Login();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1178133778571764191L;

	/** Creates new form Login */
	public Login() {
		initComponents();
		initFunctionality();
	}

	public void clearTxtFunction() {
		emailTxt.setText("");
		passwordTxt.setText("");
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

	public void LoginFunction() {
		String password = new String(passwordTxt.getPassword());
		if (!emailTxt.getText().equals("") && !password.equals("")) {
			login.connexionDB(emailTxt.getText(), password);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null,
					"Please fill your email and password !!!", "Login",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void LoginEvent() {
		loginBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				LoginFunction();
			}
		});
	}

	public void initFunctionality() {
		setLocationRelativeTo(null);
		LoginEvent();
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

		loginLabel = new javax.swing.JLabel();
		emailLabel = new javax.swing.JLabel();
		emailTxt = new javax.swing.JTextField();
		passwordLabel = new javax.swing.JLabel();
		loginBtn = new javax.swing.JButton();
		clearBtn = new javax.swing.JButton();
		passwordTxt = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Login");
		setResizable(false);

		loginLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 36));
		loginLabel.setText("LOGIN");

		emailLabel.setText("Email");

		passwordLabel.setText("Password");

		loginBtn.setText("Login");

		clearBtn.setText("Clear");

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
																				135,
																				135,
																				135)
																		.addComponent(
																				loginLabel))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				37,
																				37,
																				37)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								passwordLabel)
																						.addComponent(
																								emailLabel))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								passwordTxt)
																						.addComponent(
																								emailTxt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								266,
																								Short.MAX_VALUE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				132,
																				132,
																				132)
																		.addComponent(
																				loginBtn)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				clearBtn)))
										.addContainerGap(42, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(loginLabel)
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																emailLabel)
														.addComponent(
																emailTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																passwordLabel)
														.addComponent(
																passwordTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(loginBtn)
														.addComponent(clearBtn))
										.addContainerGap(24, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton clearBtn;
	private javax.swing.JLabel emailLabel;
	private javax.swing.JTextField emailTxt;
	private javax.swing.JButton loginBtn;
	private javax.swing.JLabel loginLabel;
	private javax.swing.JLabel passwordLabel;
	private javax.swing.JPasswordField passwordTxt;
	// End of variables declaration//GEN-END:variables

}
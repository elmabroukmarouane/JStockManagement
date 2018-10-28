package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HomeManagement {
	
	public void exitApp(JMenuItem item){
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,
						"Are you sure to close this application?",
						"Close Application", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
				
			}
		});
	}

	public void categoriesManagement(JMenuItem item){
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new views.Categorie().setVisible(true);
			}
		});
	}

	public void articlesManagement(JMenuItem item){
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new views.Articles().setVisible(true);
			}
		});
	}

	public void usersManagement(JMenuItem item){
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new views.Users().setVisible(true);
			}
		});
	}

	public void about(JMenuItem item){
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"This app is made by Marouane EL MABROUK !!!", "About !",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}

package com.adventuremc.windows;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.CardLayout;

public class XMLQuickView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567074608529505372L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			XMLQuickView dialog = new XMLQuickView("Test Run!");
			dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public XMLQuickView(Object showMe) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		textPane.setText(showMe.toString());
		contentPanel.add(textPane, "name_1399571777562478000");
	}

}

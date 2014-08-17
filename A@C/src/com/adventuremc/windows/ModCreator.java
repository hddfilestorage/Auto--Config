package com.adventuremc.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;

import javax.swing.JTextPane;

import com.adventuremc.elements.Mod;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

import com.adventuremc.elements.Mod.EBool;
import com.adventuremc.elements.Mod.EServerType;
import com.adventuremc.elements.Mod.EType;
import com.adventuremc.elements.Mod.EDownload;
import com.adventuremc.modReader.modReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ModCreator {

	private JFrame frmAddNewMod;
	private JTextField txtName;
	private JTextField txtDescription;
	private JTextField txtVersion;
	private JTextField txtWebsite;
	private JTextField txtDonation;
	private JTextField txtServerurl;
	private JTextField txtServerfile;
	private JTextField txtLinked;
	private JTextField txtMd;
	private JTextField txtUrl;
	private JTextField txtDepends;
	private JTextField txtGroup;
	private JTextField txtColour;
	private JTextField txtFile;
	private EType Type = null;
	private EServerType SType = null;
	private EDownload Download = null;
	private EBool client = EBool.YES;
	private EBool server = EBool.YES;
	private EBool optional = EBool.NO;
	private EBool serveroptional = EBool.NO;
	private EBool hidden = EBool.NO;
	private EBool library = EBool.NO;
	private EBool recommended = EBool.YES;
	private Boolean old = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModCreator window = new ModCreator();
					window.frmAddNewMod.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModCreator() {
		initialize();
	}

	public Mod createMod(){
		Mod work = new Mod();
		
		if(old)
			server = EBool.SEPERATE;
		
		work.name = txtName.getText();
		work.version = txtVersion.getText();
		work.url = txtUrl.getText();
		work.file = txtFile.getText();
		work.website = txtWebsite.getText();
		work.donation = txtDonation.getText();
		work.colour = txtColour.getText();
		work.md5 = txtMd.getText();
		work.type = Type;
		work.client = client;
		work.server = server;
		work.serverurl = txtServerurl.getText();
		work.serverfile = txtServerfile.getText();
		work.servertype = SType;
		work.optional = optional;
		work.serveroptional = serveroptional;
		work.download = Download;
		work.group = txtGroup.getText();
		work.hidden = hidden;
		work.library = library;
		work.linked = txtLinked.getText();
		work.depends = txtDepends.getText();
		work.recommended = recommended;
		work.description = txtDescription.getText();
		
		return work;
	}
	
	private EBool convertBool(boolean bool){
		if(bool)
			return EBool.YES;
		return EBool.NO;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmAddNewMod = new JFrame();
		frmAddNewMod.setTitle("Add new mod");
		frmAddNewMod.setBounds(100, 100, 450, 505);
		frmAddNewMod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewMod.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmAddNewMod.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Cancel");
		panel.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(createMod());
			}
		});
		panel.add(btnNewButton_1, BorderLayout.EAST);
		
		JLabel lblAutoconfigBy = new JLabel("Auto @Config by: AdventureMC development");
		lblAutoconfigBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutoconfigBy.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		panel.add(lblAutoconfigBy, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmAddNewMod.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Mod info", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblName = new JLabel("Name*");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel_1.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		panel_1.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		panel_1.add(lblDescription, gbc_lblDescription);
		
		txtDescription = new JTextField();
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescription.gridx = 1;
		gbc_txtDescription.gridy = 1;
		panel_1.add(txtDescription, gbc_txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblVersion = new JLabel("Version*");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.EAST;
		gbc_lblVersion.insets = new Insets(0, 0, 5, 5);
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 3;
		panel_1.add(lblVersion, gbc_lblVersion);
		
		txtVersion = new JTextField();
		GridBagConstraints gbc_txtVersion = new GridBagConstraints();
		gbc_txtVersion.insets = new Insets(0, 0, 5, 0);
		gbc_txtVersion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVersion.gridx = 1;
		gbc_txtVersion.gridy = 3;
		panel_1.add(txtVersion, gbc_txtVersion);
		txtVersion.setColumns(10);
		
		JLabel lblFileName = new JLabel("File Name*");
		GridBagConstraints gbc_lblFileName = new GridBagConstraints();
		gbc_lblFileName.anchor = GridBagConstraints.EAST;
		gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileName.gridx = 0;
		gbc_lblFileName.gridy = 4;
		panel_1.add(lblFileName, gbc_lblFileName);
		
		txtFile = new JTextField();
		GridBagConstraints gbc_txtFile = new GridBagConstraints();
		gbc_txtFile.insets = new Insets(0, 0, 5, 0);
		gbc_txtFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFile.gridx = 1;
		gbc_txtFile.gridy = 4;
		panel_1.add(txtFile, gbc_txtFile);
		txtFile.setColumns(10);
		
		JLabel lblWebsite = new JLabel("Website*");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 0;
		gbc_lblWebsite.gridy = 6;
		panel_1.add(lblWebsite, gbc_lblWebsite);
		
		txtWebsite = new JTextField();
		GridBagConstraints gbc_txtWebsite = new GridBagConstraints();
		gbc_txtWebsite.insets = new Insets(0, 0, 5, 0);
		gbc_txtWebsite.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWebsite.gridx = 1;
		gbc_txtWebsite.gridy = 6;
		panel_1.add(txtWebsite, gbc_txtWebsite);
		txtWebsite.setColumns(10);
		
		JLabel lblDonation = new JLabel("Donation");
		GridBagConstraints gbc_lblDonation = new GridBagConstraints();
		gbc_lblDonation.anchor = GridBagConstraints.EAST;
		gbc_lblDonation.insets = new Insets(0, 0, 5, 5);
		gbc_lblDonation.gridx = 0;
		gbc_lblDonation.gridy = 7;
		panel_1.add(lblDonation, gbc_lblDonation);
		
		txtDonation = new JTextField();
		GridBagConstraints gbc_txtDonation = new GridBagConstraints();
		gbc_txtDonation.insets = new Insets(0, 0, 5, 0);
		gbc_txtDonation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDonation.gridx = 1;
		gbc_txtDonation.gridy = 7;
		panel_1.add(txtDonation, gbc_txtDonation);
		txtDonation.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Install options", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblType = new JLabel("Type*");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 0;
		panel_2.add(lblType, gbc_lblType);
		
		final JComboBox comboBoxType = new JComboBox();
		comboBoxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Type = (EType) comboBoxType.getSelectedItem();
			}
		});
		comboBoxType.setModel(new DefaultComboBoxModel(EType.values()));
		comboBoxType.setSelectedIndex(2);
		GridBagConstraints gbc_comboBoxType = new GridBagConstraints();
		gbc_comboBoxType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxType.gridx = 1;
		gbc_comboBoxType.gridy = 0;
		panel_2.add(comboBoxType, gbc_comboBoxType);
		
		JLabel lblDownload = new JLabel("Download");
		GridBagConstraints gbc_lblDownload = new GridBagConstraints();
		gbc_lblDownload.anchor = GridBagConstraints.EAST;
		gbc_lblDownload.insets = new Insets(0, 0, 5, 5);
		gbc_lblDownload.gridx = 0;
		gbc_lblDownload.gridy = 1;
		panel_2.add(lblDownload, gbc_lblDownload);
		
		final JComboBox comboBoxDownload = new JComboBox();
		comboBoxDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Download = (EDownload) comboBoxDownload.getSelectedItem();
			}
		});
		comboBoxDownload.setModel(new DefaultComboBoxModel(EDownload.values()));
		comboBoxDownload.setSelectedIndex(1);
		GridBagConstraints gbc_comboBoxDownload = new GridBagConstraints();
		gbc_comboBoxDownload.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxDownload.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDownload.gridx = 1;
		gbc_comboBoxDownload.gridy = 1;
		panel_2.add(comboBoxDownload, gbc_comboBoxDownload);
		
		JLabel lblMd = new JLabel("MD5");
		GridBagConstraints gbc_lblMd = new GridBagConstraints();
		gbc_lblMd.anchor = GridBagConstraints.EAST;
		gbc_lblMd.insets = new Insets(0, 0, 5, 5);
		gbc_lblMd.gridx = 0;
		gbc_lblMd.gridy = 2;
		panel_2.add(lblMd, gbc_lblMd);
		
		txtMd = new JTextField();
		GridBagConstraints gbc_txtMd = new GridBagConstraints();
		gbc_txtMd.insets = new Insets(0, 0, 5, 0);
		gbc_txtMd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMd.gridx = 1;
		gbc_txtMd.gridy = 2;
		panel_2.add(txtMd, gbc_txtMd);
		txtMd.setColumns(10);
		
		JLabel lblUrl = new JLabel("Url*");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.EAST;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 3;
		panel_2.add(lblUrl, gbc_lblUrl);
		
		txtUrl = new JTextField();
		txtUrl.setText("packs/Adventure/files/mods/");
		GridBagConstraints gbc_txtUrl = new GridBagConstraints();
		gbc_txtUrl.insets = new Insets(0, 0, 5, 0);
		gbc_txtUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUrl.gridx = 1;
		gbc_txtUrl.gridy = 3;
		panel_2.add(txtUrl, gbc_txtUrl);
		txtUrl.setColumns(10);
		
		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 4;
		panel_2.add(lblClient, gbc_lblClient);
		
		final JCheckBox chckbxClient = new JCheckBox("");
		chckbxClient.setSelected(true);
		chckbxClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxClient.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxClient = new GridBagConstraints();
		gbc_chckbxClient.anchor = GridBagConstraints.WEST;
		gbc_chckbxClient.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClient.gridx = 1;
		gbc_chckbxClient.gridy = 4;
		panel_2.add(chckbxClient, gbc_chckbxClient);
		
		JLabel lblServer_1 = new JLabel("Server");
		GridBagConstraints gbc_lblServer_1 = new GridBagConstraints();
		gbc_lblServer_1.anchor = GridBagConstraints.EAST;
		gbc_lblServer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblServer_1.gridx = 0;
		gbc_lblServer_1.gridy = 5;
		panel_2.add(lblServer_1, gbc_lblServer_1);
		
		final JCheckBox chckbxServer_1 = new JCheckBox("");
		chckbxServer_1.setSelected(true);
		chckbxServer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = convertBool(chckbxServer_1.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxServer_1 = new GridBagConstraints();
		gbc_chckbxServer_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxServer_1.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxServer_1.gridx = 1;
		gbc_chckbxServer_1.gridy = 5;
		panel_2.add(chckbxServer_1, gbc_chckbxServer_1);
		
		JLabel lblLibrary = new JLabel("Library");
		GridBagConstraints gbc_lblLibrary = new GridBagConstraints();
		gbc_lblLibrary.anchor = GridBagConstraints.EAST;
		gbc_lblLibrary.insets = new Insets(0, 0, 5, 5);
		gbc_lblLibrary.gridx = 0;
		gbc_lblLibrary.gridy = 6;
		panel_2.add(lblLibrary, gbc_lblLibrary);
		
		final JCheckBox chckbxLibrary = new JCheckBox("");
		chckbxLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxLibrary.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxLibrary = new GridBagConstraints();
		gbc_chckbxLibrary.anchor = GridBagConstraints.WEST;
		gbc_chckbxLibrary.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxLibrary.gridx = 1;
		gbc_chckbxLibrary.gridy = 6;
		panel_2.add(chckbxLibrary, gbc_chckbxLibrary);
		
		JLabel lblLinked = new JLabel("Linked");
		GridBagConstraints gbc_lblLinked = new GridBagConstraints();
		gbc_lblLinked.anchor = GridBagConstraints.EAST;
		gbc_lblLinked.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinked.gridx = 0;
		gbc_lblLinked.gridy = 7;
		panel_2.add(lblLinked, gbc_lblLinked);
		
		txtLinked = new JTextField();
		GridBagConstraints gbc_txtLinked = new GridBagConstraints();
		gbc_txtLinked.insets = new Insets(0, 0, 5, 0);
		gbc_txtLinked.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLinked.gridx = 1;
		gbc_txtLinked.gridy = 7;
		panel_2.add(txtLinked, gbc_txtLinked);
		txtLinked.setColumns(10);
		
		JLabel lblDepends = new JLabel("Depends");
		GridBagConstraints gbc_lblDepends = new GridBagConstraints();
		gbc_lblDepends.anchor = GridBagConstraints.EAST;
		gbc_lblDepends.insets = new Insets(0, 0, 0, 5);
		gbc_lblDepends.gridx = 0;
		gbc_lblDepends.gridy = 8;
		panel_2.add(lblDepends, gbc_lblDepends);
		
		txtDepends = new JTextField();
		GridBagConstraints gbc_txtDepends = new GridBagConstraints();
		gbc_txtDepends.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDepends.gridx = 1;
		gbc_txtDepends.gridy = 8;
		panel_2.add(txtDepends, gbc_txtDepends);
		txtDepends.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Listing", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblOptional = new JLabel("Optional");
		GridBagConstraints gbc_lblOptional = new GridBagConstraints();
		gbc_lblOptional.anchor = GridBagConstraints.EAST;
		gbc_lblOptional.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptional.gridx = 0;
		gbc_lblOptional.gridy = 0;
		panel_3.add(lblOptional, gbc_lblOptional);
		
		final JCheckBox chckbxOptional = new JCheckBox("");
		chckbxOptional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxOptional.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxOptional = new GridBagConstraints();
		gbc_chckbxOptional.anchor = GridBagConstraints.WEST;
		gbc_chckbxOptional.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOptional.gridx = 1;
		gbc_chckbxOptional.gridy = 0;
		panel_3.add(chckbxOptional, gbc_chckbxOptional);
		
		JLabel lblServerOptional = new JLabel("Server Optional");
		GridBagConstraints gbc_lblServerOptional = new GridBagConstraints();
		gbc_lblServerOptional.insets = new Insets(0, 0, 5, 5);
		gbc_lblServerOptional.gridx = 0;
		gbc_lblServerOptional.gridy = 1;
		panel_3.add(lblServerOptional, gbc_lblServerOptional);
		
		final JCheckBox chckbxServeroptional = new JCheckBox("");
		chckbxServeroptional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxServeroptional.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxServeroptional = new GridBagConstraints();
		gbc_chckbxServeroptional.anchor = GridBagConstraints.WEST;
		gbc_chckbxServeroptional.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxServeroptional.gridx = 1;
		gbc_chckbxServeroptional.gridy = 1;
		panel_3.add(chckbxServeroptional, gbc_chckbxServeroptional);
		
		JLabel lblGroup = new JLabel("Group");
		GridBagConstraints gbc_lblGroup = new GridBagConstraints();
		gbc_lblGroup.anchor = GridBagConstraints.EAST;
		gbc_lblGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblGroup.gridx = 0;
		gbc_lblGroup.gridy = 2;
		panel_3.add(lblGroup, gbc_lblGroup);
		
		txtGroup = new JTextField();
		GridBagConstraints gbc_txtGroup = new GridBagConstraints();
		gbc_txtGroup.insets = new Insets(0, 0, 5, 0);
		gbc_txtGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGroup.gridx = 1;
		gbc_txtGroup.gridy = 2;
		panel_3.add(txtGroup, gbc_txtGroup);
		txtGroup.setColumns(10);
		
		JLabel lblHidden = new JLabel("Hidden");
		GridBagConstraints gbc_lblHidden = new GridBagConstraints();
		gbc_lblHidden.anchor = GridBagConstraints.EAST;
		gbc_lblHidden.insets = new Insets(0, 0, 5, 5);
		gbc_lblHidden.gridx = 0;
		gbc_lblHidden.gridy = 3;
		panel_3.add(lblHidden, gbc_lblHidden);
		
		final JCheckBox chckbxHidden = new JCheckBox("");
		chckbxHidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxHidden.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxHidden = new GridBagConstraints();
		gbc_chckbxHidden.anchor = GridBagConstraints.WEST;
		gbc_chckbxHidden.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHidden.gridx = 1;
		gbc_chckbxHidden.gridy = 3;
		panel_3.add(chckbxHidden, gbc_chckbxHidden);
		
		JLabel lblRecommended = new JLabel("Recommended");
		GridBagConstraints gbc_lblRecommended = new GridBagConstraints();
		gbc_lblRecommended.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecommended.gridx = 0;
		gbc_lblRecommended.gridy = 4;
		panel_3.add(lblRecommended, gbc_lblRecommended);
		
		final JCheckBox chckbxRecommended = new JCheckBox("");
		chckbxRecommended.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = convertBool(chckbxRecommended.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxRecommended = new GridBagConstraints();
		gbc_chckbxRecommended.anchor = GridBagConstraints.WEST;
		gbc_chckbxRecommended.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxRecommended.gridx = 1;
		gbc_chckbxRecommended.gridy = 4;
		panel_3.add(chckbxRecommended, gbc_chckbxRecommended);
		
		JLabel lblColour = new JLabel("Colour");
		GridBagConstraints gbc_lblColour = new GridBagConstraints();
		gbc_lblColour.anchor = GridBagConstraints.EAST;
		gbc_lblColour.insets = new Insets(0, 0, 0, 5);
		gbc_lblColour.gridx = 0;
		gbc_lblColour.gridy = 5;
		panel_3.add(lblColour, gbc_lblColour);
		
		txtColour = new JTextField();
		GridBagConstraints gbc_txtColour = new GridBagConstraints();
		gbc_txtColour.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtColour.gridx = 1;
		gbc_txtColour.gridy = 5;
		panel_3.add(txtColour, gbc_txtColour);
		txtColour.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("1.2.5 Options", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setForeground(new Color(0, 0, 0));
		txtpnInfo.setBackground(new Color(238,238,238));
		txtpnInfo.setEnabled(false);
		txtpnInfo.setText("This section contains options only for modpacks using minecraft version 1.2.5 or earlier. If your modpack is using a newer version of minecraft do not change these settings");
		panel_4.add(txtpnInfo, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblServer = new JLabel("1.2.5 Server");
		GridBagConstraints gbc_lblServer = new GridBagConstraints();
		gbc_lblServer.insets = new Insets(0, 0, 5, 5);
		gbc_lblServer.gridx = 0;
		gbc_lblServer.gridy = 0;
		panel_5.add(lblServer, gbc_lblServer);
		
		final JCheckBox chckbxServer = new JCheckBox("");
		chckbxServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				old = chckbxServer.isSelected();
			}
		});
		GridBagConstraints gbc_chckbxServer = new GridBagConstraints();
		gbc_chckbxServer.anchor = GridBagConstraints.WEST;
		gbc_chckbxServer.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxServer.gridx = 1;
		gbc_chckbxServer.gridy = 0;
		panel_5.add(chckbxServer, gbc_chckbxServer);
		
		JLabel lblServerurl = new JLabel("ServerUrl");
		GridBagConstraints gbc_lblServerurl = new GridBagConstraints();
		gbc_lblServerurl.anchor = GridBagConstraints.EAST;
		gbc_lblServerurl.insets = new Insets(0, 0, 5, 5);
		gbc_lblServerurl.gridx = 0;
		gbc_lblServerurl.gridy = 1;
		panel_5.add(lblServerurl, gbc_lblServerurl);
		
		txtServerurl = new JTextField();
		GridBagConstraints gbc_txtServerurl = new GridBagConstraints();
		gbc_txtServerurl.insets = new Insets(0, 0, 5, 0);
		gbc_txtServerurl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServerurl.gridx = 1;
		gbc_txtServerurl.gridy = 1;
		panel_5.add(txtServerurl, gbc_txtServerurl);
		txtServerurl.setColumns(10);
		
		JLabel lblServerfile = new JLabel("ServerFile");
		GridBagConstraints gbc_lblServerfile = new GridBagConstraints();
		gbc_lblServerfile.anchor = GridBagConstraints.EAST;
		gbc_lblServerfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblServerfile.gridx = 0;
		gbc_lblServerfile.gridy = 2;
		panel_5.add(lblServerfile, gbc_lblServerfile);
		
		txtServerfile = new JTextField();
		GridBagConstraints gbc_txtServerfile = new GridBagConstraints();
		gbc_txtServerfile.insets = new Insets(0, 0, 5, 0);
		gbc_txtServerfile.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServerfile.gridx = 1;
		gbc_txtServerfile.gridy = 2;
		panel_5.add(txtServerfile, gbc_txtServerfile);
		txtServerfile.setColumns(10);
		
		JLabel lblServertype = new JLabel("ServerType");
		GridBagConstraints gbc_lblServertype = new GridBagConstraints();
		gbc_lblServertype.anchor = GridBagConstraints.EAST;
		gbc_lblServertype.insets = new Insets(0, 0, 5, 5);
		gbc_lblServertype.gridx = 0;
		gbc_lblServertype.gridy = 3;
		panel_5.add(lblServertype, gbc_lblServertype);
		
		final JComboBox comboBoxServerType = new JComboBox();
		comboBoxServerType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SType = (EServerType) comboBoxServerType.getSelectedItem();
			}
		});
		comboBoxServerType.setModel(new DefaultComboBoxModel(EServerType.values()));
		comboBoxServerType.setSelectedIndex(9);
		GridBagConstraints gbc_comboBoxServerType = new GridBagConstraints();
		gbc_comboBoxServerType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxServerType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxServerType.gridx = 1;
		gbc_comboBoxServerType.gridy = 3;
		panel_5.add(comboBoxServerType, gbc_comboBoxServerType);
		
		JToolBar toolBar = new JToolBar();
		frmAddNewMod.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtDescription.setText("");
				txtVersion.setText("");
				txtFile.setText("");
				txtWebsite.setText("");
				txtDonation.setText("");
				comboBoxType.setSelectedIndex(2);
				comboBoxDownload.setSelectedIndex(1);
				txtMd.setText("");
				txtUrl.setText("packs/Adventure/files/mods/");
				chckbxClient.setSelected(true);
				chckbxServer.setSelected(false);
				chckbxLibrary.setSelected(false);
				txtLinked.setText("");
				txtDepends.setText("");
				chckbxOptional.setSelected(false);
				chckbxServeroptional.setSelected(false);
				txtGroup.setText("");
				chckbxHidden.setSelected(false);
				chckbxRecommended.setSelected(false);
				txtColour.setText("");
				chckbxServer_1.setSelected(true);
				txtServerurl.setText("");
				txtServerfile.setText("");
				comboBoxServerType.setSelectedIndex(9);
			}
		});
		toolBar.add(btnClear);
		
		final JButton btnSetTemplateFile = new JButton("Set template file");
		btnSetTemplateFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int ret = fc.showOpenDialog(btnSetTemplateFile);
				if(ret == JFileChooser.APPROVE_OPTION){
					InputStream fis = null;
					File file = fc.getSelectedFile();
					try {
						fis = new FileInputStream(file);
					} catch (FileNotFoundException e3) {
						// // TODONE
						e3.printStackTrace();
					}
					byte[] buffer = new byte[1024];
					MessageDigest md = null;
					try {
						md = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e2) {
						// // TODONE
						e2.printStackTrace();
					}
					int numRead = 0;

					do {
						try {
							numRead = fis.read(buffer);
						} catch (IOException e1) {
							// // TODONE
							e1.printStackTrace();
						}
						if (numRead > 0) {
							md.update(buffer, 0, numRead);
						}
					} while (numRead != -1);

					try {
						fis.close();
					} catch (IOException e1) {
						// // TODONE
						e1.printStackTrace();
					}
					byte[] b = md.digest();
					String result = "";

					for (int i=0; i < b.length; i++) {
						result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
					}
					
					txtMd.setText(result);
					txtFile.setText(file.getName());
					txtUrl.setText("packs/Adventure/files/mods/" + file.getName());
					modReader mr = new modReader(file);
					if(!mr.getModId().name.isEmpty())
						txtName.setText(mr.getModId().name);
					if(!mr.getModId().description.isEmpty())
						txtDescription.setText(mr.getModId().description);
					if(!mr.getModId().version.isEmpty())
						txtVersion.setText(mr.getModId().version);
					if(!mr.getModId().url.isEmpty())
						txtWebsite.setText(mr.getModId().url);
				}
			}
		});
		toolBar.add(btnSetTemplateFile);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnViewModXml = new JButton("VIew mod XML");
		btnViewModXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XMLQuickView xqv = new XMLQuickView(createMod());
				xqv.setVisible(true);
			}
		});
		toolBar.add(btnViewModXml);
	}

}

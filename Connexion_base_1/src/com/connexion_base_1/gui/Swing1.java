/**
 * 
 */
package com.connexion_base_1.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author 8510502w
 *
 */
public class Swing1 extends JFrame {
	
	JPanel panel_haut = new JPanel();
	JPanel panel_centre = new JPanel();
	JPanel panel_bas = new JPanel();
	JTextField saisienom;
	JButton chercherun, chercherall;
	JTable jtable;
	
	Object donnees [][]  = {{"ligne1-colonne1","ligne1-colonne2","ligne1-colonne3","ligne1-colonne4"},
			{"ligne2-colonne1","ligne2-colonne2","ligne2-colonne3","ligne2-colonne4"},
			{"ligne3-colonne1","ligne3-colonne2","ligne3-colonne3","ligne3-colonne4"},
			{"ligne4-colonne1","ligne4-colonne2","ligne4-colonne3","ligne4-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"}};
	String titrecolonnes []  = { "ID", "NOM", "PSEUDO", "MOT DE PASSE" };
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing1()
	{
		/**
		 * Paramétrage de la fenêtre elle-même
		 */
		super("Utilisateurs dans une base");
		setSize(800,350); // (largeur, hauteur)
		Container contenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		
		
		/**
		 * Création des composants pour le panel haut	 
		 */
				
		//this.add(this.haut,BorderLayout.NORTH);
		this.panel_haut.setBackground(Color.lightGray);		
		JLabel L1 = new JLabel("Chercher un utilisateur :");
		saisienom = new JTextField(20);
		chercherun = new JButton("chercher");
		chercherall = new JButton("Afficher tous les utilisateurs");
		//ajout des composants dans le panel haut		 
		this.panel_haut.add(L1);
		this.panel_haut.add(saisienom);
		this.panel_haut.add(this.chercherun);		
		this.panel_haut.add(chercherall);
		contenu.add(this.panel_haut);
		this.panel_haut.setLayout(new GridLayout(1, 1));
		
		//creationde des composants pour le panel centre	    
	    this.panel_centre.setBackground(Color.cyan);
	    //creation de la table de données
	    jtable = new JTable(donnees, titrecolonnes);		    
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setPreferredSize(new Dimension(600, 250));	  
	    //this.panel_centre.add(jtable);
	    this.panel_centre.add(scrollPane);
	    contenu.add(this.panel_centre);
	    
	    //pack();

		/**
		 * Ajout des composants dans la fenêtre
		 */
	    this.getContentPane().add(contenu);
	    //controlPanel.add(this.centre);
		//getContentPane().add(jtable);
		 
		 
		/**
		 * On affiche la fenêtre
		 */
		setVisible(true);
		
		
		/**
		 * Les écouteurs des composants "interactifs"
		 */
		 EcouteurBoutons trouverunuser = new EcouteurBoutons();
		 chercherun.addActionListener(trouverunuser);
		 chercherall.addActionListener(trouverunuser);
		 
		 
		 //EcouteurTexte ET = new EcouteurTexte();
		 //T1.addActionListener(ET);
		 
		 this.addWindowListener(new EcouteurFenetre());
		 
	}
}//fin de la classe

/**
 * L'écouteur pour les boutons
 */
class EcouteurBoutons implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton	B = (JButton)(e.getSource());
		
		if (B.getText().equals("chercher"))
			System.out.println("click button pour afficher un utilisateur");
		else if (B.getText().equals("Afficher tous les utilisateurs"))
			System.out.println("Click button pour afficher touts les utilisateurs");
		else
			System.out.println("rien à afficher!");
	}
}

/**
 * L'écouteur pour la fenêtre
 */
class EcouteurFenetre extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

/**
 * L'écouteur pour le champ text
 */
class EcouteurTexte implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JTextField	T = (JTextField)(e.getSource());
		
		System.out.println("Texte : "+T.getText());
	}
}

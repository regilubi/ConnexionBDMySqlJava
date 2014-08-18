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
	
	JPanel panel_haut;
	JPanel panel_centre;
	JPanel panel_bas;
	JTextField saisienom;
	JButton chercherun, chercherall, ajouter, supprimer, print;
	JTable jtable;
	JLabel statuslabel;
	
	Object donnees [][]  = {{"ligne1-colonne1","ligne1-colonne2","ligne1-colonne3","ligne1-colonne4"},
			{"ligne2-colonne1","ligne2-colonne2","ligne2-colonne3","ligne2-colonne4"},
			{"ligne3-colonne1","ligne3-colonne2","ligne3-colonne3","ligne3-colonne4"},
			{"ligne4-colonne1","ligne4-colonne2","ligne4-colonne3","ligne4-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"}};
	String titrecolonnes []  = { "ID", "NOM", "PSEUDO", "MOT DE PASSE" };
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing1()
	{
		/**
		 * Param�trage de la fen�tre elle-m�me
		 */
		super("Utilisateurs dans une base");
		setSize(1000,600); // (largeur, hauteur)
		//Container contenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		//Container contenu = new JPanel();
		
		
		
		/**
		 * Cr�ation des composants pour le panel haut	 
		 */
				
		this.panel_haut = new JPanel();		
		this.panel_haut.setBackground(Color.LIGHT_GRAY);		
		JLabel L1 = new JLabel("Chercher un utilisateur :");
		saisienom = new JTextField(20);
		chercherun = new JButton("chercher");
		chercherall = new JButton("Afficher tous les utilisateurs");
		GridLayout grille_haut = new GridLayout(1,4);
		grille_haut.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		grille_haut.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical) 
		this.panel_haut.setLayout(grille_haut); //(ligne, colonne)
		//ajout des composants dans le panel haut		 
		this.panel_haut.add(L1);
		this.panel_haut.add(saisienom);
		this.panel_haut.add(this.chercherun);		
		this.panel_haut.add(chercherall);		
		this.add(this.panel_haut, BorderLayout.NORTH);
		
		
		//creationde des composants pour le panel centre	
		this.panel_centre = new JPanel();		
	    this.panel_centre.setBackground(Color.LIGHT_GRAY);	    
	    //creation de la table de donn�es
	    jtable = new JTable(donnees, titrecolonnes);		    
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setPreferredSize(new Dimension(880, 300));	  
		
		
		ajouter = new JButton("Ajouter");
	    supprimer = new JButton("Supprimer");
	    print = new JButton("Print");
	    
	    //on cr�e un conteneur avec gestion horizontale
	    Box riennull = Box.createHorizontalBox();
	    riennull.add(new JLabel(" "));
	    //Idem
	    Box b1 = Box.createHorizontalBox();
	    b1.add(scrollPane);
	    //Idem
	    Box b2 = Box.createHorizontalBox();
	    b2.add(ajouter);
	    b2.add(new JLabel(" "));
	    b2.add(supprimer);
	    b2.add(new JLabel(" "));
	    b2.add(print);
	    
	    //On cr�e un contebeur avec gestion verticale
	    Box box = Box.createVerticalBox();
	    box.add(b1);
	    box.add(riennull);
	    box.add(b2);
	    this.panel_centre.add(box);	    
	    this.add(this.panel_centre, BorderLayout.CENTER);	    
	  
	    //creation composant pour panel bas	    	    
	    this.panel_bas = new JPanel();
	    this.statuslabel = new JLabel("status logiciel");
	    
	    this.panel_bas.add(this.statuslabel);
	    this.panel_bas.setBackground(Color.WHITE);
	    this.panel_bas.setLayout(new FlowLayout(FlowLayout.LEFT));
	    this.add(this.panel_bas, BorderLayout.SOUTH);		 
		 
		/**
		 * On affiche la fen�tre
		 */
		setVisible(true);
		
		
		/**
		 * Les �couteurs des composants "interactifs"
		 */
		 EcouteurBoutons actiondesbutoons = new EcouteurBoutons();
		 chercherun.addActionListener(actiondesbutoons);
		 chercherall.addActionListener(actiondesbutoons);
		 ajouter.addActionListener(actiondesbutoons);
		 supprimer.addActionListener(actiondesbutoons);
		 print.addActionListener(actiondesbutoons);
		 
		 
		 //EcouteurTexte ET = new EcouteurTexte();
		 //T1.addActionListener(ET);
		 
		 this.addWindowListener(new EcouteurFenetre());
		 
	}
}//fin de la classe

/**
 * L'�couteur pour les boutons
 */
class EcouteurBoutons implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton	B = (JButton)(e.getSource());
		
		if (B.getText().equals("chercher"))
			System.out.println("click button pour afficher un utilisateur.");
		else if (B.getText().equals("Afficher tous les utilisateurs"))
			System.out.println("Click button pour afficher touts les utilisateurs.");
		else if (B.getText().equals("Ajouter"))
			System.out.println("Click button pour ajouter un utilisateur.");
		else if (B.getText().equals("Supprimer"))
			System.out.println("Click button pour supprimer un utilisateur.");
		else if (B.getText().equals("Print"))
			System.out.println("Click button pour imprimer le tableau.");
		else
			System.out.println("rien � afficher!");
	}
}

/**
 * L'�couteur pour la fen�tre
 */
class EcouteurFenetre extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

/**
 * L'�couteur pour le champ text
 */
class EcouteurTexte implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JTextField	T = (JTextField)(e.getSource());
		
		System.out.println("Texte : "+T.getText());
	}
}

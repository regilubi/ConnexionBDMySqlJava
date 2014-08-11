/**
 * 
 */
package com.connexion_base_1.gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author 8510502w
 *
 */
public class Swing1 extends JFrame {
	
	JPanel haut = new JPanel();
	JPanel centre = new JPanel();
	JPanel bas = new JPanel();
	JTextField saisienom;
	JButton chercherun, chercherall;
	String [] titrecolonnes = {"ID", "NOM", "PSEUDO", "MOT DE PASSE"};
	Object [][] donnees= {{"moi","moi","moi","moi"},
			{"moi","moi","moi","moi"},
			{"moi","moi","moi","moi"},
			{"moi","moi","moi","moi"}};
	JTable jtable;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing1()
	{
		/**
		 * Paramétrage de la fenêtre elle-même
		 */
		super("La fenêtre principale");
		setSize(700,350);
		Container contenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		
		/**
		 * Création des composants pour le panel haut	 
		 */
				
		//this.add(this.haut,BorderLayout.NORTH);
		this.haut.setBackground(Color.lightGray);		
		JLabel L1 = new JLabel("Chercher un utilisateur :");
		saisienom = new JTextField(20);
		chercherun = new JButton("chercher");
		chercherall = new JButton("Afficher tous les utilisateurs");
		//ajout des composants dans le panel haut		 
		this.haut.add(L1);
		this.haut.add(saisienom);
		this.haut.add(this.chercherun);		
		this.haut.add(chercherall);
		contenu.add(this.haut);
		this.haut.setLayout(new GridLayout(1, 1));
		
		//creationde des composants pour le panel centre	    
	    this.centre.setBackground(Color.cyan);	    
	    this.jtable = new JTable(donnees, titrecolonnes);	
	    jtable.setPreferredSize(new Dimension(600, 250));
	    this.centre.add(jtable);
	    contenu.add(this.centre);
	    
	    

		/**
		 * Ajout des composants dans la fenêtre
		 */
	    this.getContentPane().add(contenu);
	    //controlPanel.add(this.centre);
		 //getContentPane().add(controlPanel);
		 
		 
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
		 
		 
		 EcouteurTexte ET = new EcouteurTexte();
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

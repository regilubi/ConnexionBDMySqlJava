/**
 * 
 */
package com.connexion_base_1.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.connexion_base_1.metier.DAOUtilisateur;
import com.connexion_base_1.metier.DAOUtilisateurJDBC;
import com.connexion_base_1.metier.Utilisateur;

/**
 * @author 8510502w
 *
 */
public class Swing1 extends JFrame {
	
	final JPanel panel_haut;
	final JPanel panel_centre;
	final JPanel panel_bas;
	final JTextField saisienom;
	final JButton chercherun, chercherall, ajouter, supprimer, print;
	final JTable jtable;
	final JLabel statuslabel;
	
	private JMenuBar menubar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenu apropos = new JMenu("A propos");	
	private JMenuItem aide = new JMenuItem("?");
	
	ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
	
	
	Object[][] donnees = new Object[25][25]; /*  = {{"1","ligne1-colonne1","ligne1-colonne2","ligne1-colonne3","ligne1-colonne4"}};*/
	String titrecolonnes []  = { "#", "ID", "NOM", "PSEUDO", "MOT DE PASSE" };
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing1()
	{
		/**
		 * Paramétrage de la fenêtre elle-même
		 */
		super("Gestion des utilisateurs");
		setSize(1000,600); // (largeur, hauteur)
		//Container contenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		//Container contenu = new JPanel();
		
	    remplirtableau();
	    
	    //arrangement du menu
	    this.fichier.add(quitter);
	    quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_MASK));
	    this.quitter.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});	   
	    
	    this.apropos.add(aide);
	    this.aide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane aver1 = new JOptionPane();
				aver1.showMessageDialog(null, "L'action sur ce button marche pas encore", "avertissement", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	    this.menubar.add(fichier);
	    this.menubar.add(apropos);
	    //ajout du menubar dans la fenetre
	    this.setJMenuBar(menubar);
		
		/**
		 * Création des composants pour le panel haut	 
		 */
				
		this.panel_haut = new JPanel();		
		this.panel_haut.setBackground(Color.LIGHT_GRAY);		
		JLabel L1 = new JLabel("Chercher un utilisateur :");
		saisienom = new JTextField(20);
		chercherun = new JButton("Chercher");
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
	    //creation de la table de données
	    jtable = new JTable(donnees, titrecolonnes);		    
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setPreferredSize(new Dimension(880, 300));	  
		
		
		ajouter = new JButton("Ajouter");
	    supprimer = new JButton("Supprimer");
	    print = new JButton("Print");
	    
	    //on crée un conteneur avec gestion horizontale
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
	    
	    //On crée un contebeur avec gestion verticale
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
		 * Les écouteurs des composants "interactifs"
		 */
		 //EcouteurBoutons actiondesbutoons = new EcouteurBoutons();
		 //chercherun.addActionListener(actiondesbutoons);
		 //chercherall.addActionListener(actiondesbutoons);
		 //ajouter.addActionListener(actiondesbutoons);
		 //supprimer.addActionListener(actiondesbutoons);
		 //print.addActionListener(actiondesbutoons);
		 this.supprimer.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				//supprimeruser(2);
				
				DialogDeleteUtilisateur dialogdelete = new DialogDeleteUtilisateur(null, "Supprimer un utilisateur", true);
				Utilisateur utilisateur = dialogdelete.showDialog();
				
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());					
			}
		 });
		 this.ajouter.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				
				//appel de la boite de dialog pour enregistrer un nouveau utilisateur
				DialogNouveauUtilisateur dialog = new DialogNouveauUtilisateur(null,"Nouveau utilisateur",true);
				Utilisateur utilisateur = dialog.showDialog();					
							
				
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());					
			}
		 });
		 this.chercherall.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				//TODO
				JOptionPane aver1 = new JOptionPane();
				aver1.showMessageDialog(null, "L'action sur ce button marche pas encore", "avertissement", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());					
			}
		});
		 this.chercherun.addActionListener(new ActionListener() {			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				if(saisienom.getText().equalsIgnoreCase("")){
					JOptionPane aver1 = new JOptionPane();
					aver1.showMessageDialog(null, "Veuillez renseigner un nom ou un pseudo pour la recherche", "avertissement", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					System.out.println("You have pressed button : " + B.getText() + " found the user : " + saisienom.getText()); 
					statuslabel.setText("You have pressed button : " + B.getText()+ " found the user : " + saisienom.getText());	
				}							
			}
		});
		 this.print.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				//TODO
				JOptionPane aver1 = new JOptionPane();
				aver1.showMessageDialog(null, "L'action sur ce button marche pas encore", "avertissement", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());
			}
		});	 
		 
		 
		 //EcouteurTexte ET = new EcouteurTexte();
		 //T1.addActionListener(ET);
		 
		 this.addWindowListener(new EcouteurFenetre());
		
		//On affiche la fenêtre	
		setVisible(true);		 
	}
	
	public void remplirtableau(){
		//remplisage du tableau
		/*
		list.add(new Utilisateur(0,"roro","rorolo","rororo"));
		list.add(new Utilisateur(2,"ririli","ririvan","riri"));
		list.add(new Utilisateur(3,"tatito","tatival","tati"));
		list.add(new Utilisateur(4,"tata","tatare","tatatot"));
		*/
		DAOUtilisateur daoutilisateur = new DAOUtilisateurJDBC();		
		list = daoutilisateur.loadall();
				
		
		int maxcolonne = 4;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j <= maxcolonne; j++){
				this.donnees[i][j-j] = i; //remplissage de la colonne # par le nombre de lignes
				this.donnees[i][j+1] = list.get(i).get_id();
				this.donnees[i][j+2] = list.get(i).get_nom();
				this.donnees[i][j+3] = list.get(i).get_pseudo();
				this.donnees[i][j+4] = list.get(i).get_mdp();
				j = 4;
			}
		}
	}
	
	public void supprimeruser(int id){
		//remplisage du tableau
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equals(id)){
				list.remove(id);
			}
		}
		
		
		int maxcolonne = 4;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j <= maxcolonne; j++){
				this.donnees[i][j-j] = i; //remplissage de la colonne # par le nombre de lignes
				this.donnees[i][j+1] = list.get(i).get_id();
				this.donnees[i][j+2] = list.get(i).get_nom();
				this.donnees[i][j+3] = list.get(i).get_pseudo();
				this.donnees[i][j+4] = list.get(i).get_mdp();
				j = 4;
			}
		}
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
		
		if (B.getText().equals("Chercher"))
			System.out.println("You have pressed button: " + B.getText()); 
		else if (B.getText().equals("Afficher tous les utilisateurs"))
			System.out.println("You have pressed button: " + B.getText());
		else if (B.getText().equals("Ajouter"))
			System.out.println("You have pressed button: " + B.getText());
		else if (B.getText().equals("Supprimer"))
			System.out.println("You have pressed button: " + B.getText());
		else if (B.getText().equals("Print"))
			System.out.println("You have pressed button: " + B.getText());
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

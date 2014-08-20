/**
 * 
 */
package com.connexion_base_1.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
	
	Object[][] donnees = new Object[25][25]; /*  = {{"1","ligne1-colonne1","ligne1-colonne2","ligne1-colonne3","ligne1-colonne4"},
			{"2","ligne2-colonne1","ligne2-colonne2","ligne2-colonne3","ligne2-colonne4"},
			{"3","ligne3-colonne1","ligne3-colonne2","ligne3-colonne3","ligne3-colonne4"},
			{"4","ligne4-colonne1","ligne4-colonne2","ligne4-colonne3","ligne4-colonne4"},
			{"5","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"6","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"7","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"8","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"9","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"10","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"11","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"12","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"13","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"14","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"15","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"16","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"17","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"18","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"},
			{"19","ligne5-colonne1","ligne5-colonne2","ligne5-colonne3","ligne5-colonne4"}};*/
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
	    this.quitter.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});	   
	    
	    this.apropos.add(aide);
	    
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
		 * On affiche la fenêtre
		 */
		setVisible(true);
		
		
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
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());					
			}
		 });
		 this.ajouter.addActionListener(new ActionListener() {				
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());	
				
				//appel de la boite de dialog pour enregistrer un nouveau utilisateur
				DialogNouveauUtilisateur dialog = new DialogNouveauUtilisateur(null, "Nouveau utilisateur", true);
				//Utilisateur utilisateur = dialog.showDialog();				
				if(dialog.getutilisateur().get_nom() == null){
					JOptionPane op = new JOptionPane();
					op.showMessageDialog(null,"Veuillez remplir touts les champs!", "Erreur",JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, dialog.getutilisateur().toString() +"\n a bien été enregistré", "Informations utilisateur",JOptionPane.INFORMATION_MESSAGE);
				}				
				
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());					
			}
		 });
		 this.chercherall.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton	B = (JButton)(e.getSource());				
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
				System.out.println("You have pressed button: " + B.getText()); 
				statuslabel.setText("You have pressed button: " + B.getText());
			}
		});	 
		 
		 
		 //EcouteurTexte ET = new EcouteurTexte();
		 //T1.addActionListener(ET);
		 
		 this.addWindowListener(new EcouteurFenetre());
		 
	}
	
	public void remplirtableau(){
		int maxligne = 20;
		int maxcolonne = 4;
		for(int i = 0; i <= maxligne; i++){
			for(int j = 0; j <= maxcolonne; j++){
				this.donnees[i][j-j] = i; //remplissage de la colonne # par le nombre de lignes
				this.donnees[i][j+1] = "data";
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

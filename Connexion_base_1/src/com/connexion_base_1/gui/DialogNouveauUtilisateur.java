/**
 * 
 */
package com.connexion_base_1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.connexion_base_1.metier.Utilisateur;

/**
 * @author R�ginald LUBIN
 *
 */
public class DialogNouveauUtilisateur extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur ;
	private boolean sendData;
	private JPanel panel;
	private JLabel textintro, textnom, textpseudo, textmdp;
	private JTextField fieldnom,fieldpseudo, fieldmdp;
	
	public DialogNouveauUtilisateur(JFrame parent, String title, boolean modal){
		super(parent,title,modal);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		//this.setVisible(true);
		
	}
	
	public Utilisateur showDialog(){
		this.sendData = false;
		//d�but du dialog
		this.setVisible(true);
		//le dialog prend fin
		//Si on a cliqu� sur OK, on envoie, sinon on envoie null
		return this.utilisateur ;
	}

	private void initComponent() {
		panel = new JPanel();
		Box b1 = Box.createHorizontalBox();
		textintro = new JLabel("Enregistrement d'un nouveau utilisateur!");
		b1.add(textintro);
		
		Box b2 = Box.createHorizontalBox();
		textnom = new JLabel("Nom :");
		fieldnom = new JTextField(10);
		b2.add(textnom);
		b2.add(new JLabel("  "));
		b2.add(fieldnom);
		
		Box b3 = Box.createHorizontalBox();
		textpseudo = new JLabel("Pseudo :");
		fieldpseudo = new JTextField(10);
		b3.add(textpseudo);
		b3.add(new JLabel("  "));
		b3.add(fieldpseudo);
		
		Box b4 = Box.createHorizontalBox();
		textmdp = new JLabel("Mdp :");
		fieldmdp = new JTextField(10);
		b4.add(textmdp);
		b4.add(new JLabel("  "));
		b4.add(fieldmdp);
		
		Box n = Box.createHorizontalBox();
		JButton okBouton = new JButton("OK");
		okBouton.addActionListener(new ActionListener() {
			
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {					
				if(fieldnom.getText().length() != 0 && fieldpseudo.getText().length() != 0 && fieldmdp.getText().length() != 0){
					utilisateur = new Utilisateur(fieldnom.getText(),fieldpseudo.getText(),fieldmdp.getText());
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, utilisateur.toString() +"\n a �t� enregistr�", "Informations utilisateur",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
				else{					
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "Veuillez renseigner tous les champs !", "Erreur",JOptionPane.ERROR_MESSAGE);
					//setVisible(false);
				}
				
				
				
			}
		});
		
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//System.exit(0);
			}
		});
		
		n.add(okBouton);
		n.add(new JLabel(" "));
		n.add(cancelBouton);
		
		Box englobetout = Box.createVerticalBox();
		englobetout.add(b1);
		englobetout.add(new JLabel(" "));
		englobetout.add(b2);
		englobetout.add(new JLabel(" "));
		englobetout.add(b3);
		englobetout.add(new JLabel(" "));
		englobetout.add(b4);
		englobetout.add(new JLabel(" "));
		englobetout.add(n);
		
		panel.add(englobetout);
		this.getContentPane().add(panel);
		
	}
}//fin de la classe

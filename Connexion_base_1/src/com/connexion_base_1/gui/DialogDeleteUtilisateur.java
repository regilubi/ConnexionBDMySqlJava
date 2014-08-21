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
import javax.swing.text.html.parser.Parser;

import com.connexion_base_1.metier.Utilisateur;

/**
 * @author 8510502w
 *
 */
public class DialogDeleteUtilisateur extends JDialog {
	private Utilisateur utilisateur = new Utilisateur() ;
	private boolean sendData;
	private JPanel panel;
	private JLabel textintro, textID;
	private JTextField fieldID;
	
	public DialogDeleteUtilisateur(JFrame parent, String title, boolean modal){
		super(parent,title,modal);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		//this.setVisible(true);
		
	}
	
	public Utilisateur showDialog(){
		this.sendData = false;
		//début du dialog
		this.setVisible(true);
		//le dialog prend fin
		//Si on a cliqué sur OK, on envoie, sinon on envoie null
		return this.utilisateur ;
	}

	private void initComponent() {
		panel = new JPanel();
		Box b1 = Box.createHorizontalBox();
		textintro = new JLabel("Entrez l'ID de l'utilisateur à supprimer!");
		b1.add(textintro);
		
		Box b2 = Box.createHorizontalBox();
		textID = new JLabel("ID :");
		fieldID = new JTextField(5);
		b2.add(textID);
		b2.add(new JLabel("  "));
		b2.add(fieldID);
		
				
		Box n = Box.createHorizontalBox();
		JButton okBouton = new JButton("Supprimer");
		okBouton.addActionListener(new ActionListener() {
			
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {					
				if(fieldID.getText().length() != 0 ){
					utilisateur.set_id(Integer.parseInt(fieldID.getText()));
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "L'utilisateur avec l'ID : " + utilisateur.get_id() +" \n a été supprimer", "Informations utilisateur",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
				else{					
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "Veuillez renseigner le champs ID !", "Erreur",JOptionPane.ERROR_MESSAGE);
					//setVisible(false);
				}				
			}
		});
		
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
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
		
		englobetout.add(n);
		
		panel.add(englobetout);
		this.getContentPane().add(panel);
	}
}//fin de la classe

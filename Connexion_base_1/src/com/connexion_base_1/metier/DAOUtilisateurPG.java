/**
 * 
 */
package com.connexion_base_1.metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author 8510502w
 *
 */
public class DAOUtilisateurPG extends DAOJDBC implements DAOUtilisateur {

	private static final String SQL_LOAD_ALL = "select * from utilisateur";
	private ArrayList<Utilisateur> listuser = new ArrayList<Utilisateur>();
	
	
	
	/**
	 * 
	 */
	public DAOUtilisateurPG() {
		super();		
	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#get(int)
	 */
	@Override
	public Utilisateur get(int id) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#loadall()
	 */
	@Override
	public ArrayList<Utilisateur> loadall() {
		Connection connection = connect();
		try {
			//creer la requette
			Statement instruction = connection.createStatement();		
			//...executer la requette
			ResultSet resultat = instruction.executeQuery(SQL_LOAD_ALL);
		
			//...parcour des résultats stoquer dans "resultat"
		
			while(resultat.next()){
				/*
				System.out.println("---------------------------");
				System.out.println("N° ID : "+resultat.getInt(1));
				System.out.println("NOM : "+resultat.getString(2));
				System.out.println("PSEUDO : "+resultat.getString(3));
				System.out.println("MDP: "+resultat.getString(4));
				*/
				this.listuser.add(new Utilisateur(resultat.getInt(1),resultat.getString(2),resultat.getString(3),resultat.getString(4)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(connection);
		return listuser;
	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#save(com.connexion_base_1.metier.Utilisateur)
	 */
	@Override
	public void save(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#delete(com.connexion_base_1.metier.Utilisateur)
	 */
	@Override
	public void delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#update(com.connexion_base_1.metier.Utilisateur)
	 */
	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

}

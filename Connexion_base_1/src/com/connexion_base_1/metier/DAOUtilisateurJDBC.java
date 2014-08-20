/**
 * 
 */
package com.connexion_base_1.metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author Réginald LUBIN
 *
 */
public class DAOUtilisateurJDBC extends DAOJDBC implements DAOUtilisateur {

	private static final String SQL_LOAD_ALL = "select * from utilisateur";
	private static final String SQL_GET = "select * from utilisateur where id=?";
	private static final String SQL_SAVE = "insert into utilisateur(nom,pseudo,mdp) values (?,?,?)";
	private static final String SQL_DELETE = "delete from utilisateur where id=?";
	private static final String SQL_UPDATE_MDP = "update utilisateur set mdp=? where id=?";
	private ArrayList<Utilisateur> listuser = new ArrayList<Utilisateur>();
	
	
	
	/**
	 * 
	 */
	public DAOUtilisateurJDBC() {
		super();		
	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#get(int)
	 */
	@Override
	public Utilisateur get(int id) {
		Utilisateur utilisateur = null;
		
		Connection connection = connect();
		
		try {
			PreparedStatement req = (PreparedStatement) connection.prepareStatement(SQL_GET);
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			
			if(res.next()){
				utilisateur = new Utilisateur(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
			}
			else{
				throw new Exception("Aucun utilisateur ayant le id "+id+ " n'a été trouvé");
			}
			res.close();
			req.close();
			close(connection);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return utilisateur;
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
		Connection connection = connect();
		try {
			PreparedStatement req_save = (PreparedStatement) connection.prepareStatement(SQL_SAVE);
			
			req_save.setString(1, utilisateur.get_nom());
			req_save.setString(2, utilisateur.get_pseudo());
			req_save.setString(3, utilisateur.get_mdp());
			int n = req_save.executeUpdate();
			
			if(n != 1){
				System.out.println("Erreur dans l'insertion de l'utilisateur " + utilisateur);
			}
			else
				System.out.println("Insertion de l'utilisateur " + utilisateur);
			req_save.close();
			close(connection);
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#delete(com.connexion_base_1.metier.Utilisateur)
	 */
	@Override
	public void delete(Utilisateur utilisateur) {
		if(utilisateur.get_id() != -1){
			Connection connection = connect();
			
			try {
				PreparedStatement req = (PreparedStatement) connection.prepareStatement(SQL_DELETE);
				
				req.setInt(1, utilisateur.get_id());
				int n = req.executeUpdate();
				
				if(n==1){
					utilisateur.set_id(-1); 
					System.out.println("Supression de l'utilisateur " + utilisateur);
				}
				else{
					//throw new Exception("Erreur dans la supression de l'utilisateur " + utilisateur);
					System.out.println("Erreur dans la supression de l'utilisateur " + utilisateur);
				}
				
				req.close();
				close(connection);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		} else{
			//throw new Exception ("L'utilisateur " + utilisateur + " n'est pas persistant");
			System.out.println("L'utilisateur " + utilisateur + " n'est pas persistant");
			} 
	}

	/* (non-Javadoc)
	 * @see com.connexion_base_1.metier.DAOUtilisateur#update(com.connexion_base_1.metier.Utilisateur)
	 */
	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

}//fin de la classe

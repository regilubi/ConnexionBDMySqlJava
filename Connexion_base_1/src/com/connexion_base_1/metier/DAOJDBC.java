/**
 * 
 */
package com.connexion_base_1.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 8510502w
 *
 */
public class DAOJDBC {

	private String _driver = "com.mysql.jdbc.Driver";
	private String _bd = "userlist";
	private String _url = "jdbc:mysql://127.0.0.1/" + _bd;
	private String _login = "root";
	private String _mdp = "";
	private Connection connexion;
	
	
	
	/**
	 * 
	 */
	public DAOJDBC() {
		super();
	}



	public Connection connect(){
		try{
			//...charger le driver mysql
			Class.forName(_driver);
			//...creer la connexion
			connexion = DriverManager.getConnection(_url,_login,_mdp);
			
			
			/**
			//3...creer la requette
			Statement instruction = connexion.createStatement();
			//...executer la requette
			ResultSet resultat = instruction.executeQuery("select * from utilisateur");
			//...parcour des résultats stoquer dans "resultat"
			while(resultat.next()){

				
				System.out.println("---------------------------");
				System.out.println("N° ID : "+resultat.getInt(1));
				System.out.println("NOM : "+resultat.getString(2));
				System.out.println("PSEUDO : "+resultat.getString(3));
				System.out.println("MDP: "+resultat.getString(4));

			}
			//...fermer la connexion
			connexion.close();
			*/
		}
		catch (Exception e){

			System.out.println("echec pilote : "+e);
		}
		return connexion;

		}
	
	public void close(Connection connexion){
		try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}



	public Connection getConnexion() {
		return connexion;
	}



	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	
	
}//fin de la classe

/**
 * 
 */
package com.connexion_base_1.main;




import java.sql.*;
import java.util.ArrayList;

import com.connexion_base_1.metier.Utilisateur;

/**
 * @author 8510502w
 *
 */
public class Main_connexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		ArrayList<Utilisateur> listuser = new ArrayList<Utilisateur>();
		listuser.add(new Utilisateur(1, "regi","lubi","mdp"));
		
		for(int i = 0; i < listuser.size(); i++){
			System.out.println(listuser.get(i).toString());
		}
		*/
		
		

		try{
			//...charger le driver mysql
			Class.forName("com.mysql.jdbc.Driver");
			//...creer la connexion
			Connection connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/userlist","root","");
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
		}
		catch (Exception e){

			System.out.println("echec pilote : "+e);
		}

		}
	
	
	public void connexionbd(){
		
	}

}

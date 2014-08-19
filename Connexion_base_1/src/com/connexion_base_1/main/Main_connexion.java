/**
 * 
 */
package com.connexion_base_1.main;




import java.sql.*;
import java.util.ArrayList;

import com.connexion_base_1.metier.DAOUtilisateur;
import com.connexion_base_1.metier.DAOUtilisateurPG;
import com.connexion_base_1.metier.Utilisateur;

/**
 * @author 8510502w
 *
 */
@SuppressWarnings("unused")
public class Main_connexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//trouvertouslesuser();	
		trouverunuserparid();
	}
	
	
	public static void trouvertouslesuser(){
		System.out.println("----Méthode pour trouver tous les utilisateurs ----");
		DAOUtilisateur daoutilisateur = new DAOUtilisateurPG();
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		list = daoutilisateur.loadall();
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());
		}		
	}
	
	public static void trouverunuserparid(){
		System.out.println("----Méthode pour trouver un user par son id ----");
		int id = 4;
		DAOUtilisateur utilisateur = new DAOUtilisateurPG();
		//utilisateur.get(id);
		System.out.println(utilisateur.get(id));
	}
	
	public static void suppressionuser(){
		System.out.println("----Méthode pour supprimer un utilisateur ----");
		
	}

}//fin de la classe main

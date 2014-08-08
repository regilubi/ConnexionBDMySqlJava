/**
 * 
 */
package com.connexion_base_1.main;




import java.sql.*;
import java.util.ArrayList;

import com.connexion_base_1.metier.DAOUtilisateurPG;
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
		
			essai1();		
	}
	
	
	public static void essai1(){
		DAOUtilisateurPG dao = new DAOUtilisateurPG();
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		list = dao.loadall();
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());
		}
		
		
	}

}

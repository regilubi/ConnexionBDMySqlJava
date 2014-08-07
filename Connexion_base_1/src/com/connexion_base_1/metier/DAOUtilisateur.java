/**
 * 
 */
package com.connexion_base_1.metier;

import java.util.ArrayList;

/**
 * @author 8510502w
 *
 */
public interface DAOUtilisateur {
	public Utilisateur get(int id);
	public ArrayList<Utilisateur> loadall();
	public void save(Utilisateur utilisateur);
	public void delete(Utilisateur utilisateur);
	public void update(Utilisateur utilisateur);
}

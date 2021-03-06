/**
 * 
 */
package com.connexion_base_1.metier;

/**
 * @author 8510502w
 *
 */
public class Utilisateur {

	private int _id = -1;
	private String _nom = null;
	private String _pseudo = null;
	private String _mdp = null;
	
	
	/**
	 * 
	 */
	public Utilisateur() {		
	}

	/**
	 * @param _id
	 * @param _nom
	 * @param _pseudo
	 * @param _mdp
	 */
	public Utilisateur(int _id, String _nom, String _pseudo, String _mdp) {
		super();
		this._id = _id;
		this._nom = _nom;
		this._pseudo = _pseudo;
		this._mdp = _mdp;
	}
	
	

	/**
	 * @param _nom
	 * @param _pseudo
	 * @param _mdp
	 */
	public Utilisateur(String _nom, String _pseudo, String _mdp) {
		super();
		this._nom = _nom;
		this._pseudo = _pseudo;
		this._mdp = _mdp;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_pseudo() {
		return _pseudo;
	}

	public void set_pseudo(String _pseudo) {
		this._pseudo = _pseudo;
	}

	public String get_mdp() {
		return _mdp;
	}

	public void set_mdp(String _mdp) {
		this._mdp = _mdp;
	}

	@Override
	public String toString() {
		String str;
	    if(this._nom != null && this._pseudo != null && this._mdp != null ){
	      str = "Description de l'utilisateur : \n";
	      str += "Nom : " + this._nom + "\n";
	      str += "Sexe : " + this._pseudo + "\n";
	      str += "Mdp : " + this._mdp + "\n";	  
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	}
	
	

}

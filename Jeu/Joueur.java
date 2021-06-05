package Jeu;

public class Joueur {

	private  boolean couleur;
	private  String nom;
	

	public Joueur(){
	}
	
	
	public Joueur(String nom,boolean c){
		this.nom = nom;
		this.couleur = c;
	}

	public boolean getCouleur(){
		return this.couleur;
	}
	public String getNom(){
		return this.nom;
	}

	
	public void setCouleur(boolean c){
		this.couleur = c;
	}
	
	public void setNom(String  n){
		this.nom = n;
	}
	
	
	public String toString(){
		if(this.getCouleur() == true) {
			return "Nom du Joueur : " + this.getNom() + "/ Couleur du joueur : Blanc";
		}else {
			return "Nom du Joueur : " + this.getNom() + "/ Couleur du joueur : Noir";
		}
	}

	
}

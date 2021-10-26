package Jeu;

public class Joueur {

	private  boolean couleur;
	private  String nom;

	//constructeur vide
	public Joueur(){
	}
	//constructeur d'un joueur
	public Joueur(String nom,boolean c){
		this.nom = nom;
		this.couleur = c;
	}

	//recupere la couleur du joueur
	public boolean getCouleur(){
		return this.couleur;
	}
	//recupere le nom du joueur
	public String getNom(){
		return this.nom;
	}

	//remplace la couleur du joueur par le boolean en parametre
	public void setCouleur(boolean c){
		this.couleur = c;
	}
	
	//remplace la nom du joueur en parametre
	public void setNom(String  n){
		this.nom = n;
	}
	
	//affichage des attribut d'un joueur
	public String toString(){
		if(this.getCouleur() == true) {
			return "Nom du Joueur : " + this.getNom() + "/ Couleur du joueur : Blanc";
		}else {
			return "Nom du Joueur : " + this.getNom() + "/ Couleur du joueur : Noir";
		}
	}

	
}

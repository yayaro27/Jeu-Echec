package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Cavalier extends Piece
{
	public String nom = "Cavalier";
	//Constructeur avec Case en parametre
	public Cavalier(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;

	}

	//Constructeur sans Case en parametre
	public Cavalier(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
	}

	//recupere le nom de cette piece
	public String getNom() {
		return this.nom;
	}
	
	//Affichage du Cavalier
	public String toString()
	{
		if(this.getCouleur() == true) {
			return super.toString() + "Cb" ;
		}
		else {
			return super.toString() + "Cn" ;
		}
	}


	
	//Verifie que le coup est bien conforme a celui d'un Cavalier	
	public boolean deplacementOk(Case a)
	{
	    	if(a.getLigne()==this.getCase().getLigne()-2 && a.getColonne()==this.getCase().getColonne()-1){
	    		return true;
	    	}
	    	if(a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()-2){
	    		return true;
	    	}
	    	if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()-2){
	    		return true;
	    	}
	    	if(a.getLigne()==this.getCase().getLigne()+2 && a.getColonne()==this.getCase().getColonne()-1){
	    		return true;
	    	} 
	    	if(a.getLigne()==this.getCase().getLigne()+2 && a.getColonne()==this.getCase().getColonne()+1){
	    		return true;
	    	}
	    	if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()+2){
	    		return true;
	    	} 
	    	if(a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()+2){
	    		return true;
	    	}
	    	if(a.getLigne()==this.getCase().getLigne()-2 && a.getColonne()==this.getCase().getColonne()+1){
	    		return true;
	    	} 
	    	
	    	return false;

	}
	
	//Verifie si le chemin de la piece est libre
	public boolean deplacementPossible(Case a){
		 return true;
	 }

}

package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Fou extends Piece
{

	public String nom = "Fou";
	//Constructeur avec Case en parametre
	public Fou(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;

		
	}
	//Constructeur sans Case en parametre
	public Fou(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;

	}
	//recupere le nom de cette piece
	public String getNom() {
		return this.nom;
	}
	//Affichage du Fou
	public String toString()
	{
		if(this.getCouleur() == true) {
			return super.toString() + "Fb" ;
		}
		else {
			return super.toString() + "Fn" ;
		}
	}

	//Verifie que le coup est bien conforme a celui d'un Fou
	public boolean deplacementOk(Case a)
	{
		
		
		if(a.getLigne() < 0 || a.getLigne() > 8 || a.getColonne() < 0 || a.getColonne() > 8) return false;
		for(int i=1; i<= 8; i++)
		{
	    	if(this.getCase().getLigne()+i==a.getLigne() && this.getCase().getColonne()+i==a.getColonne())
	    		return true;
	    	if(this.getCase().getLigne()-i==a.getLigne() && this.getCase().getColonne()-i==a.getColonne())
	    		return true;
	    	if(this.getCase().getLigne()+i==a.getLigne() && this.getCase().getColonne()-i==a.getColonne())
	    		return true;
	    	if(this.getCase().getLigne()-i==a.getLigne() && this.getCase().getColonne()+i==a.getColonne())
	    		return true; 		
	    }
	   	return false;
	}
	
	//Verifie si le chemin de la piece est libre
	   public boolean deplacementPossible(Case a){
		    int x = a.getColonne();
		    int y = a.getLigne();
		    if(a.getPiece() != null &&  this.getCouleur() == a.getPiece().getCouleur()) {
		    	return false;
		    }
		    	if(x>this.getCase().getColonne() && y>this.getCase().getLigne()){
		    		while(this.getCase().getColonne() != x-1 && this.getCase().getLigne() != y-1){
		    			
		    			if(this.getEchiquier().estVide(x-1, y-1) != true){
		    				return false;
		    			}
		    			x--;
		    			y--;
		    		}
		    		return true;
		    	}
		    	if(x<this.getCase().getColonne() && y>this.getCase().getLigne()){
		    		while(this.getCase().getColonne() != x+1 && this.getCase().getLigne() != y-1){
		    			
		    			if(this.getEchiquier().estVide(x+1, y-1) != true){
		    				return false;
		    			}
		    			x++;
		    			y--;
		    		}
		    		return true;
		    	}
		    	if(x>this.getCase().getColonne() && y<this.getCase().getLigne()){
		    		while(this.getCase().getColonne() != x-1 && this.getCase().getLigne() != y+1){
		    			
		    			if(this.getEchiquier().estVide(x-1, y+1) != true){
		    				return false;
		    			}
		    			x--;
		    			y++;
		    		}
		    		return true;
		    	}
		    	if(x<this.getCase().getColonne() && y<this.getCase().getLigne()){
		    		while(this.getCase().getColonne() != x+1 && this.getCase().getLigne() != y+1){
		    			
		    			if(this.getEchiquier().estVide(x+1, y+1) != true){
		    				return false;
		    			}
		    			x++;
		    			y++;
		    		}
		    		return true;
		    	}
		    
		    return false;
	   }
}

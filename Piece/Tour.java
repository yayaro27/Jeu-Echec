package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Tour extends Piece
{
	public String nom = "Tour";
	public Tour(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}

	public Tour(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
		
	}
	
	public String getNom() {
		return this.nom;
	}



	public String toString()
	{
		return super.toString() + ", plus particulierement une Tour" ;
	}
			
	public boolean deplacementOk(Case a)
	{
		
		for(int i = 0;i <=8;i++)
		{
	    		if(i == a.getLigne() && a.getColonne()== this.getCase().getColonne())
	    		{
	    			return true;
	    		}
	    		if(i == a.getColonne() && a.getLigne() == this.getCase().getLigne())
	    		{
	    			return true;
	    		}
	    }
	    return false;
	}
	
	 public boolean deplacementPossible(Case a ){
		 	int x = a.getColonne();
		 	int y = a.getLigne();
		 	if(a.getPiece() != null &&  this.getCouleur() == a.getPiece().getCouleur()) {
		    	return false;
		    }
		    if(this.getCase().getColonne() != x && this.getCase().getLigne() ==y){
		    	if(this.getCase().getColonne()  > x){ 
		    		for(int i=this.getCase().getColonne() -1;i>x;i--){
		
		    			if(this.getEchiquier().estVide(i, y) != true){
		    				return false;
		    			}
		    		}
		    		return true;
		    	}
		    	if(this.getCase().getColonne()  < x){ 
		    		for(int i=this.getCase().getColonne() +1;i<x;i++){
		
		    			if(this.getEchiquier().estVide(i, y) != true){
		    				return false;
		    			}
		    		}
		    		return true;
		    	}
		    }
		    if(this.getCase().getLigne() != y && this.getCase().getColonne()  == x){
		    	if(this.getCase().getLigne() > y){
		    		for(int i=this.getCase().getLigne()-1;i>y;i--){
		
		    			if(this.getEchiquier().estVide(x, i) != true){
		    				return false;
		    			}
		    		}
		    		return true;
		    	}
		    	if(this.getCase().getLigne() < y){
		    		for(int i=this.getCase().getLigne()+1;i<y;i++){
		
		    			if(this.getEchiquier().estVide(x, i) != true){
		    				return false;
		    			}
		    		}
		    	return true;
		    	}
		    }
		    return false;
	    }
}

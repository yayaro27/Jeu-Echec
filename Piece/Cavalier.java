package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Cavalier extends Piece
{
	public String nom = "Cavalier";
	public Cavalier(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}

	public Cavalier(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
		
	}

	public String getNom() {
		return this.nom;
	}

	public String toString()
	{
		return super.toString() + ", plus particulierement un Cavalier" ;
	}


	
		
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
	
	public boolean deplacementPossible(Case a){
		 return true;
	 }

}

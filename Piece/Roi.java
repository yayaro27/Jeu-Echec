package Piece;

import Plateau.Case;
import Plateau.Echiquier;
import java.util.ArrayList;

public class Roi extends Piece
{
	public String nom = "Roi";
	public Roi(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}

	public Roi(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
		
	}

	public String getNom() {
		return this.nom;
	}
	
	public String toString()
	{
		return super.toString() + ", plus particulierement un Roi" ;
	}
	
	


	
			
	public boolean deplacementOk(Case a)
	{
	    
	    	if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne() || a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()){
	    		return true;
	    	
	    	}else if(a.getLigne()==this.getCase().getLigne() && a.getColonne()==this.getCase().getColonne()+1 || a.getLigne()==this.getCase().getLigne() && a.getColonne()==this.getCase().getColonne()-1){
	    		return true;
	    	
	    	}else if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()+1 || a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()-1 || a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()-1 || a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()+1){
	    		return true;
	    	}
	   return false;
	}
	
	public boolean deplacementPossible(Case a){
		int x = this.getCase().getColonne();
		int y = this.getCase().getLigne();
		if(a.getPiece() != null &&  this.getCouleur() == a.getPiece().getCouleur()) {
	    	return false;
		}
		return true;
	 }
	
	public boolean estEchec(){
    	ArrayList<Piece> atester = this.getEchiquier().getAllPiece();
    	for(Piece pi : atester){
    		if(pi.getCase().getPiece() != null) {
	    		if(pi.deplacementOk(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1]) && pi.deplacementPossible(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1])){
	    			if(this.getCouleur() == true && pi.getCouleur() == false){
	    				return true;
	    			}
	    			if(this.getCouleur() == false && pi.getCouleur() == true){
	    				return true;
	    			}
	    		}
    		}
    	}
		return false;

    }
	
	public boolean estMAT(){
		ArrayList<Piece> atester = this.getEchiquier().getAllPiece();
    	for(Piece pi : atester){
    		if(pi.getCase().getPiece() != null) {
		    	if(pi.getCouleur() == this.getCouleur()) {
		    		for(int i = 0 ; i< this.getEchiquier().echiquier.length; i++){
		    			for(int j=0; j<this.getEchiquier().echiquier[i].length; j++){
				    		if(pi.deplacementOk(this.getEchiquier().echiquier[j][i]) && pi.deplacementPossible(this.getEchiquier().echiquier[j][i])) {
				    			if(this.estEchec() == false) {
				    				return false;
				    			}
				    		
				    		}
		    			
		    			}
		    		}
		    	}
    		}
		}
    	return true;
	}
	
  
}

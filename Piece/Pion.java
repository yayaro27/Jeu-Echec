package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Pion extends Piece
{
	private boolean premierCoup = true;
	public String nom = "Pion";
	
	public Pion(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}

	public Pion(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
		
	}
	
	public String getNom() {
		return this.nom;
	}

	
	public String toString()
	{
		return super.toString() + ", plus particulierement un Pion" ;
	}
	
	public boolean getPremierCoup(){
    	return this.premierCoup;
    }
    
   
    public void setPremierCoup(boolean b){
    	this.premierCoup = b;
    }


	
	public boolean deplacementOk(Case a)
	{
		
		int x = a.getColonne();
	 	int y = a.getLigne();
		if(x < 0 || x > 7 || y < 0 || y  > 7) return false;
		  
		if(this.getEchiquier().getCase(a).getPiece() == null){
		
		    		if(this.getCouleur() == true){
			            if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()+2 && premierCoup==true){
			                return true;
			            }
			    		if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()+1){
			    			return true;
			    		}
			    	}else{
			            if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()-2 && premierCoup==true){
			                return true;
			            }
			    		if(a.getColonne()==this.getCase().getColonne() && a.getLigne()== this.getCase().getLigne()-1){
			    			return true;
			    		}
			    	}
			
		}else{
		    		if(this.getCouleur() == true){
		    			if(a.getColonne() == this.getCase().getColonne()+1 && a.getLigne() == this.getCase().getLigne() +1){
		        			return true;
		        		}
		    			if(a.getColonne() == this.getCase().getColonne()-1 && a.getLigne() == this.getCase().getLigne() +1){
		        			return true;
		        		}
		    		}else{
		    			if(a.getColonne() == this.getCase().getColonne()-1 && a.getLigne() == this.getCase().getLigne() -1){
		        			return true;
		        		}
		    			if(a.getColonne() == this.getCase().getColonne()+1 && a.getLigne() == this.getCase().getLigne()-1){
		        			return true;
		        		}
		    		}
			    	return false;
			    }
		    	return false;
	}
	
	
	 public boolean deplacementPossible(Case a){
		 	int x = a.getColonne();
		 	int y = a.getLigne();
		 	if(a.getPiece() != null &&  this.getCouleur() == a.getPiece().getCouleur()) {
		    	return false;
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
		    return true;
	  }

}

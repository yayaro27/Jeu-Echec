package Piece;

import Plateau.Case;
import Plateau.Echiquier;
import java.util.ArrayList;

public class Roi extends Piece
{
	
	private String nom = "Roi";
	//Constructeur avec Case en parametre
	public Roi(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}
	//Constructeur sans Case en parametre
	public Roi(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
	
	}
	//recupere le nom de cette piece
	public String getNom() {
		return this.nom;
	}
	
	
	
	//Affichage du Roi
	public String toString()
	{
		if(this.getCouleur() == true) {
			return super.toString() + "Rb" ;
		}
		else {
			return super.toString() + "Rn" ;
		}
	}
	
	
	


	
	//limite les deplacements de la piece a celui d'un roi	
	public boolean deplacementOk(Case a)
	{
	    
	    if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne() || a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()){
	    	return true;
	    	
	    }else if(a.getLigne()==this.getCase().getLigne() && a.getColonne()==this.getCase().getColonne()+1 || a.getLigne()==this.getCase().getLigne() && a.getColonne()==this.getCase().getColonne()-1){
	    	return true;
	    	
	    }else if(a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()+1 || a.getLigne()==this.getCase().getLigne()+1 && a.getColonne()==this.getCase().getColonne()-1 
	    		|| a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()-1 || a.getLigne()==this.getCase().getLigne()-1 && a.getColonne()==this.getCase().getColonne()+1){
	    	return true;
	    }
	  return false;
	}
	
	//verifie si le chemin pour aller a la case prise en parametre est libre et s'il ne risque  pas de mettre echec le roi 
	public boolean deplacementPossible(Case a){
		ArrayList<Piece> atester1 = this.getEchiquier().getAllPieceBlanche();
		ArrayList<Piece> atester2 = this.getEchiquier().getAllPieceNoire();
		if(a.getPiece() != null &&  this.getCouleur() == a.getPiece().getCouleur()) {
	    	return false;
		}
	    if(this.getCouleur() == false) 
        {
            for(int i=0;i<atester1.size();i++) 
            {
                if( atester1.get(i).deplacementOk(a) && atester1.get(i).deplacementPossible(a)) 
                {
                	
                    return false;
                }
            }
        }

        if(this.getCouleur() == true) 
        {
            for(int i=0;i<atester2.size();i++) 
            {
            	 if( atester2.get(i).deplacementOk(a) && atester2.get(i).deplacementPossible(a))
                {
            		
            		 return false;
                }
            }
        }
        return true; 
    }
		
	//verifie si le roi est en echec
	public boolean estEchec(){
    	ArrayList<Piece> atester = this.getEchiquier().getAllPiece();
    	for(Piece pi : atester){
    		if(pi.getCase().getPiece() != null) {
	    		if(pi.deplacementOk(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1]) && 
	    		   pi.deplacementPossible(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1])){
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
	
	//return une liste des pieces qui mettent le roi en echec
	public ArrayList<Piece> QuiEchecRoi(){
    	ArrayList<Piece> atester = this.getEchiquier().getAllPiece();
    	ArrayList<Piece> a = new ArrayList<Piece>();
    	for(Piece pi : atester){
    		if(pi.getCase().getPiece() != null) {
	    		if(pi.deplacementOk(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1]) && pi.deplacementPossible(this.getEchiquier().echiquier[this.getCase().getColonne()-1][this.getCase().getLigne()-1])){
	    			if(this.getCouleur() == true && pi.getCouleur() == false){
	    				a.add(pi.getCase().getPiece());
	    			}
	    			if(this.getCouleur() == false && pi.getCouleur() == true){
	    				a.add(pi.getCase().getPiece());
	    			}
	    		}
    		}
    	}
		return a;

    }
	
	//test si le roi n'est pas en echec mais ne peut pas bouger et que aucune piece de la couelur du  roi ne peut bouger return true
	public boolean estPAT(){
		ArrayList<Case> a =new ArrayList<Case>();
		ArrayList<Piece> atester1 = this.getEchiquier().getAllPieceBlanche();
		ArrayList<Piece> atester2 = this.getEchiquier().getAllPieceNoire();
		if(this.estEchec() == true ) {
			return false;
		}
		
		if(this.estEchec() != true ) {
			for(int i = 0 ; i<this.CasesPossibles().size() ; i++) {
				if(this.deplacementOk(this.CasesPossibles().get(i)) && this.deplacementPossible(this.CasesPossibles().get(i))){
					
										
						
				}
			}
			if(this.getCouleur() == true) {
		    	for(Piece pi : atester1){
			    	for(int i = 0 ; i<pi.CasesPossibles().size() ; i++) {
		    			if(pi.deplacementOk(pi.CasesPossibles().get(i)) == true) {
		    				if(pi.deplacementPossible(pi.CasesPossibles().get(i)) == true) {
		    					return false;
		    				}
		    				
		    			}
		    		}
		    	}
			}else {
				for(Piece pi : atester2){
			    	for(int i = 0 ; i<pi.CasesPossibles().size() ; i++) {
		    			if(pi.deplacementOk(pi.CasesPossibles().get(i)) == true) {
		    				if(pi.deplacementPossible(pi.CasesPossibles().get(i)) == true) {
		    					return false;
		    				}
		    				
		    			}
		    		}
		    	}
			}
		}
		return true;
	}
	
	

	
  
}

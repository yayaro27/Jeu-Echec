package Piece;


import Plateau.Case;
import Plateau.Echiquier;

public class Pion extends Piece
{

	private boolean premierCoup = true;
	public String nom = "Pion";
	//Constructeur avec Case en parametre
	public Pion(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;
		
	}
	//Constructeur sans Case en parametre
	public Pion(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;
		
	}
	//recupere le nom de cette piece
	public String getNom() {
		return this.nom;
	}

	//Affichage du Pion
	public String toString()
	{
		if(this.getCouleur() == true) {
			return super.toString() + "Pb" ;
		}
		else {
			return super.toString() + "Pn" ;
		}
	}
	//recupere true si le premierCoup de cette n'est pas encore jouer
	public boolean getPremierCoup(){
    	return this.premierCoup;
    }
    
	//met le boolean en parametre dans premier
    public void setPremierCoup(boolean b){
    	this.premierCoup = b;
    }
    
    
	

  //Verifie que le coup est bien conforme a celui d'un Pion
	public boolean deplacementOk(Case a)
	{
		
		int x = a.getColonne();
	 	int y = a.getLigne();
		if(x < 1 || x > 8 || y < 1 || y  > 8) return false;
		  
		if(this.getEchiquier().getCase(a).getPiece() == null){
		
		    		if(this.getCouleur() == true){
			            if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()+2 && premierCoup==true){
			            	this.setPremierCoup(false);
			            	return true;
			            }
			    		if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()+1){
			    			this.setPremierCoup(false);
			    			return true;
			    		}
			    	}else{
			            if(a.getColonne()==this.getCase().getColonne() && a.getLigne() == this.getCase().getLigne()-2 && premierCoup==true){
			            	this.setPremierCoup(false);
			                return true;
			            }
			    		if(a.getColonne()==this.getCase().getColonne() && a.getLigne()== this.getCase().getLigne()-1){
			    			this.setPremierCoup(false);
			    			return true;
			    		}
			    	}
			
		}else{
		    		if(this.getCouleur() == true){
		    			if(a.getColonne() == this.getCase().getColonne()+1 && a.getLigne() == this.getCase().getLigne() +1){
		    				this.setPremierCoup(false);
		        			return true;
		        		}
		    			if(a.getColonne() == this.getCase().getColonne()-1 && a.getLigne() == this.getCase().getLigne() +1){
		    				this.setPremierCoup(false);
		        			return true;
		        		}
		    		}else{
		    			if(a.getColonne() == this.getCase().getColonne()-1 && a.getLigne() == this.getCase().getLigne() -1){
		    				this.setPremierCoup(false);
		        			return true;
		        		}
		    			if(a.getColonne() == this.getCase().getColonne()+1 && a.getLigne() == this.getCase().getLigne()-1){
		    				this.setPremierCoup(false);
		        			return true;
		        		}
		    		}
			    	return false;
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

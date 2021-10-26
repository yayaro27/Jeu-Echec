package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public class Dame extends Piece
{
	
	private String nom = "Dame";
	//Constructeur avec Case en parametre
	public Dame(boolean couleur, Case c, Echiquier echiquier)
	{
		super(couleur, c , echiquier) ;

	}
	
	//Constructeur sans Case en parametre
	public Dame(boolean couleur, Echiquier echiquier)
	{
		super(couleur, echiquier) ;

	}
	//recupere le nom de cette piece
	public String getNom() {
		return this.nom;
	}
	
	
	//Affichage de la Dame
	public String toString()
	{
		if(this.getCouleur() == true) {
			return super.toString() + "Db" ;
		}
		else {
			return super.toString() + "Dn" ;
		}
	}

	//Verifie que le coup est bien conforme a celui d'une Dame	
	public boolean deplacementOk(Case a)
	{
		for(int i = 0;i <=8;i++)
		{
    		if(i==a.getLigne() && a.getColonne()==this.getCase().getColonne())
    		{
    			return true;
    		}
    		if(i==a.getColonne() && a.getLigne()==this.getCase().getLigne())
    		{
    			return true;
    		}
    	}
    	for(int i=0; i<= 8; i++)
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
	 	if(this.getCase().getColonne() != x && this.getCase().getLigne() != y){   
       	
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
       }
       if(this.getCase().getColonne()!= x && this.getCase().getLigne() ==y){
       	if(this.getCase().getColonne() > x){
       		for(int i=this.getCase().getColonne()-1;i>x;i--){

       			if(this.getEchiquier().estVide(i, y) != true){
       				return false;
       			}
       		}
       		return true;
       	}
       	if(this.getCase().getColonne() < x){
       		for(int i=this.getCase().getColonne()+1;i<x;i++){

       			if(this.getEchiquier().estVide(i, y) != true){
       				return false;
       			}
       		}
       		return true;
       	}
       }
       if(this.getCase().getLigne() != y && this.getCase().getColonne() == x){
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
package Plateau;

 import Piece.Piece;
 import java.util.ArrayList;
 import Piece.Roi;
 import Piece.Tour;
 import Piece.Fou;
 import Piece.Pion;
 import Piece.Cavalier;
 import Piece.Dame;

public class Echiquier 
{
	public Case[][] echiquier;
	 
	public Echiquier()
	{
		echiquier = new Case[8][8];	
	}
	
	public String toString()
	{		String c = "";
		for(int i = 0; i < this.echiquier.length; i++){
			for(int j = 0; j < this.echiquier[i].length; j++){
				c += this.echiquier[i][j].toString() + "\n";
			}
		}
		return c;
	}
	
	
	public void placerPiece(int x, int y, Piece p) 
	{	Case c = this.echiquier[x][y];
		if(p != null) {
			c.setPiece(p);
			p.setCase(c);
		}else {
			c.setPiece(p);
			
		}
	}
	public Case getCase(Case a){
		if (a.getColonne() < 0 || a.getColonne() > 8){
			System.out.println("Erreur dans la coordonnee sur l'axe des abscisse : ("+a.getColonne()+","+a.getLigne()+")");
			return null;
		}
		if (a.getLigne()>8 || a.getLigne()<0){
			System.out.println("Erreur dans la coordonnee sur l'axe des ordonnees : ("+a.getColonne()+","+a.getLigne()+")");
			return null;
		}
		return this.echiquier[a.getColonne()-1][ a.getLigne()-1];
	}
	
	public void initialisationEchiquier(){
		for(int i = 0; i < echiquier.length; i++){
			for(int j = 0; j < echiquier[i].length; j++){
				echiquier[i][j] = null;
			}
		}
		
		for(int i = 0; i < echiquier.length; i++){
					int reste = i % 2;
					if (reste == 0) {
					this.echiquier[i][0] = new Case(false,i+1,1);
					this.echiquier[i][1] = new Case(true,i+1,2);
					this.echiquier[i][2] = new Case(false,i+1,3);
					this.echiquier[i][3] = new Case(true,i+1,4);
					this.echiquier[i][4] = new Case(false,i+1,5);
					this.echiquier[i][5] = new Case(true,i+1,6);
					this.echiquier[i][6] = new Case(false,i+1,7);
					this.echiquier[i][7] = new Case(true,i+1,8);
					}else {
					this.echiquier[i][0] = new Case(true,i+1,1);
					this.echiquier[i][1] = new Case(false,i+1,2);
					this.echiquier[i][2] = new Case(true,i+1,3);
					this.echiquier[i][3] = new Case(false,i+1,4);
					this.echiquier[i][4] = new Case(true,i+1,5);
					this.echiquier[i][5] = new Case(false,i+1,6);
					this.echiquier[i][6] = new Case(true,i+1,7);
					this.echiquier[i][7] = new Case(false,i+1,8);
					
					}
				
				
		}
		
		this.placerPiece(0, 0,new Tour(true,this));
		this.placerPiece(1, 0,new Cavalier(true,this));
		this.placerPiece(2, 0,new Fou(true,this));
		this.placerPiece(3, 0,new Dame(true,this));
		this.placerPiece(4, 0,new Roi(true,this));
		this.placerPiece(5, 0,new Fou(true,this));
		this.placerPiece(6, 0,new Cavalier(true,this));
		this.placerPiece(7, 0,new Tour(true,this));
		
		for(char i = 0; i <= 7; i++){
			this.placerPiece(i, 1,new Pion(true,this));
			this.placerPiece(i, 6,new Pion(false,this));
		}
		
		this.placerPiece(0, 7,new Tour(false,this));
		this.placerPiece(1, 7,new Cavalier(false,this));
		this.placerPiece(2, 7,new Fou(false,this));
		this.placerPiece(3, 7,new Dame(false,this));
		this.placerPiece(4, 7,new Roi(false,this));
		this.placerPiece(5, 7,new Fou(false,this));
		this.placerPiece(6, 7,new Cavalier(false,this));
		this.placerPiece(7, 7,new Tour(false,this));
	}
	
	public boolean estVide(int x, int y){
		
	        if(echiquier[x-1][y-1].getPiece() == null){
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	
	public void affiche(){
    	
		for(int i = echiquier.length-1; i >= 0; i--){
			System.out.print((i+1));
			System.out.print(" | ");
			for(int j=0; j<echiquier[i].length; j++){
				if(echiquier[j][i].getPiece()!= null){
					if(echiquier[j][i].getPiece().getCouleur() == false){
							System.out.print(  echiquier[j][i].getPiece().getNom().charAt(0)+"n | ");
					}else{
							System.out.print( echiquier[j][i].getPiece().getNom().charAt(0)+"b | ");
					}
				}else{
					System.out.print("   | ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("    A    B    C    D    E    F    G    H");
    }
	
	 public ArrayList<Piece> getAllPiece(){
	    	ArrayList<Piece> p = new ArrayList<Piece>();
	    	for(int i=0; i<echiquier.length;i++){
	    		for(int j=0; j<echiquier.length;j++){
	    			if(this.getCase(echiquier[i][j]).getPiece() != null){
	    				p.add(this.getCase(echiquier[i][j]).getPiece());
	    			}
	    		}
	    	}
	   return p;
	 }
	
	 public ArrayList<Piece> getAllPieceBlanche(){
	    	ArrayList<Piece> p = new ArrayList<Piece>();
	    	for(int i=0; i<echiquier.length;i++){
	    		for(int j=0; j<echiquier.length;j++){
	    			if(this.getCase(echiquier[i][j]).getPiece() != null){
	    				if(this.getCase(echiquier[i][j]).getPiece().getCouleur() == true){
	    					p.add(this.getCase(echiquier[i][j]).getPiece());
	    				}
	    			}
	    		}
	    	}
	   return p;
	 }
	 
	 public ArrayList<Piece> getAllPieceNoire(){
	    	ArrayList<Piece> p = new ArrayList<Piece>();
	    	for(int i=0; i<echiquier.length;i++){
	    		for(int j=0; j<echiquier.length;j++){
	    			if(this.getCase(echiquier[i][j]).getPiece() != null){
	    				if(this.getCase(echiquier[i][j]).getPiece().getCouleur() == false){
	    					p.add(this.getCase(echiquier[i][j]).getPiece());
	    				}
	    			}
	    		}
	    	}
	   return p;
	 }
}	
	


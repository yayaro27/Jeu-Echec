package Plateau;

import Piece.Piece;

public class Case
{
	private boolean couleur ;
	private int ligne       ;
	private int colonne     ;
	private Piece piece     ;


	public Case(boolean uneCouleur, int uneColonne, int uneLigne,Piece p)
	{
		this.couleur = uneCouleur ;
		this.ligne   = uneLigne   ;
		this.colonne = uneColonne ;
		this.piece = p            ;
	}
	public Case(boolean uneCouleur, int uneColonne, int uneLigne)
	{
		this.couleur = uneCouleur ;
		this.ligne   = uneLigne   ;
		this.colonne = uneColonne ;
		this.piece = null         ;
	}

	public boolean getCouleur()
	{
		return this.couleur ;
	}	
	
	public Piece getPiece()
	{
		return this.piece ;
	}
	
	public String getNomCouleur()
	{
		if (couleur)
			return "blanche" ;
		else
			return "noire" ;
	}	

	public int getLigne()
	{
		return this.ligne ;
	}	

	public String getNomColonne()
	{
		switch(this.colonne)
		{
			case 1  : return "A" ;
			case 2  : return "B" ;
			case 3  : return "C" ;
			case 4  : return "D" ;
			case 5  : return "E" ;
			case 6  : return "F" ;
			case 7  : return "G" ;
			case 8  : return "H" ;
			default : return "?" ;
		}
	}

    public int getColonne()
	{
		return this.colonne ;
	}
    
    public void setPiece(Piece p)
	{
    	this.piece = p;
	}

	public String toString()
	{
		if(this.getPiece() == null) {
			 return "case : "+ this.getNomColonne() + " " + this.getLigne() + " " + 
					   " " + this.getNomCouleur() + " // " + "Piece : Ne contient pas de Piece ! ";
		}else {
			
			return "case : "+ this.getNomColonne() + " " + this.getLigne() + " " + 
				   " " + this.getNomCouleur() + " // " +  this.getPiece() ;
		}
	}
	
		
}

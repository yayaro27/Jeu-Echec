package Plateau;

import Piece.Cavalier;
import Piece.Dame;
import Piece.Fou;
import Piece.Piece;
import Piece.Pion;
import Piece.Roi;
import Piece.Tour;

public class Case
{
	private boolean couleur ;
	private int ligne       ;
	private int colonne     ;
	private Piece piece     ;

	//constructeur avec une piece en entrée
	public Case(boolean uneCouleur, int uneColonne, int uneLigne,Piece p)
	{
		this.couleur = uneCouleur ;
		this.ligne   = uneLigne   ;
		this.colonne = uneColonne ;
		this.piece = p            ;
	}
	//constructeur sans piece en entrée
	public Case(boolean uneCouleur, int uneColonne, int uneLigne)
	{
		this.couleur = uneCouleur ;
		this.ligne   = uneLigne   ;
		this.colonne = uneColonne ;
		this.piece = null         ;
	}

	//met le boolean en parametre dans l'attribut couleur de la case
	public void setCouleur(boolean c)
	{
		 this.couleur = c;
	}
	// recupere la couleur de la case
	public boolean getCouleur()
	{
		return this.couleur ;
	}	
	// recupere la piece associé a la case
	public Piece getPiece()
	{
		return this.piece ;
	}
	//recupere une chaine de caractere selon la couleur
	public String getNomCouleur()
	{
		if (couleur)
			return "blanche" ;
		else
			return "noire" ;
	}	
    //recupere la ligne de la case
	public int getLigne()
	{
		return this.ligne ;
	}	
	 //recupere le nom de la colonne en lettre selon la colonne en chiffre
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
	
	
	 //recupere la colonne de la case
    public int getColonne()
	{
		return this.colonne ;
	}
    //recupere la piece de la case
    public void setPiece(Piece p)
	{
    	this.piece = p;
	}

    //affiche le contenue d'une case
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

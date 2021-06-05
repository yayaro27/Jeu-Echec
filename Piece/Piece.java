package Piece;

import Plateau.Case;
import Plateau.Echiquier;

public abstract class Piece
{
	private Echiquier echiquier;
	private boolean couleur ;   // true => blanc, false => noir
	private Case c          ; 
	private String nom		;

	public Piece(boolean uneCouleur, Case uneCase,Echiquier echiquier )
	{
		this.couleur = uneCouleur ;
		this.c = uneCase ;
		this.echiquier = echiquier;
	}
	
	public Piece(boolean uneCouleur,Echiquier echiquier)
	{
		this.couleur = uneCouleur ;
		this.echiquier = echiquier;
		this.c = null ;
	}
	
	public Echiquier getEchiquier()
	{
		return this.echiquier ;
	}
	
	public String getNom() {
		return this.nom;
	}

	public boolean getCouleur()
	{
		return this.couleur ;
	}	

	public Case getCase()
	{
		return this.c ;
	}		

	public void setCase(Case C)
	{	    
		this.c = C;
	}
	public String getNomCouleur()
	{
		if (couleur)
			return "blanche" ;
		else
			return "noire" ;
	}	


	public String toString()
	{
		
		return " Piece : " + this.getNomCouleur();
	}

	public abstract boolean deplacementOk(Case arrivee) ;
	
	public abstract boolean deplacementPossible(Case arrivee);
	
		
}

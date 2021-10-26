package Piece;

import java.util.ArrayList;

import Plateau.Case;
import Plateau.Echiquier;

public abstract class Piece
{
	private Echiquier echiquier;
	private boolean couleur ;   // true => blanc, false => noir
	private Case c          ; 
	private String nom		;
	private String nomSave = "null"		;
	//Constructeur avec Case en parametre
	public Piece(boolean uneCouleur, Case uneCase,Echiquier echiquier )
	{
		this.couleur = uneCouleur ;
		this.c = uneCase ;
		this.echiquier = echiquier;
	}
	//Constructeur sans Case en parametre
	public Piece(boolean uneCouleur,Echiquier echiquier)
	{
		this.couleur = uneCouleur ;
		this.echiquier = echiquier;
		this.c = null ;
	}
	//recupere l'echiquier de la piece
	public Echiquier getEchiquier()
	{
		return this.echiquier ;
	}
	//recupere le nomSave de la piece
	public String getNomSave() {
		return this.nom;
	}
	//recupere le nom de la piece
	public String getNom() {
		return this.nom;
	}
	//recupere la couleur de la piece
	public boolean getCouleur()
	{
		return this.couleur ;
	}	
	//recupere la Case de la piece
	public Case getCase()
	{
		return this.c ;
	}		
	//met la Case en parametre a la place de la case de la piece
	public void setCase(Case C)
	{	    
		this.c = C;
	}
	//recupere le nom de la couleur 
	public String getNomCouleur()
	{
		if (couleur)
			return "blanche" ;
		else
			return "noire" ;
	}	
	//met a true la promotion si un Pion atteint la premiere ligne du camp adverse
	public boolean isPromotion(){
        if(this.getCouleur() == false && this.getNom() == "Pion" && this.getCase().getLigne() == 1){
            return true;
        }
        if(this.getCouleur() == true && this.getNom() == "Pion" && this.getCase().getLigne() == 8){
            return true;
        }
        else return false;
    }  

	//affiche la piece
	public String toString()
	{
		
		return "";
	}
	
	//return une liste de toutes les Cases accessible de la piece utilisant cette methode
	public ArrayList<Case> CasesPossibles(){
		ArrayList<Case> c = new ArrayList<Case>(); 
		for(int i = 0 ; i< this.getEchiquier().echiquier.length; i++){
			for(int j=0; j<this.getEchiquier().echiquier[i].length; j++){
				if(this.deplacementOk(this.getEchiquier().echiquier[j][i]) == true && this.deplacementPossible(this.getEchiquier().echiquier[j][i]) == true) {
					c.add(this.getEchiquier().echiquier[j][i]);
				}
			}
		}
		return c;
	}
	//Test essayant de recuperer uniquement les cases en direction du roi depuis la piece utilisant cette methode
	public ArrayList<Case> CasesPossiblesVersRoi(){
		ArrayList<Case> c = new ArrayList<Case>(); 
		for(int i = 0 ; i< this.getEchiquier().echiquier.length; i++){
			for(int j=0; j<this.getEchiquier().echiquier[i].length; j++){
				if(this.getEchiquier().echiquier[j][i].getPiece().getNom() == "Roi") {
					if(this.deplacementOk(this.getEchiquier().echiquier[j][i]) == true && this.deplacementPossible(this.getEchiquier().echiquier[j][i]) == true) {
						c.add(this.getEchiquier().echiquier[j][i]);
					}
				}
			}
		}
		return c;
	}

	//Verifie que le coup est bien conforme a celui de la piece utilisant cette methode
	public abstract boolean deplacementOk(Case arrivee) ;
	
	//Verifie si le chemin de la piece est libre
	public abstract boolean deplacementPossible(Case arrivee);
	
		
}

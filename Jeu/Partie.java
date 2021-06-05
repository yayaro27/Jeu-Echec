package Jeu;

import Piece.Roi;
import java.util.Scanner;
import Plateau.Echiquier;
import Plateau.Case;
import Piece.Piece;
import java.util.ArrayList;

public class Partie {
	
	private Echiquier echiquier;
	private ArrayList<Piece> prises;
	private Joueur joueurBlanc;
	private Joueur joueurNoir;
	private Joueur joueurAuTrait;
	private Roi roiNoir;
	private Roi roiBlanc;
	private ArrayList<Case> historique;
	
	public Partie()
	{
		this.echiquier = null;
        this.joueurBlanc = null;
        this.joueurNoir = null;
        this.joueurAuTrait = null;
        this.prises = null;
       
	}
	
	
	public void initialiser() {
        this.joueurBlanc = new Joueur("", true);
        this.joueurNoir = new Joueur("", false);
        this.joueurAuTrait = this.getJoueurBlanc();
        this.prises = new ArrayList<Piece>();
        this.historique = new ArrayList<Case>();
        this.echiquier = new Echiquier();
    	this.echiquier.initialisationEchiquier();
        this.setRois();
		
	}
	
	public void jouer() {
		
		Scanner input = new Scanner(System.in);
		System.out.print( " Veuillez saisir le Nom du Joueur n°1 : " );
        String a = input.nextLine();
        System.out.println(" " +  a + " vous êtes le Joueur Blanc ! " );
        System.out.print( " Veuillez saisir le Nom du Joueur n°2 : " );
        String b = input.nextLine();
        System.out.println(" "+ b + " vous êtes le Joueur Noir !" );
        this.joueurBlanc.setNom(a);
        this.joueurNoir.setNom(b);
        this.joueurAuTrait = this.getJoueurBlanc();
        this.echiquier.affiche();
		System.out.println( " Au joueur " + this.getJoueurBlanc().getNom() + " de commencer !"  );
		while((this.getRoiNoir().estEchec() != true) && (this.getRoiBlanc().estEchec() != true))
		{
			System.out.println( "\n "  );
			System.out.println( " Au tour du joueur " + this.getJoueurAuTrait().getNom() + " ! "  );
			System.out.print( " Entrer la Colonne de la Case de Depart : " );
			String dep = input.next();
			int xdep = this.getIntColonne(dep);
			System.out.print( " Entrer la Ligne de la Case de Depart : " );
			int ydep = input.nextInt();
			System.out.print( " Entrer la Colonne de la Case d'Arrivee : " );
			String arr = input.next();
			int xarr = this.getIntColonne(arr);
			System.out.print( " Entrer la Ligne de la Case d'Arrivee : " );
			int yarr = input.nextInt();
			
			if(this.getEchiquier().echiquier[xdep-1][ydep-1].getPiece() != null) {
				this.tourDeJeu(xdep, ydep, xarr, yarr);
				this.historique.add(this.getEchiquier().echiquier[xdep-1][ydep-1]);
				this.historique.add(this.getEchiquier().echiquier[xarr-1][yarr-1]);
				this.afficherHistorique();
			}else { System.out.println(" Erreur la case de Départ selectionée est vide");}
		}
		if(this.getRoiNoir().estEchec() == true)
			System.out.println(" Fin de la partie , le joueur Blanc " + this.getJoueurBlanc().getNom() + " à gagner ! ");
		else
			System.out.println(" Fin de la partie , le joueur Noir " + this.getJoueurNoir().getNom() + " à gagner ! ");
	}
	
	public void switchJoueurAuTrait(){
		if(this.getJoueurAuTrait() == this.getJoueurBlanc())
			this.joueurAuTrait = this.getJoueurNoir();
		else
			this.joueurAuTrait = this.getJoueurBlanc();
		
	}
	public Joueur getJoueurBlanc()
	{
		return this.joueurBlanc ;
	}
	
	public Joueur getJoueurAuTrait()
	{
		return this.joueurAuTrait ;
	}
	
	
	public Joueur getJoueurNoir()
	{
		return this.joueurNoir ; 
	}
	
	public Echiquier getEchiquier()
	{
		return this.echiquier ;
	}
	
	public int getIntColonne(String z)
	{
		switch(z)
		{
			case "A"  : return 1 ;
			case "B"  : return 2 ;
			case "C"  : return 3 ;
			case "D"  : return 4 ;
			case "E"  : return 5 ;
			case "F"  : return 6 ;
			case "G"  : return 7 ;
			case "H"  : return 8 ;
			case "a"  : return 1 ;
			case "b"  : return 2 ;
			case "c"  : return 3 ;
			case "d"  : return 4 ;
			case "e"  : return 5 ;
			case "f"  : return 6 ;
			case "g"  : return 7 ;
			case "h"  : return 8 ;
			default   : return 0 ;
		}
	}
	
	public void tourDeJeu(int xdep ,int ydep ,int xarr ,int yarr ) {
		if(this.getJoueurAuTrait().getCouleur() == this.echiquier.echiquier[xdep-1][ydep-1].getPiece().getCouleur()) {
			if (this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece().deplacementOk(this.echiquier.echiquier[xarr-1][yarr-1]) == true){
				if (this.echiquier.echiquier[xdep-1][ydep-1].getPiece().deplacementPossible(this.echiquier.echiquier[xarr-1][yarr-1]) == true) {
					if(this.echiquier.getCase(this.echiquier.echiquier[xarr-1][yarr-1]).getPiece() != null ) {
						this.prises.add(this.echiquier.echiquier[xarr-1][yarr-1].getPiece());
						this.echiquier.placerPiece(xarr-1, yarr-1, this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece());
						this.echiquier.placerPiece(xdep-1, ydep-1, null);
						this.switchJoueurAuTrait();
						this.echiquier.affiche();
						this.afficherPrises();
						
					}else {
						this.echiquier.placerPiece(xarr-1, yarr-1, this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece());
						this.echiquier.placerPiece(xdep-1, ydep-1, null);
						this.switchJoueurAuTrait();
						this.echiquier.affiche();
						
					}
				}else System.out.println(" Deplacement impossible !");
			}else System.out.println("Deplacement impossible !");
		}else {
			System.out.println("ce n'est pas ton tour, attend que ton adversaire ai jouer !");
			System.out.println(this.joueurAuTrait.getNom() + " Rejouer !");
			
		}
		
	}
	
	
	public void afficherPrises(){
		System.out.print(" Liste des pièces prises : [");
		for(int i=0; i<prises.size(); i++){
			if(prises.get(i).getCouleur() == true) {
				System.out.print(prises.get(i).getNom() +" Blanc, ");
			}else {
				System.out.print(prises.get(i).getNom() +" Noir, ");
			}
		}
		System.out.println("... ]");
	}
	
	public void afficherHistorique(){
		System.out.print(" Liste des derniers coups : [");
		for(int i=0; i<historique.size(); i++){
			if( i % 2 == 0) {
				System.out.print(historique.get(i).getNomColonne());
				System.out.print(historique.get(i).getLigne()+ "-");
			}
			else {
				System.out.print(historique.get(i).getNomColonne());
				System.out.print(historique.get(i).getLigne()+ ", ");
			}
		}
		System.out.println(" ...]");
	}
	
	
	
	public void setRois(){
    	for(int i = 0; i < this.getEchiquier().echiquier.length; i++){
    		for(int j = 0; j < this.getEchiquier().echiquier[i].length; j++){
    			if(this.getEchiquier().echiquier[i][j].getPiece() != null && this.getEchiquier().echiquier[i][j].getPiece().getNom() == "Roi"){
    				if(this.getEchiquier().echiquier[i][j].getPiece().getCouleur() == false){
    					this.roiNoir = (Roi)this.getEchiquier().echiquier[i][j].getPiece();
    				}else if(this.getEchiquier().echiquier[i][j].getPiece().getCouleur() == true){
    					this.roiBlanc = (Roi)this.getEchiquier().echiquier[i][j].getPiece();
    				}
    			}
    		}
    	}
    }
	
	public Roi getRoiBlanc() {
		return this.roiBlanc; 
	}
	
	public Roi getRoiNoir() {
		return this.roiNoir;
	}
	
	
}

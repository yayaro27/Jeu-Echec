package Jeu;

import Save.Historique;
import Piece.Roi;
import java.util.Scanner;
import Plateau.Echiquier;
import Plateau.Case;
import Piece.Piece;
import Piece.Pion;
import Piece.Roi;
import Piece.Fou;
import Piece.Dame;
import Piece.Tour;
import Piece.Cavalier;
import java.util.ArrayList;

public class Partie {
	
	private Echiquier echiquier;
	private ArrayList<Piece> prises;
	private Joueur joueurBlanc;
	private Joueur joueurNoir;
	private Joueur joueurAuTrait;
	private Roi roiNoir;
	private Roi roiBlanc;
	private Historique historique;
	
	//constructeur de la partie
	public Partie()
	{
		this.echiquier = null;
        this.joueurBlanc = null;
        this.joueurNoir = null;
        this.joueurAuTrait = null;
        this.prises = null;
       
	}
	
	//initialise les attributs et crée un echiquier rempli
	public void initialiser() {
        this.joueurBlanc = new Joueur("", true);
        this.joueurNoir = new Joueur("", false);
        this.joueurAuTrait = this.getJoueurBlanc();
        this.prises = new ArrayList<Piece>();
        this.historique = new Historique();
        this.echiquier = new Echiquier();
    	this.echiquier.initialisationEchiquier();
        this.setRois();
		
	}
	
	//permet de jouer une partie jusqu'a ce q'un echec est lieu
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
		System.out.println( " Au joueur des pieces blanches de commencer !"  );
		while((this.estMATP1() != true))
		{
			if(this.roiBlanc.estEchec() == true) {
				System.out.println(" Le joueur " + this.joueurBlanc.getNom() + " est en echec !!!");
			}
			if(this.roiNoir.estEchec() == true) {
				System.out.println(" Le joueur " + this.joueurNoir.getNom() + " est en echec !!!");
			}
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
			}else { System.out.println(" Erreur la case de Départ selectionée est vide");}
		}
		if(this.getRoiNoir().estEchec() == true)
			System.out.println(" Fin de la partie , le joueur Blanc " + this.getJoueurBlanc().getNom() + " à gagner ! ");
		else
			System.out.println(" Fin de la partie , le joueur Noir " + this.getJoueurNoir().getNom() + " à gagner ! ");
	}


	//permet de voir si les cases accessible au roi sont sucesptible de le mettre en echec.
	public boolean estMATP1(){
		ArrayList<Case> a =new ArrayList<Case>();
		ArrayList<Piece> atester1 = this.getEchiquier().getAllPieceBlanche();
		ArrayList<Piece> atester2 = this.getEchiquier().getAllPieceNoire();
		if(this.getRoiNoir().estEchec() != true && this.getRoiBlanc().estEchec() != true ) {
			return false;
		}
		if(this.getRoiNoir().estEchec() == true ) {
	    	for(Piece pi : atester1){
	    		for(int i = 0 ; i<this.getRoiNoir().CasesPossibles().size() ; i++) {
	    			if(pi.deplacementOk(this.getRoiNoir().CasesPossibles().get(i)) == true && pi.deplacementPossible(this.getRoiNoir().CasesPossibles().get(i))) {
	    				a.add(this.getRoiNoir().CasesPossibles().get(i));
	    			}
	    			if(pi.getCase() == this.roiNoir.CasesPossibles().get(i)) {
	    				a.add(this.getRoiNoir().CasesPossibles().get(i));
	    			}
	    			
	    		}	
	    		
	    	}
	    	if(a.size() != this.getRoiNoir().CasesPossibles().size()) {
	    		return false;
	    	}
		}
		if(this.getRoiBlanc().estEchec() == true ) {
	    	for(Piece pi : atester2){
	    		for(int i = 0 ; i<this.getRoiBlanc().CasesPossibles().size() ; i++) {
	    			if(pi.deplacementOk(this.getRoiBlanc().CasesPossibles().get(i)) == true && pi.deplacementPossible(this.getRoiBlanc().CasesPossibles().get(i))) {
	    				a.add(this.getRoiBlanc().CasesPossibles().get(i));
	    			}
	    			if(pi.getCase() == this.roiBlanc.CasesPossibles().get(i)) {
	    				a.add(this.getRoiBlanc().CasesPossibles().get(i));
	    			}
	    			
	    		}	
	    		
	    	}
	    	if(a.size() != this.getRoiBlanc().CasesPossibles().size()) {
	    		return false;
	    	}
		}
		return true;
	}
	 
	//permet la promotion d'un pion en une autre piece s'il atteint la derniere ligne du camp adreverse
	public void Promotion(Case c2){
		if(c2.getPiece().isPromotion())
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println(" Vous pouvez promouvoir votre pion en position " + c2.getNomColonne() + c2.getLigne() + " en quel pièce voulez vous transformer votre pion ?" );
	        System.out.println(" Dame(1) ou Fou(2) ou Tour(3) ou Cavalier(4)");
	        int choix = sc.nextInt();
	        while (choix != 1 && choix != 2 && choix != 3 && choix != 4) 
	        {
	            System.out.println("Veuillez entrer un numero de piece valide(Dame(1) ou Fou(2) ou Tour(3) ou Cavalier(4))");
	            choix = sc.nextInt();
	        }
	        String choix1 = " ";
	        if      (choix == 1) {choix1 = "Dame" ;   this.getEchiquier().placerPiece(c2.getColonne()-1, c2.getLigne()-1, new Dame(c2.getPiece().getCouleur(), this.getEchiquier()));}
	        else if (choix == 2) {choix1 = "Fou";     this.getEchiquier().placerPiece(c2.getColonne()-1, c2.getLigne()-1, new Fou(c2.getPiece().getCouleur(), this.getEchiquier()));}
	        else if (choix == 3) {choix1 = "Tour" ;   this.getEchiquier().placerPiece(c2.getColonne()-1, c2.getLigne()-1, new Tour(c2.getPiece().getCouleur(), this.getEchiquier()));}
	        else if (choix == 4) {choix1 = "Cavalier";this.getEchiquier().placerPiece(c2.getColonne()-1, c2.getLigne()-1,  new Cavalier(c2.getPiece().getCouleur(), this.getEchiquier()));}
	        
	        
	        System.out.println("Votre pion a bien été changé en " + choix1);
	    }
    }
	

		

	//(Non fonctionnelle pour le moment !!) Test ayant pour but de voir si une piece peut s'interposer entre le roi et la piece qui met en echec le roi.
	public boolean estMATP2(){
		ArrayList<Piece> atester1 = this.getEchiquier().getAllPieceBlanche();
		ArrayList<Piece> atester2 = this.getEchiquier().getAllPieceNoire();
		if(this.getRoiNoir().estEchec() == true ) {
			for(int i = 0 ; i<this.getRoiNoir().QuiEchecRoi().size(); i++) {
				for(int j = 0 ; j<this.getRoiNoir().QuiEchecRoi().get(i).CasesPossibles().size(); j++) {
					for(Piece pi : atester2){
						if(pi.deplacementOk(this.getRoiNoir().QuiEchecRoi().get(i).CasesPossibles().get(j)) == true && pi.deplacementPossible(this.getRoiNoir().QuiEchecRoi().get(i).CasesPossibles().get(j)) == true) {
							this.getEchiquier().placerPiece(this.getRoiNoir().QuiEchecRoi().get(i).CasesPossibles().get(j).getColonne()-1, this.getRoiNoir().QuiEchecRoi().get(i).CasesPossibles().get(j).getLigne()-1, pi);
							if(this.getRoiNoir().estEchec() != true ) {
								this.getEchiquier().affiche();
								this.getEchiquier().placerPiece(pi.getCase().getColonne()-1,pi.getCase().getLigne()-1,null);
								this.getEchiquier().affiche();
								return false;		
							}else {
								this.getEchiquier().placerPiece(pi.getCase().getColonne()-1,pi.getCase().getLigne()-1,null);
							}
						}
					}	
				}
			}
		}
		if(this.getRoiBlanc().estEchec() == true ) {
				for(int i = 0 ; i<this.getRoiBlanc().QuiEchecRoi().size(); i++) {
					for(int j = 0 ; j<this.getRoiBlanc().QuiEchecRoi().get(i).CasesPossibles().size(); j++) {
						for(Piece pi : atester1){
							if(pi.deplacementOk(this.getRoiBlanc().QuiEchecRoi().get(i).CasesPossibles().get(j)) && pi.deplacementPossible(this.getRoiBlanc().QuiEchecRoi().get(i).CasesPossibles().get(j))) {
								this.getEchiquier().placerPiece(this.getRoiBlanc().QuiEchecRoi().get(i).CasesPossibles().get(j).getColonne()-1, this.getRoiBlanc().QuiEchecRoi().get(i).CasesPossibles().get(j).getLigne()-1, pi);
								if(this.getRoiBlanc().estEchec() != true ) {
									this.getEchiquier().affiche();
									this.getEchiquier().placerPiece(pi.getCase().getColonne()-1,pi.getCase().getLigne()-1,null);
									this.getEchiquier().affiche();
									return false;		
								}else {
									this.getEchiquier().placerPiece(pi.getCase().getColonne()-1,pi.getCase().getLigne()-1,null);
								}
							}
						}
					}
				}
		}
		return true;
	}
	
	
	
	//permet de changer le joueurAuTrait
	public void switchJoueurAuTrait(){
		if(this.getJoueurAuTrait() == this.getJoueurBlanc())
			this.joueurAuTrait = this.getJoueurNoir();
		else
			this.joueurAuTrait = this.getJoueurBlanc();
		
	}
	
	//recupere le JoueurBlanc
	public Joueur getJoueurBlanc()
	{
		return this.joueurBlanc ;
	}
	//recupere le JoueurAuTrait
	public Joueur getJoueurAuTrait()
	{
		return this.joueurAuTrait ;
	}
	
	//recupere le JoueurNoir
	public Joueur getJoueurNoir()
	{
		return this.joueurNoir ; 
	}
	//recupere l'echiquier
	public Echiquier getEchiquier()
	{
		return this.echiquier ;
	}
	 //prend une lettre qui dessigne une colonne et la change en int
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
	
	// permet de deplacer une piece si c'est bien une piece du joueur au trait, et que le deplacementOk et deplacementPossible de la piece le permet. 
	public void tourDeJeu(int xdep ,int ydep ,int xarr ,int yarr ) {
		if (xdep < 1 || xdep>8 || ydep<1|| ydep>8 ||xarr <1 ||xarr>8 || yarr<1 || yarr>8 ) {
			System.out.println(" Erreur dans les coordonnées rentrées");
		}
		else
		if(this.getJoueurAuTrait().getCouleur() == this.echiquier.echiquier[xdep-1][ydep-1].getPiece().getCouleur()) {
			if (this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece().deplacementOk(this.echiquier.echiquier[xarr-1][yarr-1]) == true){
				if (this.echiquier.echiquier[xdep-1][ydep-1].getPiece().deplacementPossible(this.echiquier.echiquier[xarr-1][yarr-1]) == true) {
					if(this.echiquier.getCase(this.echiquier.echiquier[xarr-1][yarr-1]).getPiece() != null ) {
						this.prises.add(this.echiquier.echiquier[xarr-1][yarr-1].getPiece());
						this.historique.addCase(this.getEchiquier().echiquier[xdep-1][ydep-1]);
						this.historique.addCase(this.getEchiquier().echiquier[xarr-1][yarr-1]);
						this.echiquier.placerPiece(xarr-1, yarr-1, this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece());
						this.echiquier.placerPiece(xdep-1, ydep-1, null);
						this.Promotion(this.getEchiquier().echiquier[xarr-1][yarr-1]);
						this.switchJoueurAuTrait();
						this.echiquier.affiche();
						this.historique.afficherHistorique();
						this.afficherPrises();
						
					}else {
						this.historique.addCase(this.getEchiquier().echiquier[xdep-1][ydep-1]);
						this.historique.addCase(this.getEchiquier().echiquier[xarr-1][yarr-1]);
						this.echiquier.placerPiece(xarr-1, yarr-1, this.echiquier.getCase(this.echiquier.echiquier[xdep-1][ydep-1]).getPiece());
						this.echiquier.placerPiece(xdep-1, ydep-1, null);
						this.Promotion(this.getEchiquier().echiquier[xarr-1][yarr-1]);
						this.switchJoueurAuTrait();
						this.echiquier.affiche();
						this.historique.afficherHistorique();
						
					}
				}else System.out.println(" Deplacement impossible !");
			}else System.out.println(" Deplacement impossible !");
		}else {
			System.out.println(" ce n'est pas ton tour, attend que ton adversaire ai jouer !");
			System.out.println(this.joueurAuTrait.getNom() + " Rejouer !");
			
		}
		
	}
	
	// Permet d'afficher une liste des pieces prise lors de la partie
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
	

	// Permet de recuperer les rois de la partie blanc et noir
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
	
	//recupere l'historique de la partie
	public Historique getHistorique() {
		return this.historique;
	}
	
	//test qui permet de prendre le fichier charger et de mettre les strings lues dans une case
	public void ChargeCase(String str) {
		Partie p = new Partie();
		p.initialiser();
		Scanner scan = new Scanner(str);
		scan.useDelimiter(" ");
		String a = scan.next();
		int b =  scan.nextInt(); 
		String c = scan.next();
		p.getEchiquier().placerPiece( this.getIntColonne(a)-1, b-1, this.getEchiquier().getNewP(c));
		scan.close();
		
	
	}
	
	//recupere le roi blanc de la partie
	public Roi getRoiBlanc() {
		return this.roiBlanc; 
	}
	//recupere le roi noir de la partie
	public Roi getRoiNoir() {
		return this.roiNoir;
	}
	
	
}

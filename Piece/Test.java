package Piece;


 
import Plateau.Echiquier;
import Jeu.Partie;

public class Test
{

		public static void main(String[] args)
		{
			Partie p = new Partie();
			p.initialiser();
			//p.jouer();
			//p.getEchiquier().affiche();
			p.getEchiquier().placerPiece(7, 3, new Dame(false,p.getEchiquier()));
			p.getEchiquier().placerPiece(5, 1, null);
			//p.getEchiquier().placerPiece(3, 0, null);
			//p.getEchiquier().placerPiece(3, 6, null);
			//p.getEchiquier().placerPiece(0, 3, new Fou(true,p.getEchiquier()));
			//p.getEchiquier().placerPiece(4, 6, null);
			p.getEchiquier().affiche();
		
			System.out.println(p.estMATP2());
			
			
			
			
		}
}
	

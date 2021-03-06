package Save;

import java.util.ArrayList;
import Plateau.Case;

public class Historique {
	

	private ArrayList<Case> historique;
	
	public Historique() 
	{

		this.historique = new ArrayList<Case>();
	}
	//affiche l'historique des coups dans la console
	public void afficherHistorique(){
		System.out.print(" Liste des derniers coups : [");
		for(int i=0; i<historique.size(); i++){
			if( i % 2 == 0) {
				System.out.print( historique.get(i).getNomColonne() + historique.get(i).getLigne()+ "-");
			}
			else {
				System.out.print( historique.get(i).getNomColonne()  + historique.get(i).getLigne()+ ", ");

			}
		}
		System.out.println(" ...]");
	}
	//ajoute une case a la liste
	public void addCase(Case c){
		historique.add(c);
	}

}

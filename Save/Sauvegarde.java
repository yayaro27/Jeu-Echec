package Save;

import java.util.ArrayList;
import Piece.Piece;
import Plateau.Case;
import Jeu.Partie;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sauvegarde {
	
	private ArrayList<Case> liste;
	
	public Sauvegarde() {
	this.liste = new ArrayList<Case>();
	}
	
	//Test de la sauvegarde d'une partie  dans un fichier
	public void sauver(String nomFichier , Partie p ) {
		try {
				this.liste = p.getEchiquier().getAllCases();
			   File file = new File(nomFichier);

			   // créer le fichier s'il n'existe pas ou le remplace s'il existe deja
			   if (!file.exists()) {
				file.delete();  
			    file.createNewFile();
			   }

			   FileWriter fw = new FileWriter(file.getAbsoluteFile());
			   BufferedWriter bw = new BufferedWriter(fw);
			   for (int i=0;i<this.liste.size();i++) {
			   		bw.write( " " + this.liste.get(i).getNomColonne() + " " + this.liste.get(i).getLigne() + " " + this.liste.get(i).getPiece().getNomSave()+"\n");
			   }
			   bw.close();

			   System.out.println("Modification terminée!");

			  } 
		catch (IOException e) {
			   e.printStackTrace();
		}
	}
	
	//Test d'un chargement d'un fichier
	public void charger(String nomFichier) {
		try {
			Partie p = new Partie();
			p.initialiser();
			System.out.println(nomFichier);
			liste = new ArrayList<Case>();
 
			BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier));
			String ligne;
 
			ligne = br.readLine();
			while (ligne != null) {
				p.ChargeCase(ligne);
				ligne = br.readLine();
				p.jouer();
			}
 
			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}

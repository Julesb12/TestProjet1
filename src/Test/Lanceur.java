package Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Lanceur {

	public static void main(String[] args) throws Exception {

		String nom;
		String prenom;
		String dpt;
		String promo;
		String annee;

		// FileReader pour lire dans un fichier texte
		// ouvre un flux entrant du fichier vers le code
		FileReader fr = new FileReader("C:\\Users\\biasj\\eclipse-workspace\\TestPourProjet1\\STAGIAIRES.DON");
		try (// BufferedReader objet plus simple pour lire
				BufferedReader br = new BufferedReader(fr)) {
			// tant qu'il y a quelque chose à lire
			while (br.ready()) {

				nom = br.readLine();
				prenom = br.readLine();
				dpt = br.readLine();
				promo = br.readLine();
				annee = br.readLine();
				br.readLine();

				Stagiaire stagiaire = new Stagiaire(nom, prenom, dpt, promo, annee);
				System.out.println(stagiaire);
			}
		}

	}
}

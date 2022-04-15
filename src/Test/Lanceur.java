package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
//import java.util.Scanner;
import java.util.Scanner;

public class Lanceur {

	public static void main(String[] args) throws Exception {

		String nom;
		String prenom;
		String dpt;
		String promo;
		String annee;
		
//		String nomStagiaire="LACROIX";
//		String PrenomStagiaire="Pascal";
//		String promoStagiaire =" BOBI 5";
//		String dptStagiaire;
//		
		
		Noeud annuaire = new Noeud(null);
		int nmbcriter = 0;

		// FileReader pour lire dans un fichier texte
		// ouvre un flux entrant du fichier vers le code
		FileReader fr = new FileReader("C:\\Users\\biasj\\eclipse-workspace\\TestPourProjet1\\STAGIAIRES.DON");
		//Scanner saisi = new Scanner(System.in);
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

				// appel methode ajout dans l'abre
				annuaire.ajouterStagiaire(stagiaire);

				// affiche la liste de stagiaires
				// System.out.println(stagiaire);

				
			}
			br.close();
			fr.close();
		}
		
//		List<Stagiaire>stagiaires = new ArrayList<>();
//		System.out.println(annuaire.rechercherNom(dptStagiaire, anneePromo, stagiaires));
		
		List<Stagiaire>stagiaires = new ArrayList<>();
		//System.out.println(annuaire.rechercheAvecDeuxCriteres(nomStagiaire,PrenomStagiaire ,stagiaires));
		System.out.println(annuaire.rechercheChoix(nmbcriter, stagiaires));
	}

	
			// System.out.println(annuaire);

			// System.out.println(annuaire.rechercherPromo(promoStagiaire));

//		List<Stagiaire> stagiaires = new ArrayList<>();
//		
//		System.out.println(annuaire.rechercherPromo(promoStagiaire, stagiaires));
//			

//			List<Stagiaire> promotion = new ArrayList<>();
//			System.out.println(annuaire.rechercherPromo("AI 56",promotion));
////			

//			List<Stagiaire> stagiaires = new ArrayList<>();
//		System.out.println(annuaire.rechercherNom(dptStagiaire, anneePromo, stagiaires));

//			List<Stagiaire> stagiaires = new ArrayList<>();
//		System.out.println(annuaire.rechercherprenomStagiaire(promoStagiaire,stagiaires));

		

		// System.out.println(annuaire.rechercheNom("Idir"));


	


}

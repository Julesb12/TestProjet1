package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Lanceur {

	public static void main(String[] args) throws Exception {

		String nom;
		String prenom;
		String dpt;
		String promo;
		String annee;
		String anneePromo;
		String dptStagiaire;
		

		// FileReader pour lire dans un fichier texte
		// ouvre un flux entrant du fichier vers le code
		FileReader fr = new FileReader("C:\\Users\\biasj\\eclipse-workspace\\TestPourProjet1\\STAGIAIRES.DON");
		
		try (Scanner saisi = new Scanner(System.in)) {
			
			System.out.println(" Vous recherchez les stagiaires de quel département ? \n");
			dptStagiaire = saisi.next();
			
			
			//System.out.println(" quelle année recherchez-vous? \n");
			//anneePromo = saisi.next();
			
		}
		System.out.println("Liste des stagiaire originaire du département :"+ " "+dptStagiaire);
		
		//System.out.println(" liste des stagiaires de : "+anneePromo +" \n");
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
				
				
				//System.out.println(stagiaire);
				
				
				
				if(stagiaire.getDpt().equals(dptStagiaire)) {
					
					System.out.println(stagiaire.getNom()+ " " + stagiaire.getPrenom() +" "+ stagiaire.getAnnee());
				}
				
				//rechercher pas année
//				if(stagiaire.getAnnee().equals(anneePromo)) {
//					
//					System.out.println(stagiaire.getNom()+ " " + stagiaire.getPrenom());
//				}
				
				//rechercher avec année et departement
//				if(stagiaire.getAnnee().equals("2011")&& (stagiaire.getDpt().equals("91"))) {
//					System.out.println(" liste des élèves de 2011 du departement 91 \n");
//					System.out.println(stagiaire.getNom()+ " " + stagiaire.getPrenom());
//				}
				
			}
		}

	}
}

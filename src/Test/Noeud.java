package Test;

import java.util.List;
import java.util.Scanner;

public class Noeud {
	// Attributs
	private Stagiaire stagiaire; // clé
	private Noeud filsGauche;
	private Noeud filsDroit;
	String dept;

	// Constructeurs
	public Noeud(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	// Getters & Setters
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Noeud getFilsGauche() {
		return filsGauche;
	}

	public void setFilsGauche(Noeud filsGauche) {
		this.filsGauche = filsGauche;
	}

	public Noeud getFilsDroit() {
		return filsDroit;
	}

	public void setFilsDroit(Noeud filsDroit) {
		this.filsDroit = filsDroit;
	}

	public String toString() {
		// GND
		String resultat = "";
		if (this.filsGauche != null) {
			resultat += this.filsGauche.toString(); // G
		}

		resultat += this.stagiaire; // N

		if (this.filsDroit != null) {
			resultat += this.filsDroit.toString(); // D
		}
		return resultat;
	}

	public void ajouterStagiaire(Stagiaire stagiaireAAjouter) {

		if (this.stagiaire == null) {
			this.stagiaire = stagiaireAAjouter;

		} else {

			if (this.stagiaire.getNom().compareTo(stagiaireAAjouter.getNom()) > 0) {

				if (this.filsGauche == null) {
					this.filsGauche = new Noeud(stagiaireAAjouter);
				} else {
					this.filsGauche.ajouterStagiaire(stagiaireAAjouter);
				}

			} else if (this.stagiaire.getNom().compareTo(stagiaireAAjouter.getNom()) < 0) {
				if (this.filsDroit == null) {
					this.filsDroit = new Noeud(stagiaireAAjouter);
				} else {
					this.filsDroit.ajouterStagiaire(stagiaireAAjouter);
				}
			}

		}
	}

	// methode pour rechercher par departement
	public List<Stagiaire> rechercheDepartementStagiaire(String dptStagiaire, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheDepartementStagiaire(dptStagiaire, stagiaires);
		}
		if ((this.stagiaire.getDpt().equals(dptStagiaire))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercheDepartementStagiaire(dptStagiaire, stagiaires);
		}

		return stagiaires;
	}

	// methode pour rechercher un stagiaire par son nom

	public List<Stagiaire> rechercheNom(String NomARechercher, List<Stagiaire> stagiaires) {

		if (this.stagiaire.getNom().equals(NomARechercher)) {
			stagiaires.add(this.getStagiaire());
		} // je pars à gauche
		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheNom(NomARechercher, stagiaires);
		}
		// je pars à droite
		if (this.filsDroit != null) {

			stagiaires = this.filsDroit.rechercheNom(NomARechercher, stagiaires);
		}

		return stagiaires;
	}

	public List<Stagiaire> rechercherprenomStagiaire(String prenomStagiaire, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercherprenomStagiaire(prenomStagiaire, stagiaires);

		}
		if ((this.stagiaire.getPrenom().equals(prenomStagiaire))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercherprenomStagiaire(prenomStagiaire, stagiaires);
		}
		return stagiaires;
	}

	public List<Stagiaire> rechercherAnnee(String anneePromo, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercherAnnee(anneePromo, stagiaires);

		}
		if ((this.stagiaire.getAnnee().equals(anneePromo))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercherAnnee(anneePromo, stagiaires);
		}
		return stagiaires;
	}

	// methode pour rechercher avec le departement et l'année

	public List<Stagiaire> rechercheDptAnnee(String dptRecherche, String anneeRecherchee, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheDptAnnee(dptRecherche, anneeRecherchee, stagiaires);
		}
		if ((this.stagiaire.getAnnee().equals(anneeRecherchee)) && (this.stagiaire.getDpt().equals(dptRecherche))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercheDptAnnee(dptRecherche, anneeRecherchee, stagiaires);
		}
		return stagiaires;
	}

	// méthode recherche avec nom et année
	public List<Stagiaire> rechercheNomAnnee(String nomStagiaire, String anneeRecherchee, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheDptAnnee(nomStagiaire, anneeRecherchee, stagiaires);
		}
		if ((this.stagiaire.getNom().equals(nomStagiaire)) && (this.stagiaire.getAnnee().equals(anneeRecherchee))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercheDptAnnee(nomStagiaire, anneeRecherchee, stagiaires);
		}
		return stagiaires;
	}

	public List<Stagiaire> rechercheNomPromo(String promoStagiaire, String nomStagiaire, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheNomPromo(nomStagiaire, promoStagiaire, stagiaires);
		}
		if ((this.stagiaire.getNom().equals(nomStagiaire)) && (this.stagiaire.getPromo().equals(promoStagiaire))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercheDptAnnee(nomStagiaire, promoStagiaire, stagiaires);
		}
		return stagiaires;
	}

	// methode pour rechercher avec deux critères

	public List<Stagiaire> rechercheAvecDeuxCriteres(String element1, String element2, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercheAvecDeuxCriteres(element1, element2, stagiaires);
		}
		if ((this.stagiaire.getNom().equals(element1)) && (this.stagiaire.getPrenom().equals(element2))) {
			stagiaires.add(this.getStagiaire());
		} else if ((this.stagiaire.getNom().equals(element1)) && (this.stagiaire.getDpt().equals(element2))) {
			stagiaires.add(this.getStagiaire());
		} else if ((this.stagiaire.getPrenom().equals(element1)) && (this.stagiaire.getAnnee().equals(element2))) {
			stagiaires.add(this.getStagiaire());
		} else if ((this.stagiaire.getPromo().equals(element1)) && (this.stagiaire.getPrenom().equals(element2))) {
			stagiaires.add(this.getStagiaire());
		} else if ((this.stagiaire.getDpt().equals(element1)) && (this.stagiaire.getPrenom().equals(element2))) {
			stagiaires.add(this.getStagiaire());
		}
//		}else if((this.stagiaire.getAnnee().equals(element1))&&(this.stagiaire.getPrenom().equals(element2))) {
//			stagiaires.add(this.getStagiaire());
		// }

		if (this.filsDroit != null) { // je pars à droite

			stagiaires = this.filsDroit.rechercheAvecDeuxCriteres(element1, element2, stagiaires);
		}
		return stagiaires;
	}

//		public List<Stagiaire> rechercherPromo(String promoRecherchee, List<Stagiaire> promotion) {
//			
//			if (this.stagiaire.getPromo().equals(promoRecherchee)) {
//				
//				promotion.add(stagiaire);
//			}  
//			 
//				if (this.filsGauche != null) {// je pars à gauche
//	
//				promotion = this.filsGauche.rechercherPromo(promoRecherchee, promotion);
//
//				}
//				
//				// je pars à droite
//				if (this.filsDroit != null){
//					promotion = this.filsDroit.rechercherPromo(promoRecherchee, promotion);
//					//promotion.add(stagiaire);
//				}
//			
//			return promotion;
//		}
//	
//		

	public List<Stagiaire> rechercheChoix(int nmbCritere, List<Stagiaire> stagiaires) {

		String nomT = "BIAS";
		String prenomT = " jules d";
		String anneeT = "2005";
		String promoT = "CDA 17";
		String dptT = "38";

		String dptStagiaire = "";
		String anneeRecherchee;
		String nomStagiaire;
		String promoRecherchee;
		String prenomStagiaire;

		System.out.println("\n\tvoici la liste des critères de recherches\n\n");
		System.out.println("\t1- NOM\t 2- PRENOM\t 3-Année\t 4-PROMO\t 5-DEPARTEMENT\n");
		System.out.print(" votre recherche est basee Sur combien de critéres?\t");
		Scanner saisi = new Scanner(System.in);
		nmbCritere = saisi.nextInt();

		if (nmbCritere == 1) {
			System.out.println("\n donnez le numéros du critère \t");

			// recherche bassée sur 1 CRITERE
			String choix1 = saisi.next();

			if (choix1.equals("1")) {
				System.out.println(" Quel nom recherchez-vous?");
				nomStagiaire = saisi.next();
				rechercheNom(nomStagiaire, stagiaires);
			}
			if (choix1.equals("2")) {
				System.out.println(" Quel prénom recherchez-vous?");
				prenomStagiaire = saisi.next();
				rechercherprenomStagiaire(prenomStagiaire, stagiaires);
			}
			if (choix1.equals("3")) {
				System.out.println(" Quelle année recherchez-vous?");
				anneeRecherchee = saisi.next();

				rechercherAnnee(anneeRecherchee, stagiaires);
			}
			if (choix1.equals("4")) {
				System.out.println(" Quelle promo recherchez-vous?");
				promoRecherchee = saisi.next();
				rechercherPromo(promoRecherchee, stagiaires);
			}
			if (choix1.equals("5")) {
				System.out.println(" quel département recherchez-vous?");
				dptStagiaire = saisi.next();
				rechercheDepartementStagiaire(dptStagiaire, stagiaires);
			}
		}

		if (nmbCritere == 2) {
			System.out.println("donnez le numéro du 1er critère");
			String choix1 = saisi.next();
			System.out.println("donnez le numéro du 2eme critère");
			String choix2 = saisi.next();

			if ((choix1.equals("1") && (choix2.equals("2"))) || (choix1.equals("2") && (choix2.equals("1")))) {
				// System.out.println(nomT + " " + prenomT);
				System.out.println(" nom recherché ");
				nomStagiaire = saisi.next();
				System.out.println("prénom recherché");
				prenomStagiaire = saisi.next();
				// rechercheAvecDeuxCriteres(nomStagiaire, prenomStagiaire, stagiaires);
			}
			if ((choix1.equals("1") && (choix2.equals("3"))) || (choix1.equals("3") && (choix2.equals("1")))) {
				// System.out.println(nomT + " " + anneeT);
				System.out.print(" nom recherché ");
				nomStagiaire = saisi.next();
				System.out.print("année recherchée");
				anneeRecherchee = saisi.next();
				rechercheNomAnnee(nomStagiaire, anneeRecherchee, stagiaires);
			}
			if ((choix1.equals("1") && (choix2.equals("4"))) || (choix1.equals("4") && (choix2.equals("1")))) {
				// System.out.println(nomT + " " + promoT);
				System.out.print(" nom recherché ");
				nomStagiaire = saisi.next();
				System.out.print("promo recherchée");
				promoRecherchee = saisi.next();

				rechercheNomPromo(nomStagiaire, promoRecherchee, stagiaires);
			}
			if ((choix1.equals("1") && (choix2.equals("5"))) || (choix1.equals("5") && (choix2.equals("1")))) {
				System.out.println(nomT + " " + dptT);
			}
			if ((choix1.equals("2") && (choix2.equals("3"))) || (choix1.equals("3") && (choix2.equals("2")))) {
				System.out.println(prenomT + " " + anneeT);
			}
			if ((choix1.equals("2") && (choix2.equals("4"))) || (choix1.equals("4") && (choix2.equals("2")))) {
				System.out.println(prenomT + " " + promoT);
			}
			if ((choix1.equals("2") && (choix2.equals("5"))) || (choix1.equals("5") && (choix2.equals("2")))) {
				// System.out.println(prenomT + " " + dptT);
				System.out.print(" prénom recherché ");
				prenomStagiaire = saisi.next();
				System.out.print("département recherchée");
				dptStagiaire = saisi.next();
				// rechercheAvecDeuxCriteres(prenomStagiaire, dptStagiaire, stagiaires);
			}
			if ((choix1.equals("3") && (choix2.equals("4"))) || (choix1.equals("4") && (choix2.equals("3")))) {
				System.out.println(anneeT + " " + promoT);
			}
			if ((choix1.equals("3") && (choix2.equals("5"))) || (choix1.equals("5") && (choix2.equals("3")))) {

				System.out.println(" année recherchée ");
				anneeRecherchee = saisi.next();
				// saisi.next();
				System.out.println("departement recherché");
				dptStagiaire = saisi.next();

				rechercheDptAnnee(dptStagiaire, anneeRecherchee, stagiaires);

			}
			if ((choix1.equals("4") && (choix2.equals("5"))) || (choix1.equals("5") && (choix2.equals("4")))) {
				System.out.println(promoT + " " + dptT);
			}

		}
		if (nmbCritere == 3) {
			System.out.println("donnez le numéro du 1er critère");
			String choix1 = saisi.next();
			System.out.println("donnez le numéro du 2eme critère");
			String choix2 = saisi.next();
			System.out.println("donnez le numéro du 3eme critère");
			String choix3 = saisi.next();

			if (((choix1.equals("1") && (choix2.equals("2"))) && (choix3.equals("3")))
					|| ((choix1.equals("2") && (choix2.equals("3"))) && (choix3.equals("1")))
					|| ((choix1.equals("3") && (choix2.equals("1"))) && (choix3.equals("2")))
					|| ((choix1.equals("1") && (choix2.equals("3"))) && (choix3.equals("2")))
					|| ((choix1.equals("2") && (choix2.equals("1"))) && (choix3.equals("3")))
					|| ((choix1.equals("3") && (choix2.equals("2"))) && (choix3.equals("1")))) {
				System.out.println("nom prenom annee");
			}
			if (((choix1.equals("1")) && (choix2.equals("2")) && (choix3.equals("4")))
					|| ((choix1.equals("2")) && (choix2.equals("4")) && (choix3.equals("1")))
					|| ((choix1.equals("4")) && (choix2.equals("1")) && (choix3.equals("2")))
					|| ((choix1.equals("1")) && (choix2.equals("4")) && (choix3.equals("2")))
					|| ((choix1.equals("2")) && (choix2.equals("1")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("2")) && (choix3.equals("4")))) {
				System.out.println("nom prenom promo");
			}
			if (((choix1.equals("1")) && (choix2.equals("2")) && (choix3.equals("5")))
					|| ((choix1.equals("2")) && (choix2.equals("5")) && (choix3.equals("1")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("2")))
					|| ((choix1.equals("1")) && (choix2.equals("5")) && (choix3.equals("2")))
					|| ((choix1.equals("2")) && (choix2.equals("1")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("1")))) {
				System.out.println("nom prenom dpt");
			}
			if (((choix1.equals("1")) && (choix2.equals("3")) && (choix3.equals("4")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("1")))
					|| ((choix1.equals("4")) && (choix2.equals("1")) && (choix3.equals("3")))
					|| ((choix1.equals("1")) && (choix2.equals("4")) && (choix3.equals("3")))
					|| ((choix1.equals("3")) && (choix2.equals("1")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("3")) && (choix3.equals("1")))) {
				System.out.println("nom annee promo");
			}
			if (((choix1.equals("1")) && (choix2.equals("4")) && (choix3.equals("5")))
					|| ((choix1.equals("4")) && (choix2.equals("5")) && (choix3.equals("1")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("4")))
					|| ((choix1.equals("1")) && (choix2.equals("5")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("1")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("4")) && (choix3.equals("1")))) {
				System.out.println("nom  promo dpt");
			}
			if (((choix1.equals("2")) && (choix2.equals("3")) && (choix3.equals("4")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("2")))
					|| ((choix1.equals("4")) && (choix2.equals("2")) && (choix3.equals("3")))
					|| ((choix1.equals("2")) && (choix2.equals("4")) && (choix3.equals("3")))
					|| ((choix1.equals("3")) && (choix2.equals("2")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("3")) && (choix3.equals("2")))) {
				System.out.println("prenom annee promo");
			}
			if (((choix1.equals("2")) && (choix2.equals("3")) && (choix3.equals("5")))
					|| ((choix1.equals("3")) && (choix2.equals("5")) && (choix3.equals("2")))
					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("3")))
					|| ((choix1.equals("2")) && (choix2.equals("5")) && (choix3.equals("3")))
					|| ((choix1.equals("3")) && (choix2.equals("2")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("3")) && (choix3.equals("2")))) {
				System.out.println("prenom annee dpt");
			}
			if (((choix1.equals("2")) && (choix2.equals("4")) && (choix3.equals("5")))
					|| ((choix1.equals("4")) && (choix2.equals("5")) && (choix3.equals("2")))
					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("4")))
					|| ((choix1.equals("2")) && (choix2.equals("5")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("2")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("4")) && (choix3.equals("2")))) {
				System.out.println("prenom  promo dpt");
			}
			if (((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("5")))
					|| ((choix1.equals("3")) && (choix2.equals("5")) && (choix3.equals("4")))
					|| ((choix1.equals("4")) && (choix2.equals("5")) && (choix3.equals("3")))
					|| ((choix1.equals("4")) && (choix2.equals("3")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("3")) && (choix3.equals("4")))
					|| ((choix1.equals("5")) && (choix2.equals("4")) && (choix3.equals("3")))) {
				System.out.println(" annee promo dpt");
			}
			if (((choix1.equals("1")) && (choix2.equals("3")) && (choix3.equals("5")))
					|| ((choix1.equals("3")) && (choix2.equals("5")) && (choix3.equals("1")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("3")))
					|| ((choix1.equals("1")) && (choix2.equals("5")) && (choix3.equals("3")))
					|| ((choix1.equals("3")) && (choix2.equals("1")) && (choix3.equals("5")))
					|| ((choix1.equals("5")) && (choix2.equals("3")) && (choix3.equals("1")))) {
				System.out.println(" nom année dpt");
			}

		}
		if (nmbCritere == 4) {
			System.out.println("donnez le numéro du 1er critère");
			String choix1 = saisi.next();
			System.out.println("donnez le numéro du 2eme critère");
			String choix2 = saisi.next();
			System.out.println("donnez le numéro du 3eme critère");
			String choix3 = saisi.next();
			System.out.println("donnez le numéro du 4eme critère");
			String choix4 = saisi.next();

			if (((choix1.equals("1")) && (choix2.equals("2")) && (choix3.equals("3")) && (choix4.equals("4")))
					|| ((choix1.equals("2")) && (choix2.equals("3")) && (choix3.equals("4")) && (choix4.equals("1")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("1")) && (choix4.equals("2")))
					|| ((choix1.equals("4")) && (choix2.equals("1")) && (choix3.equals("2")) && (choix4.equals("3")))) {

				System.out.println("nom prenom annee promo");
			}
			if (((choix1.equals("1")) && (choix2.equals("2")) && (choix3.equals("3")) && (choix4.equals("5")))
					|| ((choix1.equals("2")) && (choix2.equals("3")) && (choix3.equals("5")) && (choix4.equals("1")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("1")) && (choix4.equals("2")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("2")) && (choix4.equals("3")))) {

				System.out.println("nom prenom annee dpt");
			}
			if (((choix1.equals("2")) && (choix2.equals("3")) && (choix3.equals("4")) && (choix4.equals("5")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("5")) && (choix4.equals("2")))
					|| ((choix1.equals("4")) && (choix2.equals("5")) && (choix3.equals("2")) && (choix4.equals("3")))
					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("3")) && (choix4.equals("4")))) {

				System.out.println(" prenom annee promo dpt");
			}

			if (((choix1.equals("1")) && (choix2.equals("3")) && (choix3.equals("4")) && (choix4.equals("5")))
					|| ((choix1.equals("3")) && (choix2.equals("4")) && (choix3.equals("5")) && (choix4.equals("1")))
					|| ((choix1.equals("4")) && (choix2.equals("5")) && (choix3.equals("1")) && (choix4.equals("3")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("3")) && (choix4.equals("4")))) {

				System.out.println(" nom annee promo dpt");
			}
			if (((choix1.equals("1")) && (choix2.equals("2")) && (choix3.equals("4")) && (choix4.equals("5")))
					|| ((choix1.equals("2")) && (choix2.equals("4")) && (choix3.equals("5")) && (choix4.equals("1")))
					|| ((choix1.equals("4")) && (choix2.equals("4")) && (choix3.equals("1")) && (choix4.equals("2")))
					|| ((choix1.equals("5")) && (choix2.equals("1")) && (choix3.equals("2")) && (choix4.equals("4")))
					
					|| ((choix1.equals("1")) && (choix2.equals("4")) && (choix3.equals("5")) && (choix4.equals("2")))
					|| ((choix1.equals("2")) && (choix2.equals("5")) && (choix3.equals("4")) && (choix4.equals("1")))
					|| ((choix1.equals("4")) && (choix2.equals("2")) && (choix3.equals("1")) && (choix4.equals("4")))
					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("4")) && (choix4.equals("1")))){
					
//					|| ((choix1.equals("1")) && (choix2.equals("5")) && (choix3.equals("4")) && (choix4.equals("2")))
//					|| ((choix1.equals("2")) && (choix2.equals("5")) && (choix3.equals("4")) && (choix4.equals("1")))
//					|| ((choix1.equals("4")) && (choix2.equals("2")) && (choix3.equals("1")) && (choix4.equals("4")))
//					|| ((choix1.equals("5")) && (choix2.equals("2")) && (choix3.equals("4")) && (choix4.equals("1"))))
					

				System.out.println("nom prenom promo dpt");
			}
		}

		if (nmbCritere == 5) {

		}

		saisi.close();
		return stagiaires;

	}

	public List<Stagiaire> rechercherPromo(String promoRecherchee, List<Stagiaire> stagiaires) {

		if (this.filsGauche != null) {
			stagiaires = this.filsGauche.rechercherPromo(promoRecherchee, stagiaires);

		}
		if ((this.stagiaire.getPromo().equals(promoRecherchee))) {
			stagiaires.add(this.getStagiaire());
		}
		if (this.filsDroit == null) { // je pars à droite

			stagiaires = this.filsDroit.rechercherPromo(promoRecherchee, stagiaires);
		}
		return stagiaires;
	}

	/*
	 * 
	 * private static List<Stagiaire> chercherMultiCle(String cle1, int key1, String
	 * cle2, int key2, ArbreStagiaire arbre, List<Stagiaire> listResult) {
	 * List<Stagiaire> listInter = new ArrayList<>(); switch (key1) { case 1:
	 * listInter = chercherNom(cle1, arbre); ArbreStagiaire miniArbreNom = new
	 * ArbreStagiaire(); ajouterNoeudAll(listInter,miniArbreNom); switch (key2) {
	 * case 2: listResult = chercherAnneeEntree(cle2, miniArbreNom); break; case 3:
	 * listResult = chercherPromotion(cle2, miniArbreNom); break; case 4: listResult
	 * = chercherDepartement(cle2, miniArbreNom); break; default:
	 * System.out.println("No Results founded"); listResult = new ArrayList<>();
	 * break; } break; case 2: listInter = chercherAnneeEntree(cle1, arbre);
	 * ArbreStagiaire miniArbreAE = new ArbreStagiaire(); ajouterNoeudAll(listInter,
	 * miniArbreAE); switch (key2) { case 1: listResult = chercherNom(cle2,
	 * miniArbreAE); break; case 3:
	 * 
	 */

}

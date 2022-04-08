package Test;

public class Stagiaire {
	
	
	private String nom;
	private String prenom;
	private String dpt;
	private String promo;
	private String annee;
	public Stagiaire(String nom, String prenom, String dpt, String promo, String annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dpt = dpt;
		this.promo = promo;
		this.annee = annee;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	@Override
	public String toString() {
		return "Stagiaire [nom=" + nom + ", prenom=" + prenom + ", dpt=" + dpt + ", promo=" + promo + ", annee=" + annee
				+ "]";
	}
	
	

}

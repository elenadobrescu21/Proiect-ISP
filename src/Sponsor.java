import java.util.ArrayList;

public class Sponsor {

	private String firma;
	private Cont cont;
	private ArrayList<Activitate> activitatiSponsorizate;

	public Sponsor(String firma) {
		this.firma = firma;
		this.activitatiSponsorizate = new ArrayList<Activitate>();
		cont = new Cont(firma, "sponsor");
	}
	
	public Sponsor() {
		this.activitatiSponsorizate = new ArrayList<Activitate>();
		
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	// Asta e functia din diagrama -> veziActivitatiSponsorizate
	// Trebuie schimbat tipul de data in diagrama
	public ArrayList<Activitate> getActivitatiSponsorizate() {
		return activitatiSponsorizate;
	}

	// Nu e folosita nicaieri !! doar in test
	public void setActivitatiSponsorizate(ArrayList<Activitate> activitatiSponsorizate) {
		this.activitatiSponsorizate = activitatiSponsorizate;
	}

	// Adauga la lista de activitati sponsorizate
	public void adaugaActivitateSponsorizata(Activitate a) {
		this.activitatiSponsorizate.add(a);
	}
	
	public void veziActivitatiSponsorizate() {
		if(this.activitatiSponsorizate.size() == 0) {
			System.out.println("Nu sponsorizeaza nicio activitate");
		}
		else {
			for(Activitate a: this.activitatiSponsorizate) {
				System.out.println(a.getNume());
			}
		}
	}

}

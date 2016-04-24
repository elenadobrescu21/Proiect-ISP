import java.util.ArrayList;

public class Sponsor {

	private String firma;
	private ArrayList<Activitate> activitatiSponsorizate;

	public Sponsor(String firma) {
		this.firma = firma;
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

	public void setActivitatiSponsorizate(ArrayList<Activitate> activitatiSponsorizate) {
		this.activitatiSponsorizate = activitatiSponsorizate;
	}

	// Adauga la lista de activitati sponsorizate
	public void adaugaActivitateSponsorizata(Activitate a) {
		this.activitatiSponsorizate.add(a);
	}

}

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

	public ArrayList<Activitate> getActivitatiSponsorizate() {
		return activitatiSponsorizate;
	}

	public void setActivitatiSponsorizate(ArrayList<Activitate> activitatiSponsorizate) {
		this.activitatiSponsorizate = activitatiSponsorizate;
	}

	public void adaugaActivitate(Activitate a) {
		this.activitatiSponsorizate.add(a);
	}

}

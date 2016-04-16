import java.util.ArrayList;


public class Elev extends Persoana {
	
	private Clasa clasa;
	private ArrayList<Activitate> activitati;
	private double numerarCont;

	public Elev(String nume, String prenume, String CNP, double numerarCont) {
		super(nume, prenume, CNP);
		this.numerarCont = numerarCont;
		activitati = new ArrayList<Activitate>();
	}
	
	//de completat- Alex
	public void inscrieLaActivitate(Activitate a) {
		this.activitati.add(a);
		a.adaugaElev(this);		
	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	public ArrayList<Activitate> getActivitati() {
		return activitati;
	}

	public void setActivitati(ArrayList<Activitate> activitati) {
		this.activitati = activitati;
	}
	
	
}

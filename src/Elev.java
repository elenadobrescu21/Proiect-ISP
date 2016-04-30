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

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}
	
	//Functia veziActivitatiCurente din diagrame
	public ArrayList<Activitate> getActivitati() {
		return activitati;
	}

	public void setActivitati(ArrayList<Activitate> activitati) {
		this.activitati = activitati;
	}

	public double getNumerarCont() {
		return numerarCont;
	}

	public void setNumerarCont(double numerarCont) {
		this.numerarCont = numerarCont;
	}

	public void afiseazaInformatii() {
		System.out.println("Nume: " + this.getNume());
		System.out.println("Prenume: " + this.getPrenume());
		System.out.println("Clasa: " + this.getClasa().getNume());
		System.out.println("Numerar cont: " + this.getNumerarCont());
		System.out.println("Activititati: ");
		if(this.activitati.size() == 0) {
			System.out.println("Elevul nu s-a inscris la nicio activitate");
		}
		else {
			for (Activitate a : activitati) {
				System.out.println(a.getNume());
			}
		}

	}

	// de completat- Alex
	// need rename
	public void inscrieLaActivitate(Activitate a) {
		this.activitati.add(a);
		a.adaugaElev(this);
	}
	
	//De implementat
	//veziActivitatiDisponibile
	//veziActivitatiCurente
	

}

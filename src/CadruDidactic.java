import java.util.ArrayList;


public class CadruDidactic extends Persoana {
	private double salariu;
	private int anAngajare;
	private ArrayList<Activitate> activitatiCoordonate;
	
	public CadruDidactic(String nume, String prenume, String CNP, double salariu,
			int anAngajare) {
		super(nume, prenume, CNP);
		this.salariu = salariu;
		this.anAngajare = anAngajare;
	}

	public double getSalariu() {
		return salariu;
	}

	public void setSalariu(double salariu) {
		this.salariu = salariu;
	}

	public int getAnAngajare() {
		return anAngajare;
	}

	public void setAnAngajare(int anAngajare) {
		this.anAngajare = anAngajare;
	}


}

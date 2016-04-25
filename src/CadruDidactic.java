import java.util.ArrayList;

public class CadruDidactic extends Persoana {

	private ArrayList<Activitate> activitatiCoordonate;

	public CadruDidactic(String nume, String prenume, String CNP) {
		super(nume, prenume, CNP);
		activitatiCoordonate = new ArrayList<Activitate>();
	}

	// - nu exista o lista globala de cnp-uri
	public void veziDetaliiElev(String cnp) {
		// Parcurge toata lista de cnp-uri

		// Daca l-ai gasit , afiseaza-l
	}


	// Se verifica daca activitatea pe care o adaugam daca o are deja in
	// coordonare
	public void adaugaActivitate(Activitate a) {

		if (activitatiCoordonate.contains(a)) {
			System.out.println("Adaugare esuata , activitatea " + a.getNume()
					+ " este deja coordonata de cadrul didactic " + this.getNume() + " " + this.getPrenume());

		} else {
			activitatiCoordonate.add(a);
			System.out.println("Activitatea a fost adauga cu succes ! ");

		}

		return;
	}


	public void veziActivitatiCoordonate() {
		if (activitatiCoordonate.size() == 0) {
			System.out.println("Nu coordoneaza nicio activitate");
			return;
		} else {

			for (Activitate a : activitatiCoordonate) {
				System.out.println(a.getNume() + " desfasurata la data de " + a.getDataDesfasurare());
			}
		}
	}
}

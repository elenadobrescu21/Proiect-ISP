import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

public class CadruDidactic extends Persoana {

    private ArrayList<Activitate> activitatiCoordonate;

    // CONSTRUCTORI
    
    public CadruDidactic(String nume, String prenume, String CNP) {
	super(nume, prenume, CNP);
	activitatiCoordonate = new ArrayList<Activitate>();
    }

    public CadruDidactic() {
	activitatiCoordonate = new ArrayList<Activitate>();
    }

    // GETTER + SETTER
    
    public ArrayList<Activitate> getActivitatiCoordonate() {
	return activitatiCoordonate;
    }

    public void setActivitatiCoordonate(ArrayList<Activitate> activitatiCoordonate) {
	this.activitatiCoordonate = activitatiCoordonate;
    }

    // FUNCTII UTILITARE

    // am modificat din parametru CNP sa ia ca parametru nume si prenume
    public void veziDetaliiElev(String nume, String prenume, List<Elev> elevi) {
	for (Elev e : elevi) {
	    if (e.getNume().equals(nume) && e.getPrenume().equals(prenume)) {
		e.afiseazaInformatii();
	    }
	}
    }

    // Se verifica daca activitatea pe care o adaugam
    // daca o are deja in coordonare
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
		System.out.println(a.getNume() + " desfasurata la data de " + a.getDataDesfasurare().toString());
	    }
	}
    }

    public void afiseazaInformatii() {
	System.out.println("Nume: " + this.getNume());
	System.out.println("Prenume: " + this.getPrenume());
	System.out.println("Activititati: ");
	this.veziActivitatiCoordonate();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((activitatiCoordonate == null) ? 0 : activitatiCoordonate.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	CadruDidactic other = (CadruDidactic) obj;
	if (activitatiCoordonate == null) {
	    if (other.activitatiCoordonate != null)
		return false;
	} else if (!activitatiCoordonate.equals(other.activitatiCoordonate))
	    return false;
	return true;
    }

    // FUNCTIE DIN DIAGRAMA DE COMUNICARE

    public void modificaActivitate(Activitate a, Administrator admin) {

	// Foloseste lista de activitati pe care o creaza administratorul
	// respectiv
	ArrayList<Activitate> activitati = new ArrayList<Activitate>();
	activitati = admin.getActivitati();

	// Cauta activitatea sa vezi daca administratorul chiar o are
	// Daca DA ->
	if (activitati.contains(a)) {

	    if (a instanceof Sedinta) {
		((Sedinta) a).modificaSedinta();
	    }

	    if (a instanceof Workshop) {
		((Workshop) a).modificaWorkshop();
	    }
	    // Daca NU ->
	} else {
	    System.out.println("Activitatea pe care incerci sa o modifici nu exista !");
	}

    }

}

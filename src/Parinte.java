import java.util.List;

public class Parinte extends Persoana {

    private Clasa clasaCopil;
    private Cont cont;

    // CONSTRUCTORI

    public Parinte(String nume, String prenume, String CNP, Clasa clasaCopil) {
	super(nume, prenume, CNP);
	this.clasaCopil = clasaCopil;
	String username = nume + "_" + prenume;
	cont = new Cont(username, "parola");
    }

    public Parinte() {

    }

    // SETTERI + GETTERI

    public Clasa getClasaCopil() {
	return clasaCopil;
    }

    public void setClasaCopil(Clasa clasaCopil) {
	this.clasaCopil = clasaCopil;
    }

    public Cont getCont() {
	return cont;
    }

    public void setCont(Cont cont) {
	this.cont = cont;
    }

    // FUNCTIE UTILITARA

    public void vizualizareSedinte(List<Sedinta> activitati) {
	for (Sedinta a : activitati) {
	    if (a.getClasa().equals(this.clasaCopil)) {
		System.out.println("Sedinta este in data de " + a.getDataDesfasurare().toString() + " in sala "
			+ a.getSala().getNrSala() + ", etaj " + a.getSala().getEtaj());
	    }
	}
    }

}

import java.util.List;

public class Parinte extends Persoana{
	
	private Clasa clasaCopil;
	private Cont cont;

	public Parinte(String nume, String prenume, String CNP, Clasa clasaCopil) {
		super(nume, prenume, CNP);
		this.clasaCopil = clasaCopil;
		cont = new Cont(nume, "parola");
	}
	
	public void vizualizareSedinte(List<Activitate> activitati) {
		for(Activitate a: activitati) {
			if(a instanceof Sedinta) {
				if(((Sedinta) a).getClasa().equals(this.clasaCopil)) {
					System.out.println("Sedinta este in data de "+ a.getDataDesfasurare().toString() + "in sala " +
				((Sedinta) a).getSala().getNrSala()) ;
				}
			}
		}
		
	}
	
}

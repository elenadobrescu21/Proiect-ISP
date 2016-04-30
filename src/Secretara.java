import java.util.List;

public class Secretara extends Persoana {
	private Cont cont;
		
	public Secretara(String nume, String prenume, String CNP) {
		super(nume, prenume, CNP);
		cont = new Cont("secretara", "secretara");
	
	}

	public void vizualizareDateElev(List<Elev> elevi, String nume, String prenume) {
		boolean gasit = false;
		for(Elev e: elevi) {
			if(e.getNume().equals(nume)&& e.getPrenume().equals(prenume)) {
				e.afiseazaInformatii();
				gasit = true;
				break;
			}
		}
		if(gasit == false) {
			System.out.println("Nu s-a gasit elevul");
		}
		
		
	}
	
	public void vizualizareDateCadruDidactic(List<CadruDidactic> profesori, String nume, String prenume) {
		boolean gasit = false;
		for(CadruDidactic c : profesori) {
			if(c.getNume().equals(nume) && c.getPrenume().equals(prenume)) {
				c.afiseazaInformatii();
				gasit = true;
				break;
			}
		}
		if(gasit == false) {
			System.out.println("Nu s-a gasit profesorul");
		}
		
	}

}

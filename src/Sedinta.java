import java.util.List;
import java.util.Scanner;

public class Sedinta extends Activitate {

	private Clasa clasa;
	private Sala sala;

	public Sedinta(String nume, Data dataDesfasurare, float taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
			int oraIncepere, Clasa clasa) {
		super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.clasa = clasa;
	}

	public Sedinta(String nume, Data dataDesfasurare, float taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
			int oraIncepere, Clasa clasa, Sala sala) {
		super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.clasa = clasa;
		this.sala = sala;
	}

	public Sedinta() {

	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void asigneazaResponsabil(List<Clasa> clase) {
		for (Clasa cls : clase) {
			if (this.clasa.getNume().equals(cls.getNume())) {
				this.setResponsabil(cls.getResponsabil());
			}
		}

	}

	public void modificaSedinta() {

		// Parametru pentru apelarea multipla sau nu a functiei
		int incercare = -1;
		boolean modifica = true;
		Scanner s = new Scanner(System.in);

		do {

			int alegere = -1;
			do {
				System.out.println("Ce parametru vrei sa modifici din SEDINTA ?");
				System.out.println("1.Date Activitate/ 2.Sala / 3.Nume Clasa ");

				alegere = s.nextInt();

				switch (alegere) {
				case 1:// Ce tine de trunchi comun
					System.out.println("Modificare Workshop - Date Activitate");
					modificaActivitate();
					break;
				case 2:
					sala.modificaSala();
					break;
				case 3:
					System.out.println("Modifica nume = ");
					String Nume_Nou = s.next();
					clasa.setNume(Nume_Nou);
					break;

				}
			} while (alegere != 1 && alegere != 2 && alegere != 3);

			System.out.println("Mai doresti sa modifici vreun parametru din SEDINTA ?");
			System.out.println("1.DA / 2.NU");
			incercare = s.nextInt();

			switch (incercare) {
			case 1:
				modifica = true;
				break;
			case 2:
				modifica = false;
				break;
			}
		} while (modifica == true);
		System.out.println("Modificari SEDINTA finalizate !");

	}
}

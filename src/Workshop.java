import java.util.Scanner;

public class Workshop extends Activitate {

	private String tematica;
	private Sala sala;

	public Workshop(String nume, Data dataDesfasurare, float taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
			int oraIncepere, String tematica, Sala sala) {
		super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.tematica = tematica;
		this.sala = sala;

	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void modificaWorkshop() {

		// Parametru pentru apelarea multipla sau nu a functiei
		int incercare = -1;
		boolean modifica = true;
		Scanner s = new Scanner(System.in);

		do {

			int alegere = -1;
			do {
				System.out.println("Ce parametru vrei sa modifici din WORKSHOP ?");
				System.out.println("1.Datele Activitatii / 2.Sala / 3.Tematica");

				alegere = s.nextInt();

				switch (alegere) {
				case 1:// Ce tine de trunchi comun
					System.out.println("Modificare Workshop - Date Activitate");
					modificaActivitate();
					break;
				case 2:
					System.out.println("Modificare Workshop - Sala");
					sala.modificaSala();
					break;
				case 3:
					System.out.println("Introdu alta tematica = ");
					String Tematica_Noua = s.next();
					setTematica(Tematica_Noua);
					break;
				}
			} while (alegere != 1 && alegere != 2 && alegere != 3);

			System.out.println("Mai doresti sa modifici vreun parametru din WORKSHOP ?");
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
		System.out.println("Modificari WORKSHOP finalizate !");
	}
}

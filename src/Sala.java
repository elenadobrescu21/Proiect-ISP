import java.util.Scanner;

public class Sala {

	private int nrSala;
	private int nrLocuri;
	private int etaj;

	public Sala(int nrSala, int nrLocuri, int etaj) {
		this.nrSala = nrSala;
		this.nrLocuri = nrLocuri;
		this.etaj = etaj;
	}

	public Sala() {

	}

	public int getNrSala() {
		return nrSala;
	}

	public void setNrSala(int nrSala) {
		this.nrSala = nrSala;
	}

	public int getNrLocuri() {
		return nrLocuri;
	}

	public void setNumarLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public int getEtaj() {
		return etaj;
	}

	public void setEtaj(int etaj) {
		this.etaj = etaj;
	}

	// Functie care permite sa modifici fiecare parametru cu alte valori citite
	// de la tastatura
	// In cazul in care se executa o modificare , responsabilul va fi intrebat
	// daca mai modifica si alt parametru sau finalizeaza modificarea
	public void modificaSala() {
		System.out.println("Modificare Sala");
		// Parametru pentru apelarea multipla sau nu a functiei
		int incercare = -1;
		boolean modifica = true;
		Scanner s = new Scanner(System.in);

		do {
			// Parametrii care vor fi folositi pentru modificarea functiei prin
			// seteri
			int NrSala_Nou = -1;
			int NrLocuri_Nou = -1;
			int EtajNou = -1;

			// Valoare ca sa verific daca optiunea introdusa de modificare e
			// valida ( daca e 1,2,3)
			int alegere = -1;

			do {
				System.out.println("Ce parametru vrei sa modifici din sala ?");
				System.out.println("1.NrSala / 2.NrLocuri / 3.Etaj");

				alegere = s.nextInt();

				switch (alegere) {
				case 1:
					System.out.println("Introdu alt numar pentru sala curenta = ");
					NrSala_Nou = s.nextInt();
					setNrSala(NrSala_Nou);
					break;
				case 2:
					System.out.println("Introdu alt numar de locuri = ");
					NrLocuri_Nou = s.nextInt();
					setNumarLocuri(NrLocuri_Nou);
					break;
				case 3:
					System.out.println("Introdu alt etaj = ");
					EtajNou = s.nextInt();
					setEtaj(EtajNou);
					break;
				}
			} while (alegere != 1 && alegere != 2 && alegere != 3);

			System.out.println("Modificare SALA cu succes !");

			System.out.println("Mai doresti sa modifici vreun parametru din SALA ?");
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

		System.out.println("Modificari SALA finalizate !");
		//s.close();
	}

}

import java.util.ArrayList;
//warning nu e folosit
//import java.util.Date; 
import java.util.Scanner;

public class Activitate {

	private String nume;
	private CadruDidactic responsabil;
	private ArrayList<Elev> eleviParticipanti;
	private Data dataDesfasurare;
	private float taxa;
	private Data termenLimitaInscriere;
	private int nrMaximParticipanti;
	private int oraIncepere;
	private String stare;

	// Cicu - vreau sa vad daca mai sunt sau nu locuri
	// E functia verificaDisponibilitate REDENUMITA
	public boolean existaLocuri() {
		if (this.nrMaximParticipanti == eleviParticipanti.size())
			return false;
		else
			return true;
	}

	public Activitate(String nume, Data dataDesfasurare, float taxa, Data termenLimitaInscriere,
			int nrMaximParticipanti, int oraIncepere) {
		this.nume = nume;
		this.dataDesfasurare = dataDesfasurare;
		this.taxa = taxa;
		this.termenLimitaInscriere = termenLimitaInscriere;
		this.nrMaximParticipanti = nrMaximParticipanti;
		this.oraIncepere = oraIncepere;
		this.stare = "creata";
		eleviParticipanti = new ArrayList<Elev>();
	}

	public Activitate() {

	}

	public CadruDidactic getResponsabil() {
		return responsabil;
	}

	// Cicu : trebuie modificata si pe diagrama ca nu are param
	public void asigneazaResponsabil(CadruDidactic responsabil) {
		this.responsabil = responsabil;
		if (this.stare.equals("creata"))
			this.stare = "disponibila";
		else
			System.out.println("Nu se poate asigna un responsabil in aceasta stare");
	}

	public ArrayList<Elev> getEleviParticipanti() {
		return eleviParticipanti;
	}

	public void setEleviParticipanti(ArrayList<Elev> eleviParticipanti) {
		this.eleviParticipanti = eleviParticipanti;
	}

	public Data getDataDesfasurare() {
		return dataDesfasurare;
	}

	public void setDataDesfasurare(Data data) {
		this.dataDesfasurare = data;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Data getTermenLimitaInscriere() {
		return termenLimitaInscriere;
	}

	public void setTermenLimitaInscriere(Data termenLimitaInscriere) {
		this.termenLimitaInscriere = termenLimitaInscriere;
	}

	public int getNrMaximParticipanti() {
		return nrMaximParticipanti;
	}

	public void setNrMaximParticipanti(int nrMaximParticipanti) {
		this.nrMaximParticipanti = nrMaximParticipanti;
	}

	public int getOraIncepere() {
		return oraIncepere;
	}

	public void setOraIncepere(int oraIncepere) {
		this.oraIncepere = oraIncepere;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public void setResponsabil(CadruDidactic responsabil) {
		this.responsabil = responsabil;
		responsabil.getActivitatiCoordonate().add(this);
	}

	// In diagrama e functia : adaugaInListaParticipanti
	// Modificare diagrama
	// Verificare daca elevul e unic
	public void adaugaElev(Elev e) {
		eleviParticipanti.add(e);
	}

	public void inchideInscrieri() {
		if (this.stare.equals("disponibila")) {
			int comparaData = this.termenLimitaInscriere.comparaCuDataCurenta();
			if (eleviParticipanti.size() == nrMaximParticipanti || comparaData > 0) {
				this.stare = "Inscriere indisponibila";
			}
		} else
			System.out.println("Nu se pot inchide inscrierile");
	}

	public void suspenda() {
		if (this.stare.equals("disponibila")) {
			int comparaData = this.termenLimitaInscriere.comparaCuDataCurenta();
			if (comparaData > 0) {// Cred ca mergea cu un sigur if
				if (eleviParticipanti.size() < nrMaximParticipanti / 2) {
					this.stare = "suspendata";
				}
			}
		}
	}

	public void reseteazaData(Data termenLimitaInscriere, Data data) {
		if (this.stare.equals("suspendata")) {
			this.termenLimitaInscriere = termenLimitaInscriere;
			this.dataDesfasurare = data;
			this.stare = "disponibila";
		}
	}

	public void vizualizareDetalii() {
		System.out.println("Activitatea de : " + this.getNume());
		if (this.getResponsabil() == null) {
			System.out.println("Activitatea nu are un responsabil");
		} else {
			System.out.println("Responsabil : " + this.getResponsabil());
		}
		System.out.println("Numar maxim participanti = " + this.getNrMaximParticipanti() + " persoane");
		System.out.println("Ora de incepere a activitatii este : " + this.getOraIncepere() + " AM");
		System.out.println("Taxa evenimentului este = " + this.getTaxa() + " RON");
		System.out.println("Inscrierile se pot face pana la data de : " + this.getTermenLimitaInscriere().toString());
		System.out.println("Evenimentul se va desfasura pana la data de : " + this.getDataDesfasurare().toString());
		System.out.println();
	}

	// Functie care sa o mosteneasca si sa o foloseasca si modificarile de
	// workshop/sedinta/concurs
	public void modificaActivitate() {

		// Parametru pentru apelarea multipla sau nu a functiei
		int incercare = -1;
		boolean modifica = true;
		Scanner s = new Scanner(System.in);

		do {
			// Parametrii care vor fi folositi pentru modificarea functiei prin
			// seteri
			String Nume_Nou = "";
			float Taxa_Noua = -1.0f;
			int NrParticipanti_Nou = -1, OraStart_Noua = -1;
			int alegere = -1;
			do {
				System.out.println("Ce parametru vrei sa modifici ?");
				System.out.println("1.Nume / 2.Taxa / 3.NrParticipanti / 4.OraStart  ");
				System.out.println("5.Data Desfasurare / 6.Data Limita Inscriere");

				alegere = s.nextInt();
				switch (alegere) {
				case 1:
					System.out.println("Introdu alta denumire pentru activitate = ");
					Nume_Nou = s.next();
					setNume(Nume_Nou);
					break;
				case 2:
					System.out.println("Introdu alta taxa = ");
					Taxa_Noua = s.nextInt();
					setTaxa(Taxa_Noua);
					break;
				case 3:
					System.out.println("Introdu nr maxim de participanti = ");
					NrParticipanti_Nou = s.nextInt();
					setNrMaximParticipanti(NrParticipanti_Nou);
					break;
				case 4:
					System.out.println("Introdu alta ora de incepere = ");
					OraStart_Noua = s.nextInt();
					setOraIncepere(OraStart_Noua);
					break;
				case 5:
					dataDesfasurare.modificaData();
					break;
				case 6:
					termenLimitaInscriere.modificaData();
					break;

				}
			} while (alegere != 1 && alegere != 2 && alegere != 3 && alegere != 4 && alegere != 5 && alegere != 6);
			System.out.println("Modificare cu succes !");

			System.out.println("Mai doresti sa modifici vreun parametru ?");
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
		System.out.println("Modificari finalizate !");
		//s.close();
	}

}

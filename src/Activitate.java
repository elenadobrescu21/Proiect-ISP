import java.util.ArrayList;
//warning nu e folosit
//import java.util.Date; 

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

	// Cicu : trebuie modificata si pe diagrama ca nu are param.
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

	public double getTaxa() {
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
	}

	// In diagrama e functia : adaugaInListaParticipanti
	// Modificare diagrama
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

	// De implementat daca e cazul , daca nu sterse din diagrama
	// modificaActivitate()
	// verificaDisponibilitate()

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

	}
}

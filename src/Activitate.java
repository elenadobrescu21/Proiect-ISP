import java.util.ArrayList;
import java.util.Date;


public class Activitate {
	
	private String nume;
	private CadruDidactic responsabil;
	private ArrayList<Elev> eleviParticipanti;
	private Data dataDesfasurare;
	private double taxa;
	private Data termenLimitaInscriere;
	private int nrMaximParticipanti;
	private int oraIncepere;
	private String stare;
	
	public Activitate(Data dataDesfasurare, double taxa, Data termenLimitaInscriere, int nrMaximParticipanti, int oraIncepere) {
		this.dataDesfasurare = dataDesfasurare;
		this.taxa = taxa;
		this.termenLimitaInscriere = termenLimitaInscriere;
		this.nrMaximParticipanti = nrMaximParticipanti;
		this.oraIncepere = oraIncepere;
		this.stare = "creata";
		eleviParticipanti = new ArrayList<Elev>();
	}
	
	
	public CadruDidactic getResponsabil() {
		return responsabil;
	}


	public void asigneazaResponsabil(CadruDidactic responsabil) {
		this.responsabil = responsabil;
		if(this.stare.equals("creata"))
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


	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}


	public void adaugaElev(Elev e) {
		eleviParticipanti.add(e);
	}
	
	public void inchideInscrieri() {
		if(this.stare.equals("disponibila")) {
			int comparaData = this.termenLimitaInscriere.comparaCuDataCurenta();
			if(eleviParticipanti.size() == nrMaximParticipanti || comparaData > 0) {
				this.stare = "Inscriere indisponibila";			
			}
		}
		else
			System.out.println("Nu se pot inchide inscrierile");
	}
	
	public void suspenda() {
		if(this.stare.equals("disponibila")) {
			int comparaData = this.termenLimitaInscriere.comparaCuDataCurenta();
			if(comparaData > 0) {
				if(eleviParticipanti.size() < nrMaximParticipanti/2) {
					this.stare = "suspendata";
				}
			}
		}
	}
	
	public void reseteazaData(Data termenLimitaInscriere, Data data) {
		if(this.stare.equals("suspendata")) {
			this.termenLimitaInscriere = termenLimitaInscriere;
			this.dataDesfasurare = data;
			this.stare = "disponibila";	
			}
	}
		

	
}


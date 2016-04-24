public class Workshop extends Activitate {

	private String tematica;
	private Sala sala;

	public Workshop(String nume, Data dataDesfasurare, double taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
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
	
	//De implementat modificaWorkshop(){}

}

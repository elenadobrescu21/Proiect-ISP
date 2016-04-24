public class Sedinta extends Activitate {

	private Clasa clasa;
	private Sala sala;

	public Sedinta(String nume, Data dataDesfasurare, double taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
			int oraIncepere, Clasa clasa, Sala sala) {
		super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.clasa = clasa;
		this.sala = sala;
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
	
	//De implementat public void modificaSedinta(){}

}

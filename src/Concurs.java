import java.util.ArrayList;

public class Concurs extends Activitate {

	private String disciplina;
	private Sponsor sponsor;

	public Concurs(String nume, Data dataDesfasurare, double taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
			int oraIncepere, String disciplina, Sponsor sponsor) {
		super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.disciplina = disciplina;
		this.sponsor = sponsor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}

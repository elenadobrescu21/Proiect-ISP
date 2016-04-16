import java.util.ArrayList;


public class Concurs extends Activitate {
	
	private String disciplina;

	public Concurs(Data dataDesfasurare, double taxa,
			Data termenLimitaInscriere, int nrMaximParticipanti, int oraIncepere, String disciplina) {
		super(dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti,
				oraIncepere);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	

}

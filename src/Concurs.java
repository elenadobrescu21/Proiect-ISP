import java.util.ArrayList;

public class Concurs extends Activitate {

    private String disciplina;
    private Sponsor sponsor;
    private Sala sala;

    // CONSTRUCTORI

    public Concurs(String nume, Data dataDesfasurare, float taxa, Data termenLimitaInscriere, int nrMaximParticipanti,
	    int oraIncepere, String disciplina, Sponsor sponsor, Sala sala) {
	super(nume, dataDesfasurare, taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
	this.disciplina = disciplina;
	this.sponsor = sponsor;
	this.sala = sala;
    }

    public Concurs() {

    }

    // SETTERI

    public void setSponsor(Sponsor sponsor) {
	this.sponsor = sponsor;
    }

    public void setSala(Sala sala) {
	this.sala = sala;
    }

    public void setDisciplina(String disciplina) {
	this.disciplina = disciplina;
    }

    // GETTERI

    public Sponsor getSponsor() {
	return sponsor;
    }

    public Sala getSala() {
	return sala;
    }

    public String getDisciplina() {
	return disciplina;
    }

}

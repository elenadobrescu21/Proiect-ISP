import java.util.ArrayList;


public class Excursie extends Activitate {
	ArrayList<ObiectivTuristic> obiectiveTuristice;
	
	public Excursie(Data dataDesfasurare, double taxa, Data termenLimitaInscriere, int nrMaximParticipanti, int oraIncepere,
			ArrayList<ObiectivTuristic> obiectiveTuristice) {
		super(dataDesfasurare,taxa, termenLimitaInscriere, nrMaximParticipanti, oraIncepere);
		this.obiectiveTuristice = obiectiveTuristice;
	}

	
	public ArrayList<ObiectivTuristic> getObiectiveTuristice() {
		return obiectiveTuristice;
	}

	public void setObiectiveTuristice(ArrayList<ObiectivTuristic> obiectiveTuristice) {
		this.obiectiveTuristice = obiectiveTuristice;
	}
	

}

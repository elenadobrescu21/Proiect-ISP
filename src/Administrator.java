import java.util.ArrayList;


public class Administrator {
	private ArrayList<Cont> conturiElev;
	private ArrayList<Cont> conturiCadruDidactic;
	
	public Administrator() {
		conturiElev = new ArrayList<Cont>();
		conturiCadruDidactic = new ArrayList<Cont>();
	}
	
	public void adaugaActivitate(){
		
	}
	
	public void adaugaContElev(Cont c){
		this.conturiElev.add(c);
		
	}
	
	public void creareContElev(Elev e) {
		String numeElev = e.getNume();
		String prenumeElev = e.getPrenume();
		String[] prenume = prenumeElev.split(" ");
		String username = numeElev + "." + prenume[0];
		String parola = "parola";
		Cont contElev = new Cont(username, parola);
		for(Cont c : this.conturiElev) {
			if (c.getUsername().equals(contElev.getUsername())) {
				int numarPrenume = prenume.length;
				if(numarPrenume > 1) {
					username = username + "_" + prenume[1];
					contElev.setUsername(username);
				}
				else {
					String CNP = e.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					contElev.setUsername(username);
				}
				
			}	
		}
		
		this.conturiElev.add(contElev);
		e.setCont(contElev);
	}
	
	public void creareContCadruDidactic(CadruDidactic cd){
		
		String numeProfesor = cd.getNume();
		String prenumeProfesor = cd.getPrenume();
		String[] prenume = prenumeProfesor.split(" ");
		String username = numeProfesor + "." + prenume[0];
		String parola = "parola";
		Cont contProfesor = new Cont(username, parola);
		for(Cont c : this.conturiElev) {
			if (c.getUsername().equals(contProfesor.getUsername())) {
				int numarPrenume = prenume.length;
				if(numarPrenume > 1) {
					username = username + "_" + prenume[1];
					contProfesor.setUsername(username);
				}
				else {
					String CNP = cd.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					contProfesor.setUsername(username);
				}
				
			}	
		}
		
		this.conturiCadruDidactic.add(contProfesor);
		cd.setCont(contProfesor);
		
		
		
	}
	
	public void modificareDateElev() {
		
	}
	
	/*public boolean verificareCont(Cont c) {
		
	} */

}

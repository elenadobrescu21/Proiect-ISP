import java.util.ArrayList;
import java.util.List;


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
	
	public void creareCont(Persoana p) {
		List<Cont> lista = new ArrayList<Cont>();
		if(p instanceof Elev) {
			lista = this.conturiElev;			
		}
		else
			lista = this.conturiCadruDidactic;
		String nume = p.getNume();
		String prenumePersoana = p.getPrenume();
		String[] prenume = prenumePersoana.split(" ");
		String username = nume + "." + prenume[0];
		String parola = "parola";
		Cont cont = new Cont(username, parola);
		for(Cont c : lista) {
			if (c.getUsername().equals(cont.getUsername())) {
				int numarPrenume = prenume.length;
				if(numarPrenume > 1) {
					username = username + "_" + prenume[1];
					cont.setUsername(username);
				}
				else {
					String CNP = p.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					cont.setUsername(username);
				}
				
			}	
		}
		
		lista.add(cont);
		p.setCont(cont);
		
	}
	/*
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
	 */
	public void modificareDateElev() {
		
	}
	
	public boolean verificareCont(Persoana p) {
		List<Cont> listaDeCautat = new ArrayList<Cont>();
		if(p instanceof Elev) {
			listaDeCautat = this.conturiElev;
		}
		else
			listaDeCautat = this.conturiCadruDidactic;
		boolean contExistent = false;
		for(Cont cont : listaDeCautat) {
			if(p.getCont().equals(cont)) {
				contExistent = true;
			break;
			}			
	     } 
		return contExistent;
	}
	
	
	
	

}

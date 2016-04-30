import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int alegereTipCont() {
		int tipCont;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Alegeti tipul de cont cu care doriti sa va logati");
			System.out.println("1 - cont de cadru didactic");
			System.out.println("2 - cont de elev");
			System.out.println("3 - administrator");
			System.out.println("4 -  secretara");
			System.out.println("5 - sponsor");
			System.out.println("6 - parinte");
			
			tipCont = s.nextInt();
		} while (tipCont!=1 && tipCont!=2 && tipCont!=3 && tipCont!=4 && tipCont!=5 && tipCont!=6 );
		
		return tipCont;
		
	}
	public static void main(String[] args) {
		
		Elev e1 = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Elev e2 = new Elev("Bolboaca", "valeria", "2940621460046", 700);
		Elev e3 = new Elev("Cicu", "Alexandru", "1940621460044", 780);

		List<Elev> listaElevi = new ArrayList<Elev>();
		List<CadruDidactic> listaProfesori = new ArrayList<CadruDidactic>();
		List<Sponsor> sponsori = new ArrayList<Sponsor>();
		List<Clasa> clase = new ArrayList<Clasa>();
		List<Sala> sali = new ArrayList<Sala>();
		Secretara secretara = new Secretara("Voiculescu", "Monica","2840621460046" );
		
		Sala s1 = new Sala(12, 30, 1);
		Sala s2 = new Sala(10, 30, 1);
		Sala s3 = new Sala(11, 30, 1);
		
		sali.add(s1);
		sali.add(s2);
		sali.add(s3);
			
		CadruDidactic c1 = new CadruDidactic("Popescu", "Ioana", "2940621460043");
		CadruDidactic c2 = new CadruDidactic("Ionescu", "Andreea", "2940621460042");
		CadruDidactic c3 = new CadruDidactic("Popescu", "Andrei", "1940621460042");
		
		Clasa cls = new Clasa("8A", c1);
		Clasa cls2 = new Clasa("7A", c2);
		Clasa cls3 = new Clasa("6A", c3);
		
		e1.setClasa(cls);
		e2.setClasa(cls);
		e3.setClasa(cls);
        	
		listaElevi.add(e1);
		listaElevi.add(e2);
		listaElevi.add(e3);

		listaProfesori.add(c1);
		listaProfesori.add(c2);
		listaProfesori.add(c3);

		Administrator admin = new Administrator();
		admin.creareCont(e1);
		admin.creareCont(e2);
		admin.creareCont(e3);

		admin.creareCont(c1);
		
		Scanner s = new Scanner(System.in);
		int tipCont = alegereTipCont();
		
		//pentru secretara
		if(tipCont == 4) {
			System.out.println("Cont de secretara");
			String parolaSecretara ="";
			String usernameSecretara="";
			boolean logat = false;
			do{
			System.out.println("Introduceti username");
			usernameSecretara = s.nextLine();
			System.out.println("Introduceti parola");
			 parolaSecretara = s.nextLine();
			}while(usernameSecretara.equals("secretara")==false && parolaSecretara.equals("secretara")==false);
			logat = true;
			System.out.println("1 - Vizualizare date despre un elev");
			System.out.println("2 - Vizualizare date despre un cadru didactic");
			do {
			int alegere;	
			do{
				System.out.println("Alegeti optiunea");
				
				alegere = s.nextInt();	
			}while(alegere!=1 && alegere!=2);
			if( alegere == 1) {
				String numeElev="";
				String prenumeElev="";
				Scanner scan = new Scanner(System.in);
				System.out.println("Nume elev:");
				numeElev = scan.nextLine();
				System.out.println("Prenume elev:");
				prenumeElev = scan.nextLine();
				secretara.vizualizareDateElev(listaElevi, numeElev, prenumeElev);
				//scan.close();
			}
			if(alegere == 2) {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Nume profesor: ");
				String numeProfesor = scan3.nextLine();
				System.out.println("Prenume profesor");
				String prenumeProfesor = scan3.nextLine();
				secretara.vizualizareDateCadruDidactic(listaProfesori, numeProfesor, prenumeProfesor);
			}
			System.out.println("Doriti sa va delogati? da/nu");
			Scanner scan2 = new Scanner(System.in);
			String raspuns="";
			 raspuns= scan2.nextLine();
			
			if(raspuns.equals("da")){
				logat = false;
			}			
			} while(logat == true);
		
		}
		
		
		/*
		 * boolean logat = false; while(logat == false) { System.out.println(
		 * "Logare ca Elev"); System.out.println("Username:"); Scanner scan= new
		 * Scanner(System.in); String username= scan.nextLine();
		 * System.out.println("Parola:"); String parola = scan.nextLine(); Cont
		 * contDeVerificat = new Cont(username,parola); for(Elev e: listaElevi)
		 * { if(contDeVerificat.equals(e.getCont())) { System.out.println(
		 * "Logare cu succes"); e.afiseazaInformatii(); logat= true; break; }
		 * else System.out.println("Username sau parola incorecta");
		 * 
		 * } }
		 */

		// Verificare functie detalii activitate 
		/*Activitate a = new Activitate("Sport", new Data(2016, 4, 25), 15, new Data(2016, 4, 29), 30, 10);
		//a.vizualizareDetalii();

		// Verificare functii Cadru Didactic 
		CadruDidactic cd = new CadruDidactic("Cicu", "Alexandru", "100110");
		cd.adaugaActivitate(a);
		cd.veziActivitatiCoordonate();*/

	}

}

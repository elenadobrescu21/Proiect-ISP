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
			System.out.println("4 - secretara");
			System.out.println("5 - sponsor");
			System.out.println("6 - parinte");
			
			tipCont = s.nextInt();
		} while (tipCont!=1 && tipCont!=2 && tipCont!=3 && tipCont!=4 && tipCont!=5 && tipCont!=6 );
		
		return tipCont;
		
	}
	
	public static void logareParinte(List<Parinte> parinti, List<Sedinta> activitati) {
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Cont de parinte");
		String parolaParinte ="";
		String usernameParinte="";
		boolean logat = false;
		boolean userExistent = false;
		Parinte parinteLogat = new Parinte();
		do{
			System.out.println("Introduceti username");
			usernameParinte= scan6.nextLine();
			for(Parinte p : parinti) {
				if(p.getCont().getUsername().equals(usernameParinte) ) {
					userExistent = true;
					parinteLogat = p;
					break;
				}
			}
			System.out.println("Introduceti parola");
			 parolaParinte = scan6.nextLine();
			}while(userExistent == false && parolaParinte.equals("parola")==false);			
			parinteLogat.vizualizareSedinte(activitati);	
		
		
	}
	
	public static void logareSecretara(Secretara secretara, List<Elev> listaElevi, List<CadruDidactic> listaProfesori) {
		Scanner s = new Scanner(System.in);
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
	
	public static void logareSponsor(List<Sponsor> sponsori) {
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Cont de sponsor");
		String parolaSponsor ="";
		String usernameSponsor="";
		boolean logat = false;
		boolean userExistent = false;
		Sponsor sponsorLogat = new Sponsor();
		do{
			System.out.println("Introduceti username");
			usernameSponsor= scan5.nextLine();
			for(Sponsor sp : sponsori) {
				if(sp.getFirma().equals(usernameSponsor)) {
					userExistent = true;
					sponsorLogat = sp;
					break;
				}
			}
			System.out.println("Introduceti parola");
			 parolaSponsor = scan5.nextLine();
			}while(userExistent == false && parolaSponsor.equals("sponsor")==false);			
			sponsorLogat.veziActivitatiSponsorizate();	
		
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
		List<Parinte> parinti = new ArrayList<Parinte>();
		List<Sedinta> sedinte = new ArrayList<Sedinta>();
		Secretara secretara = new Secretara("Voiculescu", "Monica","2840621460046" );
			
		Sala s1 = new Sala(12, 50, 1);
		Sala s2 = new Sala(10, 50, 1);
		Sala s3 = new Sala(11, 50, 1);
		
		sali.add(s1);
		sali.add(s2);
		sali.add(s3);
			
		CadruDidactic c1 = new CadruDidactic("Popescu", "Ioana", "2940621460043");
		CadruDidactic c2 = new CadruDidactic("Ionescu", "Andreea", "2940621460042");
		CadruDidactic c3 = new CadruDidactic("Popescu", "Andrei", "1940621460042");
		
		Clasa cls = new Clasa("8A", c1);
		Clasa cls2 = new Clasa("7A", c2);
		Clasa cls3 = new Clasa("6A", c3);
		
		Sponsor sp1 = new Sponsor("intel");
		Sponsor sp2 = new Sponsor("ibm");
		
		Parinte p1 = new Parinte("dobrescu", "steliana","2610621460044", cls);
		
		parinti.add(p1);
		
		e1.setClasa(cls);
		e2.setClasa(cls2);
		e3.setClasa(cls3);
        	
		listaElevi.add(e1);
		listaElevi.add(e2);
		listaElevi.add(e3);

		listaProfesori.add(c1);
		listaProfesori.add(c2);
		listaProfesori.add(c3);
		
		clase.add(cls);
		clase.add(cls2);
		clase.add(cls3);
		
		sponsori.add(sp1);
		sponsori.add(sp2);
		

		Administrator admin = new Administrator();
		admin.creareCont(e1);
		admin.creareCont(e2);
		admin.creareCont(e3);

		admin.creareCont(c1);
		//creare concurs
		Data dataConcurs = new Data(25, 5, 2016);
		Data termenInscriereConcurs = new Data(23, 5, 2016);
		
		Concurs concurs = new Concurs("Cangurul", dataConcurs, 10, termenInscriereConcurs, 50, 8, "matematica", sp1, s1);
		concurs.asigneazaResponsabil(c1);
		
		//creare sedinta
		Data dataSedinta = new Data(21, 5, 2016);
		Data termenLimita = new Data(20, 5, 2015);
		Sedinta sedinta = new Sedinta("Sedinta 8A", dataSedinta,0, termenLimita, 30, 17, cls,s1);
		sedinta.asigneazaResponsabil(clase);
		sedinte.add(sedinta);
		
		//creare excursie
		ArrayList<ObiectivTuristic> obiective = new ArrayList<ObiectivTuristic>();
		Data dataExcursie = new Data(1, 6, 2016);
		Data termenLimitaExcursie = new Data(29, 5, 2016);
		obiective.add(new ObiectivTuristic("Castelul Peles", "Sinaia"));
		obiective.add(new ObiectivTuristic("Castelul Pelisor", "Sinaia"));
		
		Excursie excursie = new Excursie("Excursie la Sinaia", dataExcursie, 120, termenLimitaExcursie, 50, 8, obiective);
		excursie.asigneazaResponsabil(c2);
		
		//creare workshop
		Data dataWorkshop = new Data(27, 5, 2016);
		Data termenLimitaWorkshop = new Data(25, 5, 2016);
		Workshop workshop = new Workshop("Workshop HTML", dataWorkshop, 0, termenLimitaWorkshop, 20, 15, "HTML", s2);
		workshop.asigneazaResponsabil(c3);
		
		admin.adaugaActivitate(concurs);
		admin.adaugaActivitate(excursie);
		admin.adaugaActivitate(workshop);
		admin.adaugaActivitate(sedinta);
			
		//admin.adaugaActivitate(sponsori, sali, clase);
		
		Scanner s = new Scanner(System.in);
		String raspuns;
		do {
		int tipCont = alegereTipCont();
		   switch(tipCont) {
		   case 4: logareSecretara(secretara,listaElevi, listaProfesori);break;
		   case 5: logareSponsor(sponsori);break;
		   case 6: logareParinte(parinti, sedinte); break;
		   }
	     System.out.println("Continuati?Da/nu");
	     raspuns = s.nextLine();
		}while(raspuns.equals("da"));
	
		
		
		
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Elev e1 = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Elev e2 = new Elev("Bolboaca", "valeria", "2940621460046", 700);
		Elev e3 = new Elev("Cicu", "Alexandru", "1940621460044", 780);

		List<Elev> listaElevi = new ArrayList<Elev>();
		List<CadruDidactic> listaProfesori = new ArrayList<CadruDidactic>();
		List<Sponsor> sponsori = new ArrayList<Sponsor>();
		List<Clasa> clase = new ArrayList<Clasa>();
		List<Sala> sali = new ArrayList<Sala>();
		
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

		Administrator admin = new Administrator();
		admin.creareCont(e1);
		admin.creareCont(e2);
		admin.creareCont(e3);

		admin.creareCont(c1);
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

		if (tipCont == 1) {

		} else {
			System.out.println("Cont de elev");
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
		Activitate a = new Activitate("Sport", new Data(2016, 4, 25), 15, new Data(2016, 4, 29), 30, 10);
		//a.vizualizareDetalii();

		// Verificare functii Cadru Didactic 
		CadruDidactic cd = new CadruDidactic("Cicu", "Alexandru", "100110");
		cd.adaugaActivitate(a);
		cd.veziActivitatiCoordonate();

	}

}

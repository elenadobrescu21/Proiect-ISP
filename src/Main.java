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
		
		CadruDidactic c1 = new CadruDidactic("Popescu", "Ioana", "2940621460043", 1500, 2010);
		Clasa cls = new Clasa("8A", c1);
		e1.setClasa(cls);
		e2.setClasa(cls);
		e3.setClasa(cls);
		
		listaElevi.add(e1);
		listaElevi.add(e2);
		listaElevi.add(e3);
		
		Administrator admin = new Administrator();
		admin.creareContElev(e1);
		admin.creareContElev(e2);
		admin.creareContElev(e3);
		boolean logat = false;
		while(logat == false) {
		System.out.println("Logare ca Elev");
		System.out.println("Username:");
		Scanner scan= new Scanner(System.in);
		String username= scan.nextLine();
		System.out.println("Parola:");
		String parola = scan.nextLine();
		Cont contDeVerificat = new Cont(username,parola);
		for(Elev e: listaElevi) {
			if(contDeVerificat.equals(e.getCont())) {
				System.out.println("Logare cu succes");
				e.afiseazaInformatii();
				logat= true;
				break;
			}
			else
				System.out.println("Username sau parola incorecta");
		
		}
		}

	}

}

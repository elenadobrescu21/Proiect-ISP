import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.junit.internal.runners.model.EachTestNotifier;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	
	

	/**
	 * Teste Functie Complexa Dobrescu Elena
	 */
	@org.junit.Test
	public void testCreareContDuplicatCuCNP() {

		Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Administrator a = new Administrator();
		Cont c = new Cont("Dobrescu.Elena", "pppppp");
		a.adaugaContElev(c);
		a.creareContElev(e);
		Cont contElev = e.getCont();
		String username = e.getCont().getUsername();
		boolean OK;
		if (username.equals("Dobrescu.Elena0044")) {
			OK = true;
		} else
			OK = false;
		assertTrue("Contul a fost generat cum trebuie", OK);
	}

	@org.junit.Test
	public void testCreareContDuplicatFaraCNP() {

		Elev e = new Elev("Dobrescu", "Elena Alexandra", "2940621460044", 600);
		Administrator a = new Administrator();
		Cont c = new Cont("Dobrescu.Elena", "pppppp");
		a.adaugaContElev(c);
		a.creareContElev(e);
		Cont contElev = e.getCont();
		String username = e.getCont().getUsername();
		boolean OK;
		if (username.equals("Dobrescu.Elena_Alexandra")) {
			OK = true;
		} else
			OK = false;
		assertTrue("Contul a fost generat cum trebuie", OK);
	}

	@org.junit.Test
	public void testCreareContNeduplicat() {

		Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Administrator a = new Administrator();
		a.creareContElev(e);
		Cont contElev = e.getCont();
		String username = e.getCont().getUsername();
		boolean OK;
		if (username.equals("Dobrescu.Elena")) {
			OK = true;
		} else
			OK = false;
		assertTrue("Contul a fost generat cum trebuie", OK);
	}

	/**
	 * Teste Functie Complexa Bolboaca Valeria
	 */
	@org.junit.Test
	public void testAdaugaActivitate() {

		List<Sponsor> sponsori = new ArrayList<Sponsor>();
		List<Clasa> clase = new ArrayList<Clasa>();
		List<Sala> sali = new ArrayList<Sala>();
		Administrator admin = new Administrator();

		int numarActivitati = admin.getActivitati().size();

		Sala s1 = new Sala(12, 50, 1);
		Sala s2 = new Sala(10, 50, 1);
		Sala s3 = new Sala(11, 50, 1);

		sali.add(s1);
		sali.add(s2);
		sali.add(s3);

		Sponsor sp1 = new Sponsor("intel");
		Sponsor sp2 = new Sponsor("ibm");

		sponsori.add(sp1);
		sponsori.add(sp2);

		CadruDidactic c1 = new CadruDidactic("Popescu", "Ioana", "2940621460043");
		Clasa cls = new Clasa("8A", c1);
		clase.add(cls);
		admin.adaugaActivitate(sponsori, sali, clase);
		assertEquals(numarActivitati + 1, admin.getActivitati().size());
	}

	/**
	 * Teste Functie Complexa Cicu Alexandru
	 */

	// Inscriere in conditii normale, cazurile favorabile
	// Verificare dimensiune de activitati elev dupa inscriere
	@org.junit.Test
	public void testInscriereActivitate() {

		Administrator admin = new Administrator();
		Elev e1 = new Elev("Cicu", "Alexandru", "2940621460044", 500);
		int nrActivitati = e1.getActivitati().size();

		Activitate a1 = new Activitate("Fotbal", new Data(5, 12, 2016), 10, new Data(5, 12, 2017), 10, 10);
		Activitate a2 = new Activitate("Baschet", new Data(6, 12, 2016), 100, new Data(5, 12, 2018), 20, 10);
		Activitate a3 = new Activitate("School", new Data(7, 12, 2016), 150, new Data(5, 12, 2019), 20, 10);
		Activitate a4 = new Activitate("Facultate", new Data(8, 12, 2016), 200, new Data(5, 12, 2020), 20, 10);

		admin.adaugaActivitate(a1);
		admin.adaugaActivitate(a2);
		admin.adaugaActivitate(a3);
		admin.adaugaActivitate(a4);

		e1.inscrieLaActivitate(admin);

		assertEquals(nrActivitati + 1, e1.getActivitati().size());
	}

	// Verificare daca activitatea la care se inscrie
	// apare in activitatile elevului
	@org.junit.Test
	public void testActivitate() {

		Administrator admin = new Administrator();
		Elev e1 = new Elev("Cicu", "Alexandru", "2940621460044", 500);

		Activitate a1 = new Activitate("Fotbal", new Data(5, 12, 2016), 10, new Data(5, 12, 2017), 10, 10);
		admin.adaugaActivitate(a1);
		e1.inscrieLaActivitate(admin);
		boolean contine = e1.getActivitati().contains(a1);
		assertTrue(contine);
	}

	// Verificare format nume pt Sedinta
	// Daca se abandoneaza / Nu se lasa feedback nu trece
	@org.junit.Test
	public void testNumeFisier() {

		Administrator admin = new Administrator();
		Elev e1 = new Elev("Cicu", "Alexandru", "2940621460044", 500);
		Activitate a1 = new Activitate("Sedinta", new Data(5, 12, 2016), 10, new Data(5, 12, 2017), 10, 10);
		Activitate a2 = new Activitate("Concurs", new Data(6, 12, 2016), 100, new Data(5, 12, 2018), 20, 10);
		admin.adaugaActivitate(a1);
		admin.adaugaActivitate(a2);
		e1.inscrieLaActivitate(admin);

		File file = new File(e1.getNume() + e1.getPrenume() + "Sedinta.txt");
		boolean conditie = file.exists();
		assertTrue(conditie);

	}

	// Testare existenta fisier daca se doreste sa se lase feedback
	// Daca se abandoneaza inscrierea sau nu se lasa feedback - nu trece
	@org.junit.Test
	public void testFisier() {

		Administrator admin = new Administrator();
		Elev e1 = new Elev("Cicu", "Alexandru", "2940621460044", 500);
		Activitate a1 = new Activitate("Sedinta", new Data(5, 12, 2016), 10, new Data(5, 12, 2017), 10, 10);

		admin.adaugaActivitate(a1);
		e1.inscrieLaActivitate(admin);
		File file = new File("CicuAlexandruSedinta.txt");
		boolean conditie = file.exists();
		assertTrue(conditie);
	}

	/**
	 * Teste comune
	 */
	@org.junit.Test
	public void testToStringData() {

		Data d = new Data(21, 6, 2016);
		String expected = "21 Iunie 2016";
		boolean OK = expected.equals(d.toString());
		assertTrue("Data este corecta ", OK);
	}

}

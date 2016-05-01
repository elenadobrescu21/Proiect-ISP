import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.runners.model.EachTestNotifier;

import junit.framework.TestCase;

public class Test extends TestCase {

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

	
	
	@org.junit.Test
	public void testToStringData() {
		Data d = new Data(21, 6, 2016);
		String expected = "21 Iunie 2016";	
		boolean OK = expected.equals(d.toString());
		assertTrue("Data este corecta ", OK);
	}
	
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
		assertEquals(numarActivitati+1, admin.getActivitati().size());	
	} 
	
	
	
	
}

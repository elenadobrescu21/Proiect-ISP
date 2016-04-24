import static org.junit.Assert.*;

import org.junit.internal.runners.model.EachTestNotifier;

import junit.framework.TestCase;

public class Test extends TestCase {

	@org.junit.Test
	public void testCreareContDuplicatCuCNP() {
		Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Administrator a = new Administrator();
		Cont c = new Cont("Dobrescu.Elena", "pppppp");
		a.adaugaContElev(c);
		a.creareCont(e);
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
		a.creareCont(e);
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
		a.creareCont(e);
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
	public void testVerificareCont() {
		Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
		Administrator a = new Administrator();
		Cont c = new Cont("Dobrescu.Elena", "pppppp");
		a.adaugaContElev(c);
		a.creareCont(e);
		// boolean result = a.verificareCont(e);
		// assertTrue("Contul se gaseste in lista", result);
	}

}

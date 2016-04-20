import static org.junit.Assert.*;

import junit.framework.TestCase;

public class Test extends TestCase{
	
	
	@org.junit.Test
	public void testCreareContElevDuplicatCuCNP() {
	    Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
	    Administrator a = new Administrator();
	    Cont c = new Cont("Dobrescu.Elena", "pppppp");
	    a.adaugaContElev(c);
	    a.creareContElev(e);
	    Cont contElev = e.getCont();
	    String username = e.getCont().getUsername();
	     boolean OK;
	     if(username.equals("Dobrescu.Elena0044")) {
	    	 OK = true;
	     }
	     else
	    	 OK = false;
		assertTrue("Contul a fost generat cum trebuie" ,OK);
	}
	
	public void testCreareContElevDuplicatFaraCNP() {
	    Elev e = new Elev("Dobrescu", "Elena Alexandra", "2940621460044", 600);
	    Administrator a = new Administrator();
	    Cont c = new Cont("Dobrescu.Elena", "pppppp");
	    a.adaugaContElev(c);
	    a.creareContElev(e);
	    Cont contElev = e.getCont();
	    String username = e.getCont().getUsername();
	     boolean OK;
	     if(username.equals("Dobrescu.Elena_Alexandra")) {
	    	 OK = true;
	     }
	     else
	    	 OK = false;
		assertTrue("Contul a fost generat cum trebuie" ,OK);
	}
	
	
	
	@org.junit.Test
	public void testCreareContElevNeduplicat() {
	    Elev e = new Elev("Dobrescu", "Elena", "2940621460044", 600);
	    Administrator a = new Administrator();
	    a.creareContElev(e);
	    Cont contElev = e.getCont();
	    String username = e.getCont().getUsername();
	     boolean OK;
	     if(username.equals("Dobrescu.Elena")) {
	    	 OK = true;
	     }
	     else
	    	 OK = false;
		assertTrue("Contul a fost generat cum trebuie" ,OK);
	}

	

}

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCompozitie {
	Persoana persoana;
	Cont altCont;

	@Before
	public void setUp() throws Exception {
		persoana = new Persoana("Popescu", "Mihaela", "2940621460046");
		altCont = new Cont("username", "parola2");
	}

	@After
	public void tearDown() throws Exception {
		persoana = null;
		altCont = null;
	}
	
	@Test 
	public void testConstructor() {
		assertEquals(persoana.getCont().getUsername(), "username_default");
		assertEquals(persoana.getCont().getParola(), "parola_default");        
	}

	@Test
	public void testSetCont() {
		persoana.setCont(altCont);
		assertEquals(persoana.getCont().getUsername(), altCont.getUsername());
		assertEquals(persoana.getCont().getParola(), altCont.getParola());
		//verificarea faptului ca nu este asociatie
		altCont.setUsername("alt_username");
        assertFalse(persoana.getCont().getUsername().equals("alt_username"));		
	}
    
	@Test
	public void testGetCont() {
	Cont contPersoana = persoana.getCont();
    assertEquals(contPersoana.getUsername(), "username_default");
    assertEquals(contPersoana.getParola(), "parola_default");  
    //verificarea faptului ca se returneaza o copie
    assertNotSame(persoana.getCont(), contPersoana);
    contPersoana.setUsername("New_username");
    assertFalse(persoana.getCont().getUsername().equals("New_username"));
	}
}

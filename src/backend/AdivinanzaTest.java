package backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdivinanzaTest {
	
	private Adivinanza hola;
	

	@Before
	public void setUp() throws Exception {
		this.hola = new Adivinanza("hola");
		
	}

	
	
	@Test
	public void acertarLetra() {
		assertTrue(hola.intentar('a'));
	}
	
	
	@Test public void errarLetra() {
		assertFalse(hola.intentar('z'));
	}
	
	
	@Test
	public void estadoSinTerminar() {
		assertFalse(hola.estado());
	}

	@Test
	public void testEstado() {
		hola.intentar('h');
		hola.intentar('o');
		hola.intentar('l');
		hola.intentar('a');
		assertTrue(hola.estado());
		
	}

}

package backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiccionarioTest {
	
	private Diccionario espaniolFacil;
	private Diccionario espaniolMedio;
	private Diccionario espaniolDificil;
	

	@Before
	public void setUp() throws Exception {
		
		this.espaniolFacil   = new Diccionario(Idioma.ESPAÑOL, Dificultad.FACIL);
		this.espaniolMedio   = new Diccionario(Idioma.ESPAÑOL, Dificultad.MEDIO);
		this.espaniolDificil = new Diccionario(Idioma.ESPAÑOL, Dificultad.DIFICIL);
	}

	@Test
	public void palabraAdecuadaFacil() {
		String palabra = this.espaniolFacil.elegirPalabraAlAzar();
		int contador = 0;
		for (char i : palabra.toCharArray()) {
			contador++;
		}
		
		assertEquals(5,contador);
		
	}
	
	@Test
	public void palabraAdecuadaMedio() {
		String palabra = this.espaniolMedio.elegirPalabraAlAzar();
		int contador = 0;
		for (char i : palabra.toCharArray()) {
			contador++;
		}
		
		boolean esSeis = (contador == 6) ? true : false;
		boolean esSiete = (contador == 7) ? true : false;
		
		assertTrue(esSeis || esSiete);
		
	}
	
	@Test
	public void palabraAdecuadaDificil() {
		String palabra = this.espaniolDificil.elegirPalabraAlAzar();
		int contador = 0;
		for (char i : palabra.toCharArray()) {
			contador++;
		}
		
		
		assertTrue(contador >= 8);
		
	}
	

}

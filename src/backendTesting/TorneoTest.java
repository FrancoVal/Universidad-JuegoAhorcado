package backendTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.Dificultad;
import backend.EstadoJuego;
import backend.Idioma;
import backend.Torneo;
import backendExceptions.NoHayMasIntentosException;
import backendExceptions.NoPuedeJugarAISinoEsDesafiadaException;
import backendExceptions.NoPuedeRepetirLetraException;
import backendExceptions.NoTieneChancesException;

public class TorneoTest {

	private Torneo torneoArreglado;
	@Before
	public void setUp() throws Exception {
		this.torneoArreglado = new Torneo(Idioma.ESPANIOL, Dificultad.FACIL);
		this.torneoArreglado.perderTurno();
		this.torneoArreglado.desafiarAI("hola");
	}

	@Test
	public void test() {
		while(this.torneoArreglado.estadoTorneo().equals(EstadoJuego.JUGANDO)) {
			
			try {
				this.torneoArreglado.probarLetra('a');
				this.torneoArreglado.probarLetra('h');
				this.torneoArreglado.probarLetra('o');
				this.torneoArreglado.probarLetra('l');
				
			} catch (NoHayMasIntentosException | NoTieneChancesException | NoPuedeRepetirLetraException | NoPuedeJugarAISinoEsDesafiadaException e) {
				System.out.print(e);
			}
		}
	}

}

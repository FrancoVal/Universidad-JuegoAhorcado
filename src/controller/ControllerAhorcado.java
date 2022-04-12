package controller;

import javax.swing.JTextArea;

import backend.Dificultad;
import backend.EstadoJuego;
import backend.Idioma;
import backend.JuegoAhorcado;

public class ControllerAhorcado {

<<<<<<< Updated upstream
	public JuegoAhorcado modoNormal;
	public Torneo modoTorneo;
	public PruebaIA prueba;
	
	

	public void crearJuego(Idioma idioma, Dificultad dificultad, Modo modo, String palabra) {
		
		if (modo.equals(Modo.NORMAL)) {
			modoNormal = new JuegoAhorcado(idioma, dificultad);
		} else {
			prueba = new PruebaIA(idioma, dificultad,palabra);
		}
=======
	public JuegoAhorcado ahorcado;

	public void crearJuego(Idioma idioma, Dificultad dificultad) {
		ahorcado = new JuegoAhorcado(idioma, dificultad);
>>>>>>> Stashed changes
	}
	
	
		
	
	

	public String getPalabra() {
		return ahorcado.getPalabra();
	}

	public String getIntentosRestantes() {
<<<<<<< Updated upstream
		int intentos = modoNormal.cantidadDeIntentosRestantes();
		String labelIntentos = Integer.toString(intentos);
		return labelIntentos;
=======
		return ahorcado.getIntentosRestantes();
>>>>>>> Stashed changes
	}

	public boolean getEstado() {
		return ahorcado.seguimosJugando();
	}

	public void intentar(String tecla) {
<<<<<<< Updated upstream
		char c = tecla.charAt(0);
		try {
			modoNormal.turno(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verificarVictoria() {
		return (modoNormal.estado().equals(EstadoJuego.GANADO)) ? true : false;
=======
		ahorcado.intentar(tecla);
	}

	public boolean verificarVictoria() {
		return ahorcado.verificarVictoria();
>>>>>>> Stashed changes
	}

	public void actualizarPantalla() {
		getIntentosRestantes();
		getPalabra();
		getEstado();
	}

	public int getTurnos() {
		return ahorcado.getTurnos();
	}

	public void reiniciarValorTurnos(Dificultad dificultad) {
		ahorcado.setTurnos(dificultad);
	}

	public String getLetrasIncorrectas() {
<<<<<<< Updated upstream
		String letrasIncorrectas = String.valueOf(modoNormal.verLetrasFallidasUtilizadas());
		return letrasIncorrectas;
	}
	
	public boolean verificarInput(JTextArea input) {
		return this.prueba.verificarInput(input);
=======
		return ahorcado.getLetrasIncorrectas();
>>>>>>> Stashed changes
	}

}

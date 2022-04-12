package controller;

import backend.Dificultad;
import backend.Idioma;
import backend.JuegoAhorcado;

public class ControllerAhorcado {

	public JuegoAhorcado ahorcado;

	public void crearJuego(Idioma idioma, Dificultad dificultad) {
		ahorcado = new JuegoAhorcado(idioma, dificultad);
	}

	public String getPalabra() {
		return ahorcado.getPalabra();
	}

	public String getIntentosRestantes() {
		return ahorcado.getIntentosRestantes();
	}

	public boolean getEstado() {
		return ahorcado.seguimosJugando();
	}

	public void intentar(String tecla) {
		ahorcado.intentar(tecla);
	}

	public boolean verificarVictoria() {
		return ahorcado.verificarVictoria();
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
		return ahorcado.getLetrasIncorrectas();
	}

}

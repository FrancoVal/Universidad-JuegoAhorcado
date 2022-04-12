package controller;

import backend.Dificultad;
import backend.Idioma;
import backend.JuegoAhorcado;
import backend.Modo;
import backend.PruebaIA;
import backend.Torneo;

public class ControllerAhorcado {

	public JuegoAhorcado modoNormal;
	public Torneo modoTorneo;
	public PruebaIA prueba;

	public void crearJuego(Idioma idioma, Dificultad dificultad, Modo modo, String palabra) {

		if (modo.equals(Modo.NORMAL)) {
			modoNormal = new JuegoAhorcado(idioma, dificultad);
		} else {
			prueba = new PruebaIA(idioma, dificultad, palabra);
		}
	}

	public String getPalabra() {
		return modoNormal.getPalabra();
	}

	public String getIntentosRestantes() {
		return modoNormal.getIntentosRestantes();
	}

	public boolean getEstado() {
		return modoNormal.seguimosJugando();
	}

	public void intentar(String tecla) {
		modoNormal.intentar(tecla);
	}

	public void almacenarPalabraUsuario(String palabra) {
		prueba.setPalabraIA(palabra);
	}

	public void juegaIA() {
		prueba.juegaIA();
	}

	public boolean verificarVictoria() {
		return modoNormal.verificarVictoria();
	}

	public void actualizarPantalla() {
		getIntentosRestantes();
		getPalabra();
		getEstado();
	}

	public int getTurnos() {
		return modoNormal.getTurnos();
	}

	public void reiniciarValorTurnos(Dificultad dificultad) {
		modoNormal.setTurnos(dificultad);
	}

	public String getLetrasIncorrectas() {
		return modoNormal.getLetrasIncorrectas();
	}

}

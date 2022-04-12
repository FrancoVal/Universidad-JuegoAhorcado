package controller;

import javax.swing.JTextArea;

import backend.Dificultad;
import backend.EstadoJuego;
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
			prueba = new PruebaIA(idioma, dificultad,palabra);
		}
	}
	
	
		
	
	

	public String getPalabra() {
		return modoNormal.getPalabra();
	}

	public String getIntentosRestantes() {
		int intentos = modoNormal.cantidadDeIntentosRestantes();
		String labelIntentos = Integer.toString(intentos);
		return labelIntentos;
	}

	public boolean getEstado() {
		return modoNormal.seguimosJugando();
	}

	public void intentar(String tecla) {
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
		String letrasIncorrectas = String.valueOf(modoNormal.verLetrasFallidasUtilizadas());
		return letrasIncorrectas;
	}
	
	public boolean verificarInput(JTextArea input) {
		return this.prueba.verificarInput(input);
	}

}

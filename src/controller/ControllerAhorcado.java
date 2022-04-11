package controller;

import backend.Adivinanza;
import backend.Dificultad;
import backend.EstadoJuego;
import backend.Idioma;
import backend.JuegoAhorcado;
import backend.Modo;
import backend.Torneo;

public class ControllerAhorcado {

	JuegoAhorcado modoNormal;
	Torneo modoTorneo;

	public void crearJuego(Idioma idioma, Dificultad dificultad, Modo modo) {
		if (modo.equals(Modo.NORMAL)) {
			modoNormal = new JuegoAhorcado(idioma, dificultad);
		} else {
			modoTorneo = new Torneo(idioma, dificultad);
		}
	}

	public int cantidadIntentos() {
		return modoNormal.cantidadDeIntentosRestantes();
	}

	public String getPalabra() {
		return modoNormal.getPalabra();
	}
	
	public String getIntentosRestantes() {
		int intentos =	modoNormal.cantidadDeIntentosRestantes();
		String labelIntentos = Integer.toString(intentos);	
		return labelIntentos;
	}
	
	public boolean getEstado() {
		return modoNormal.seguimosJugando();
	}
	
	public void intentar(String tecla){
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

//	public char[] verPalabraConstruida() {
//		System.out.println(modoNormal.verPalabraConstruida());
//		return modoNormal.verPalabraConstruida();
//	}

}

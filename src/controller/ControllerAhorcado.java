package controller;

import backend.Dificultad;
import backend.Idioma;
import backend.JuegoAhorcado;
import backend.Modo;
import backend.Torneo;

public class ControllerAhorcado {
	
	JuegoAhorcado modoNormal;
	Torneo modoTorneo;
	
	
	public void crearJuego(Idioma idioma, Dificultad dificultad, Modo modo) {
		if(modo.equals(Modo.NORMAL)) {
			modoNormal = new JuegoAhorcado(idioma, dificultad);
		}else {
			modoTorneo = new Torneo(idioma,dificultad);
		}
	}
	
//	public char[] verPalabraConstruida() {
//		System.out.println(modoNormal.verPalabraConstruida());
//		return modoNormal.verPalabraConstruida();
//	}

}

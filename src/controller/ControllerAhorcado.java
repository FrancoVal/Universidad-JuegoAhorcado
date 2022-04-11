package controller;

import backend.Dificultad;
import backend.Idioma;
import backend.JuegoAhorcado;
import backend.Modo;
import backend.Torneo;

public class ControllerAhorcado {
	
	
	public void crearJuego(Idioma idioma, Dificultad dificultad, Modo modo) {
		if(modo.equals(Modo.NORMAL)) {
			JuegoAhorcado modoNormal = new JuegoAhorcado(idioma, dificultad);
		}else {
			Torneo modoTorneo = new Torneo(idioma,dificultad);
		}
	}

}

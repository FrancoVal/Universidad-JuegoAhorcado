package controller;

import backend.Dificultad;
import backend.Idioma;
import backend.JuegoAhorcado;

public class ControllerAhorcado {
	
	
	public void crearJuego(Idioma idioma, Dificultad dificultad) {
		JuegoAhorcado juego = new JuegoAhorcado(idioma, dificultad);
	}

}

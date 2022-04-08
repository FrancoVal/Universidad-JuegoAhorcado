package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Diccionario {
	// creamos un listado para poner las palabras del juego.

	private List<String> palabras = new ArrayList<>();

	public static void main(String[] args) {

		Diccionario ejemplo = new Diccionario(Idioma.ESPAÑOL, Dificultad.FACIL);
		System.out.println(ejemplo.elegirPalabraAlAzar());
	}

	public Diccionario(Idioma idioma, Dificultad dificultad) {

		try {
			Scanner escaneo = new Scanner(new File(
					"src/data/" + idioma.nombre() + "/" + dificultad.nombre() + ".txt"));

			while (escaneo.hasNext()) {
				this.palabras.add(removerCaracteresEspeciales(escaneo.nextLine()));
			}

		} catch (FileNotFoundException e) { //
			System.out.println("Existen problemas para leer el diccionario del disco");
			e.printStackTrace();
		}

	}

	// remueve caracteres especiales de las palabras.
	public static String removerCaracteresEspeciales(String cadena) {
		cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
		cadena = cadena.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return cadena;
	}

	public String elegirPalabraAlAzar() {

		// generamos un valor random
		Random indiceRandom = new Random();

		/*
		 * decimos que "palabra" va a ser una palabra random del listado y la elegimos
		 * sabiendo que el random se va a generar entre 0 y el maximo del listado -1
		 *
		 */
		String palabraAlAzar = this.palabras.get(indiceRandom.nextInt(this.palabras.size()));

		System.out.println(palabraAlAzar);
		return palabraAlAzar;
	}

}
package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Backend {
	// creamos un listado para poner las palabras del juego.

	static List<String> listado = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println(generarListado(Idioma.ESPAÑOL));
		System.out.println(elegirPalabra(Idioma.ESPAÑOL));
	}

	public static List<String> generarListado(Idioma idioma) {
		
		try {
			Scanner escaneo = new Scanner(new File("src/data/lista" + idioma.nombre() + ".txt"));

			while (escaneo.hasNext()) {
				listado.add(removerCaracteresEspeciales(escaneo.nextLine()));
			}

		} catch (FileNotFoundException e) { //
			System.out.println("problemas");
			e.printStackTrace();
		}

		// devolvemos el listado de palabras.
		return listado;
	}

	// remueve caracteres especiales de las palabras.
	public static String removerCaracteresEspeciales(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return str;
	}

	public static String elegirPalabra(Idioma idioma) {

		List<String> listaPalabras = generarListado(idioma);

		// generamos un valor random
		Random indiceRandom = new Random();

		/*
		 * decimos que "palabra" va a ser una palabra random del listado y la elegimos
		 * sabiendo que el random se va a generar entre 0 y el maximo del listado -1
		 *
		 */
		String palabra = listaPalabras.get(indiceRandom.nextInt(listaPalabras.size()));

		System.out.println(palabra);
		return palabra;
	}

}
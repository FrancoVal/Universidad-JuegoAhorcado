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
		Random random = new Random();
		int indiceRandom = random.nextInt(this.palabras.size());

		String palabraAlAzar = this.palabras.get(indiceRandom);

		
		return palabraAlAzar;
	}

}
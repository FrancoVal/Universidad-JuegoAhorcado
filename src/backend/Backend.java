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
		System.out.println(generarListado("español"));
		System.out.println(elegirPalabra(listado));
	}

	public static List<String> generarListado(String idioma) {
		/*
		 * el try catch esta unicamente para que java no de problemas ya que es
		 * imposible se introduzca una variable de idioma que no tenga listado
		 * existente.
		 */
		try {
			// cambiamos segun el idioma.
			switch (idioma) {
			case "español":
				// leemos el archivo con las palabras y las pasamos a un arraylist.
				Scanner escaneoEspañol = new Scanner(new File("src/data/listaEspañol.txt"));
				// siempre y cuando haya una palabra mas, seguimos agregando.
				while (escaneoEspañol.hasNext()) {
					/*
					 * si te preguntas, ¿que hace este metodo aca? es para atajar palabras que estan
					 * en el txt que tengan tildes, o en frances algun caracter raro.
					 */
					listado.add(removerCaracteresEspeciales(escaneoEspañol.nextLine()));
				}
				break;
			case "ingles":
				Scanner escaneoIngles = new Scanner(new File("src/data/listaIngles.txt"));
				while (escaneoIngles.hasNext()) {
					listado.add(removerCaracteresEspeciales(escaneoIngles.nextLine()));
				}
				break;
			case "frances":
				Scanner escaneoFrances = new Scanner(new File("src/data/listaFrances.txt"));
				while (escaneoFrances.hasNext()) {
					listado.add(removerCaracteresEspeciales(escaneoFrances.nextLine()));
				}
				break;
			}
		} catch (FileNotFoundException e) { // ¿Tendria que ir "filenotfoundexception" pero no me lo toma?
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

	public static String elegirPalabra(List<String> listaPalabras) {
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

package backend;

public class Adivinanza {

	private char[] palabra;
	private boolean[] descubrimiento;
	private int longitud;

	public Adivinanza(String palabraAAdivinar) {

		this.longitud = palabraAAdivinar.length();
		this.palabra = new char[longitud];
		this.descubrimiento = new boolean[longitud];

		this.construirSecuencia(palabraAAdivinar);
	}

	/**
	 * Construye la lista de caracteres de la palabra a descubrir y la lista
	 * booleana (@see descubrimiento) en falso para iniciar la adivinanza.
	 **/
	private void construirSecuencia(String palabraAAdivinar) {

		for (int i = 0; i < this.longitud; i++) {
			this.palabra[i] = palabraAAdivinar.charAt(i);
			this.descubrimiento[i] = false;
		}
	}

	/**
	 * Probar si una letra está contenida en la adivinanza. Si la letra existe en
	 * la palabra de la adivinanza, esta función también pide informar dicho
	 * descubrimiento.
	 * 
	 * @see informarDescubrimiento
	 * 
	 * @param letra. Es un char que representa la letra candidata para ver si se
	 *               encuentra en la adivinanza
	 * @return verdadero en caso de que haya una o más coincidencias o falso en
	 *         caso de no haber acertado.
	 */
	public boolean intentar(char letra) {

		boolean existeCoincidencia = false;
		int contadorPosiciones = 0;

		for (char i : this.palabra) {
			if (sonLaMismaLetra(letra, i)) {
				existeCoincidencia = true;
				this.informarDescubrimiento(contadorPosiciones);
			}
			contadorPosiciones++;
		}

		return existeCoincidencia;
	}

	private void informarDescubrimiento(int posicion) {
		this.descubrimiento[posicion] = true;
	}

	/**
	 * Obtener el estado de la adivinanza. Es decir si se acertó a cada una de
	 * lasletras o si todavía quedan letra para adivinar.
	 * 
	 * @return verdadero si todas las letras fueron adivinadas. Falso en caso de que
	 *         todavía falten por adivinar.
	 */
	public boolean descubierta() {

		boolean acumuladorTodasLasLetrasFueronDescubiertas = true;

		for (boolean i : this.descubrimiento) {
			acumuladorTodasLasLetrasFueronDescubiertas = acumuladorTodasLasLetrasFueronDescubiertas && i;
		}

		return acumuladorTodasLasLetrasFueronDescubiertas;
	}

	static public boolean sonLaMismaLetra(char a, char b) {
		return a == b ? true : false;
	}

	public boolean[] obtenerListadoDeAciertos() {
		return this.descubrimiento;
	}

	public char[] obtenerLetrasDescubiertas() {
		// mostrar letras de la palabra a medida que se descubren
		char[] palabraParcial = new char[this.palabra.length];

		for (int i = 0; i < this.longitud; i++) {

			if (this.descubrimiento[i]) {
				palabraParcial[i] = this.palabra[i];
			} else {
				palabraParcial[i] = '*';
			}

		}

		return palabraParcial;

	}

}
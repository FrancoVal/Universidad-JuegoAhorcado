package backend;

public class PPruebaIA {

	private Idioma idioma;
	private Dificultad dificultad;
	private Adivinanza adivinanza;

	private int intentosFallidosRestantes;
	private char[] listadoLetrasFallidas;

	private String palabra;

	public PPruebaIA(Idioma idioma, Dificultad dificultad, String palabra) {

		this.idioma = idioma;
		this.dificultad = dificultad;
		this.intentosFallidosRestantes = dificultad.intentos();
		this.listadoLetrasFallidas = new char[this.intentosFallidosRestantes];
		this.palabra = palabra;
		this.crearAdivinanza();
	
		//CHEAT
		System.out.println(this.palabra);
	}

	private void crearAdivinanza() {

		this.adivinanza = new Adivinanza(this.palabra);

	}

	// INTENTOS
	public boolean quedanIntentos() {
		return (this.intentosFallidosRestantes > 0) ? true : false;
	}

	private void restarUnIntento() {
		this.intentosFallidosRestantes--;
	}

	public int cantidadDeIntentosRestantes() {
		return this.intentosFallidosRestantes;
	}
	// fin de INTENTOS

	// ESTADO
	public EstadoJuego estado() {

		if (this.quedanIntentos()) {

			return (this.adivinanza.descubierta()) ? EstadoJuego.GANADO : EstadoJuego.JUGANDO;

		} else {
			return EstadoJuego.PERDIDO;
		}

	}

	public boolean seguimosJugando() {
		return (this.estado().equals(EstadoJuego.JUGANDO)) ? true : false;
	}

	public char[] verPalabraConstruida() {
		return this.adivinanza.obtenerLetrasDescubiertas();
	}

	public char[] verLetrasFallidasUtilizadas() {
		return this.listadoLetrasFallidas;
	}
	// fin de ESTADO

	// TURNO
	public void turno(char letra) throws Exception {
		if (this.seguimosJugando()) {
			this.operacionesDelTurno(letra);
		} else {
			throw new Exception("El juego ha finalizado, no se pueden intentar más turnos");
		}
	}

	private void operacionesDelTurno(char letra) {
		if (!this.adivinanza.intentar(letra)) {
			this.restarUnIntento();
			this.listadoLetrasFallidas[this.dificultad.intentos() - this.intentosFallidosRestantes - 1] = letra;
		}
	}
	// fin de TURNO

	public String getPalabra() {
		String palabra = "";
		StringBuilder sb = new StringBuilder();
		for (char c : verPalabraConstruida()) {
			sb.append(c);
			palabra = sb.toString();
		}
		return palabra;
	}

	public int getTurnos() {
		return this.intentosFallidosRestantes;
	}

	public void setTurnos(Dificultad dificultad) {
		this.intentosFallidosRestantes = dificultad.intentos();
	}

}

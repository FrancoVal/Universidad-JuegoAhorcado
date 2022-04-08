package backend;

public class JuegoAhorcado {

	private Idioma idioma;
	private Dificultad dificultad;
	private Adivinanza adivinanza;
	
	private int intentosFallidosRestantes;
	private char[] listadoLetrasFallidas;
	
	private String palabra;
	
	
	
	public JuegoAhorcado(Idioma idioma, Dificultad dificultad) {
		
		this.crearCaracBasicas(idioma, dificultad);
		this.crearAdivinanza();

	}
	
	private void crearCaracBasicas(Idioma idioma, Dificultad dificultad) {
		
		this.idioma = idioma;
		this.dificultad = dificultad;
		this.intentosFallidosRestantes = dificultad.intentos();
		this.listadoLetrasFallidas = new char[this.intentosFallidosRestantes];
		
	}
	
	private void crearAdivinanza() {
		
		Diccionario diccionario = new Diccionario(this.idioma, this.dificultad);
		this.palabra = diccionario.elegirPalabraAlAzar();
		adivinanza = new Adivinanza(this.palabra);
		
	}
	
	// INTENTOS
	public boolean quedanIntentos() {
		return (this.intentosFallidosRestantes > 0) ? true : false;
	}
	
	private void restarUnIntento() {
		this.intentosFallidosRestantes-=1;
	}
	// fin de INTENTOS
	
	
	//ESTADO
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
	// fin de ESTADO
	
	//TURNO
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
			this.listadoLetrasFallidas[this.dificultad.intentos() - this.intentosFallidosRestantes] = letra;
		}
	}
	//fin de TURNO
	
	
	
	
	
	
}



package backend;

public class Torneo {

	private Dificultad dificultadActual;
	private Idioma idiomaActual;
	private Jugador turnoActual;

	private int puntosJugador;
	private int puntosIA;

	private int nroDeSet;
	final int maximoDeSets = 3;

	private JuegoAhorcado ahorcado;

	public enum Jugador {
		JUGADOR, AI;
	}

	public Torneo(Idioma idioma, Dificultad dificultad) {

		this.idiomaActual = idioma;
		this.dificultadActual = dificultad;
		this.turnoActual = Jugador.JUGADOR;

		this.nroDeSet = 1;
		this.puntosJugador = 0;
		this.puntosIA = 0;

	}

	private void comenzarTurno() {
		this.ahorcado = new JuegoAhorcado(this.idiomaActual, this.dificultadActual);

	}

	public void jugarTurno(char letra) {

		if (this.ahorcado.quedanIntentos()) {
			try {
				this.ahorcado.turno(letra);
			} catch (Exception e) {
				// @TODO: perder y dar error

			}
		} else {
			this.cambiarTurno();
		}
	}

	private void cambiarTurno() {
		if (this.turnoActual == Jugador.JUGADOR) {
			this.turnoActual = Jugador.AI;
		} else {
			this.turnoActual = Jugador.JUGADOR;
			this.nuevoSet();
		}
	}

	private void nuevoSet() {
		this.nroDeSet++;
	}

}

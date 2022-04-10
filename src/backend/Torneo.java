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
  private String desafioPropuestoPorJugador;

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

  private void nuevoAhorcado() {
	  if (juegaElHumano()) {
		  this.ahorcado = new JuegoAhorcado(this.idiomaActual, this.dificultadActual);
	  } 
	  else if (this.haSidoDesafiadaLaAI()) {
			  this.ahorcado = new JuegoAhorcado(this.idiomaActual, this.dificultadActual, this.desafioPropuestoPorJugador);
			  this.desafioPropuestoPorJugador = null;
		  } else {
			  this.ahorcado = null;
		  }
		 
	  
  }
  public void probarLetra(char letra)
      throws NoHayMasIntentosException, NoTieneChancesException, 
      NoPuedeRepetirLetraException, NoPuedeJugarAISinoEsDesafiadaException {

    /*
     * Esto se está refactoreando más abajo, de recibir una exception similar
     */
    if (!this.ahorcado.quedanIntentos()) {
      throw new NoHayMasIntentosException("No se puede probar letra \n" +
          "Razón: No quedan intentos, el turno de este jugador debería haber terminado");
    }

    if (!this.elJugadorActualTieneChances()) {
      throw new NoTieneChancesException("No se puede probar letra \n" +
          "Razón: El jugador actual no tiene posibilidades de ganar o empatar \n" +
          "Este torneo debería haber finalizado ya");
    }

    if (!this.esteSetPermiteRepetirLetrasUsadas() && this.estaLetraFueUtilizada(letra)) {
      throw new NoPuedeRepetirLetraException("No se puede probar letra \n" +
          "Según la dificultad, este set ayuda al jugador a no cometer el error de repetir letras usadas \n" +
          "Y la letra indicada está repetida");
    }
    
    if (this.ahorcado == null && !this.juegaElHumano()) {
    	throw new NoPuedeJugarAISinoEsDesafiadaException("No se puede probar letra \n" +
    	          "Es turno de la AI pero no se pudo crear un ahorcado para que juegue \n" +
    	          "porque el usuario no creó ningún desafio");
    }
    
    
    
    try {
      this.ahorcado.turno(letra);

      if (this.ahorcado.estado().equals(EstadoJuego.GANADO) ||
          this.ahorcado.estado().equals(EstadoJuego.PERDIDO)) {
        this.cambiarTurno();
      }
    } catch (Exception e) {
      throw new NoHayMasIntentosException("No se puede probar letra \n" +
          "Razón: No quedan intentos, el turno de este jugador debería haber terminado");
    }

  }

  public Idioma getIdioma() {
    return this.idiomaActual;
  }

  public Dificultad getDificultad() {
    return this.dificultadActual;
  }

  /*
   * Las chances son de ganar o al menos de empatar
   */
  public boolean elJugadorActualTieneChances() {

    int cantidadDeSetsRestantes = this.maximoDeSets - nroDeSet - 1;

    int cantidadMaximaDePuntosDelJugadorActual = cantidadDeSetsRestantes + this.puntajeJugadorActual();

    return cantidadMaximaDePuntosDelJugadorActual >= this.puntajeOtroJugador() ? true : false;
  }

  public int puntajeJugadorActual() {
    return this.juegaElHumano() ? this.puntosJugador : this.puntosIA;

  }

  public int puntajeOtroJugador() {
    return this.juegaElHumano() ? this.puntosIA : this.puntosJugador;
  }

  public boolean esteSetPermiteRepetirLetrasUsadas() {

    return this.dificultadActual.equals(Dificultad.FACIL) ? false : true;

  }

  public boolean estaLetraFueUtilizada(char letra) {

    return (buscarEnListaDeLetra(letra, this.ahorcado.verLetrasFallidasUtilizadas()) ||
        buscarEnListaDeLetra(letra, this.ahorcado.verPalabraConstruida()));

  }

  private static boolean buscarEnListaDeLetra(char letra, char[] lista) {

    boolean hallazgo = false;

    for (char i : lista) {
      if (i == letra) {
        hallazgo = true;
      }
    }

    return hallazgo;

  }

  private void cambiarTurno() {
    if (this.juegaElHumano()) {
    	this.turnoActual = Jugador.AI;
    } else {
      this.pasarNuevoSet();
      this.turnoActual = Jugador.JUGADOR;
    }
  }

  private void pasarNuevoSet() {
    this.nroDeSet++;

  }

  /*
   * El estado del juego siempre es desde el punto de vista del usuario no de la
   * AI ni del jugador actual
   */
  public EstadoJuego estadoTorneo() {

    if ( this.quedanSetsPorJugar() && this.elJugadorActualTieneChances()) {
      return EstadoJuego.JUGANDO;
    } else {
    	return this.jugadorHumanoTieneVentaja() ? EstadoJuego.GANADO : EstadoJuego.PERDIDO;
    }
    
  }
  
  public boolean quedanSetsPorJugar() {
	  return this.maximoDeSets >= this.nroDeSet ? true : false;
  }
  
  public boolean jugadorHumanoTieneVentaja() {
	  return this.puntosJugador >= this.puntosIA ? true : false;
  }
  
  public void perderTurno() throws LasMaquinasNoSeRindenException {
	  if (juegaElHumano()) {
		  this.cambiarTurno();
	  } else {
		  throw new LasMaquinasNoSeRindenException("No se puede perder el turno \n" +
		          "La IA nunca se da por vencida.");
	  }
  }
  
  public boolean juegaElHumano() {
	  return this.turnoActual.equals(Jugador.JUGADOR) ? true : false;
  }
  
  public void desafiarAI(String palabra) {
	  
	  this.desafioPropuestoPorJugador = palabra;
	  
	  if (this.ahorcado == null && !this.juegaElHumano()) {
		  this.nuevoAhorcado();
	  }
  }
  
  public boolean haSidoDesafiadaLaAI() {
	  return this.desafioPropuestoPorJugador == null ? false : true;
  }
  
  

}

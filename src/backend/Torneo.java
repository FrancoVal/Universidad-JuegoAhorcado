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

  public void probarLetra(char letra)
      throws NoHayMasIntentosException, NoTieneChancesException, NoPuedeRepetirLetraException {

    if (!this.ahorcado.quedanIntentos()) {
      throw new NoHayMasIntentosException("No se puede probar letra \n" +
          "Razón: No quedan intentos, el turno de este jugador debería haber terminado");
    }

    if (!this.elJugadorActualTieneChances()) {
      throw new NoTieneChancesException("No se puede probar letra \n" +
          "Razón: El jugador actual no tiene posibilidades de ganar o empatar \n" +
          "Este torneo debería haber finalizado ya");
    }

    if (!this.esteSetPermiteLetrasFallidasRepetidas() && this.estaLetraFueUtilizada(letra)) {
      throw new NoPuedeRepetirLetraException("No se puede probar letra \n" +
          "Según la dificultad, este set ayuda al jugador a no cometer el error de repetir letras usadas \n" +
          "Y la letra indicada está repetida");
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
    return this.turnoActual.equals(Jugador.JUGADOR) ? this.puntosJugador : this.puntosIA;

  }

  public int puntajeOtroJugador() {
    return this.turnoActual.equals(Jugador.JUGADOR) ? this.puntosIA : this.puntosJugador;
  }

  public boolean esteSetPermiteLetrasFallidasRepetidas() {

    return this.dificultadActual.equals(Dificultad.FACIL) ? false : true;

  }

  public boolean estaLetraFueUtilizada(char letra) {
  
    return (buscarEnListaDeLetra(letra,this.JuegoAhorcado.))

  }

  private boolean buscarEnListaDeLetra(char letra, char[] lista) {

    boolean hallazgo = false;

    for (char i : lista) {
      if (i == letra) {
        hallazgo = true;
      }
    }

    return hallazgo;

  }
}

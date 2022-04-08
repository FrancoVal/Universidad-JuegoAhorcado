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
	
	
}

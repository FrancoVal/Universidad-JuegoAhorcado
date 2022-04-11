package backend;

public enum Dificultad {
	FACIL("Facil", 5),
	MEDIO("Medio", 3),
	DIFICIL("Dificil", 1);
	
	
private String nombre;
private int intentosFallidosPosibles;
	
	
	private Dificultad(String nombre, int intentos) {
		this.nombre = nombre;
		this.intentosFallidosPosibles = intentos;
	}
	
	
	public String nombre() {
		return this.nombre;
	}
	
	public int intentos() {
		return this.intentosFallidosPosibles;
	}
	
	public Dificultad siguienteNivel() {
		if (this.equals(Dificultad.FACIL)) {
			return Dificultad.MEDIO;
		} else {
			return Dificultad.DIFICIL;
		}
	}
}

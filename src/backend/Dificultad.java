package backend;

public enum Dificultad {
	FACIL("Facil", 8),
	MEDIO("Medio", 7),
	DIFICIL("Dificil", 6);
	
	
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
}

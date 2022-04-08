package backend;

public enum Dificultad {
	FACIL("Facil"),
	MEDIO("Medio"),
	DIFICIL("Dificil");
	
	
private String nombre;
	
	
	private Dificultad(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String nombre() {
		return this.nombre;
	}
}

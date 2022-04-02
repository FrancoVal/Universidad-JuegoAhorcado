package backend;

public enum Idioma {
	ESPAÑOL ("Español"), 
	INGLES ("Ingles"), 
	FRANCES ("Frances");
	
	private String nombre;
	
	
	private Idioma(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String nombre() {
		return this.nombre;
	}

}

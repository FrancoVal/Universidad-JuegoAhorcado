package backend;

public enum Idioma {
	ESPAÑOL ("español"), 
	INGLES ("ingles"), 
	FRANCES ("frances");
	
	private String nombre;
	
	
	private Idioma(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String nombre() {
		return this.nombre;
	}

}

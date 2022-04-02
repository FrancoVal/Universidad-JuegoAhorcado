package backend;

public class Adivinanza {

	
	private char[] palabra; 
	private boolean[] descubrimiento;
	
	public Adivinanza (String desafio) {
		this.construirSecuencia(desafio);
	}
	
	
	private void construirSecuencia(String desafio) {
		
		this.palabra = new char[desafio.length()];
		this.descubrimiento = new boolean[desafio.length()];
		
		for (int i = 0; i < desafio.length(); i++) {
			this.palabra[i] = desafio.charAt(i);	
			this.descubrimiento[i] = false;
		}
	}
	
	
	public boolean intentar(char letra) {
		
		boolean existeCoincidencia = false;
		int contadorPosiciones = 0;
		
		for (char i : this.palabra ) {
			if (sonLaMismaLetra(letra,i)) {
				existeCoincidencia = true;
				this.informarDescubrimiento(contadorPosiciones);
			}
			contadorPosiciones++;
		}
		
		
		return existeCoincidencia;
	}
	
	
	
	private void informarDescubrimiento(int posicion) {
		this.descubrimiento[posicion] = true;
	}
	
	
	public boolean estado() {
		
		boolean acumuladorTodasLasLetrasFueronDescubiertas = true;
		
		for (boolean i : this.descubrimiento ) {
			acumuladorTodasLasLetrasFueronDescubiertas = acumuladorTodasLasLetrasFueronDescubiertas && i;
		}
		
		return acumuladorTodasLasLetrasFueronDescubiertas;
	}
	
	
	static public boolean sonLaMismaLetra (char a, char b) {
		return a == b ? true : false;
	}
	
	
	
	
	
}
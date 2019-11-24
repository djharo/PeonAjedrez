package org.iesalandalus.programacion.peonajedrez;

public class Peon {
	
	private Color color;
	
	private Posicion posicion;
	
	public Peon() {
		
		this.color = Color.NEGRO;
		this.posicion = new Posicion (7, 'd');
	}
	
	public Peon(Color color) {
		
		setColor(color);
		
		if(Color.BLANCO.equals(this.color)) {
			
			this.posicion = new Posicion(2, 'd');
		
		}else {
			
			this.posicion = new Posicion(7, 'd');
		}
	}
	
	public Peon(Color color, char columnaInicial) {
		
		setColor(color);
		
		if(Color.BLANCO.equals(this.color)) {
			
			this.posicion = new Posicion(2, columnaInicial);
		
		} else {
		
		this.posicion = new Posicion(7, columnaInicial);
		
		}
	}
	
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		
		this.color = color;
	}

	public Posicion getPosicion() {
		return new Posicion(posicion);
	}

	public void setPosicion(Posicion posicion) {
		
		this.posicion = new Posicion(posicion);
	}
}

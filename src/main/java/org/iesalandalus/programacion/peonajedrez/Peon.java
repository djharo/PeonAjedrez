package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

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
	
	public void mover(Direccion direccion) throws OperationNotSupportedException {
		
		if (direccion == null) {
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}

		switch (direccion) {
			
			case IZQUIERDA:
				try {
					
					if(Color.BLANCO.equals(this.color)){
						
						int nuevaFila = this.posicion.getFila() + 1;
						
						char nuevaColumna = (char) (this.posicion.getColumna() - 1);
						
						this.posicion = new Posicion(nuevaFila, nuevaColumna);
					
					} else {
						
						int nuevaFila = this.posicion.getFila() - 1;
						
						char nuevaColumna = (char) (this.posicion.getColumna() - 1);
						
						this.posicion = new Posicion(nuevaFila, nuevaColumna);
					}
					
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;
			
			case DERECHA:
				try {
					
					if(Color.BLANCO.equals(this.color)){
						
						int nuevaFila = this.posicion.getFila() + 1;
						
						char nuevaColumna = (char) (this.posicion.getColumna() + 1);
						
						this.posicion = new Posicion(nuevaFila, nuevaColumna);
					
					} else {
						
						int nuevaFila = this.posicion.getFila() - 1;
						
						char nuevaColumna = (char) (this.posicion.getColumna() + 1);
						
						this.posicion = new Posicion(nuevaFila, nuevaColumna);
					}
				
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;
			default:
				break;
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

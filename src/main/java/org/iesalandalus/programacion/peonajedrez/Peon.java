package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Peon {

	private Posicion posicion;

	private Color color;

	public Peon() {

		this.color = Color.NEGRO;
		this.posicion = new Posicion(7, 'd');
	}

	public Peon(Color color) {

		setColor(color);

		if (Color.BLANCO.equals(this.color)) {

			this.posicion = new Posicion(2, 'd');

		} else {

			this.posicion = new Posicion(7, 'd');
		}
	}

	public Peon(Color color, char columnaInicial) {

		setColor(color);

		if (Color.BLANCO.equals(this.color)) {

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

	public void mover(Direccion direccion) throws OperationNotSupportedException {

		if (direccion == null) {
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}

		switch (direccion) {

		case IZQUIERDA:
			try {

				if (Color.BLANCO.equals(this.color)) {

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

				if (Color.BLANCO.equals(this.color)) {

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

	public void mover(int movimiento) throws OperationNotSupportedException {

		switch (movimiento) {

		case 1:
			try {

				if (Color.BLANCO.equals(this.color)) {

					int nuevaFila = this.posicion.getFila() + 1;

					char nuevaColumna = this.posicion.getColumna();

					this.posicion = new Posicion(nuevaFila, nuevaColumna);

				} else {

					int nuevaFila = this.posicion.getFila() - 1;

					char nuevaColumna = this.posicion.getColumna();

					this.posicion = new Posicion(nuevaFila, nuevaColumna);
				}

			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		case 2:
			try {

				if (Color.BLANCO.equals(this.color) && posicion.getFila() != 2
						|| Color.NEGRO.equals(this.color) && posicion.getFila() != 7) {

					throw new OperationNotSupportedException(
							"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				}

				if (Color.BLANCO.equals(this.color)) {

					int nuevaFila = this.posicion.getFila() + 2;

					char nuevaColumna = this.posicion.getColumna();

					this.posicion = new Posicion(nuevaFila, nuevaColumna);

				} else {

					int nuevaFila = this.posicion.getFila() - 2;

					char nuevaColumna = this.posicion.getColumna();

					this.posicion = new Posicion(nuevaFila, nuevaColumna);
				}

			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		default:
			throw new OperationNotSupportedException("ERROR: El peón sólo se puede mover 1 o 2 pasos.");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Peon)) {
			return false;
		}
		Peon other = (Peon) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return posicion + ", color=" + color;
	}
}

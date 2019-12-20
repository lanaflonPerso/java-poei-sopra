package org.eclipse.test;

import org.eclipse.exception.OperationException;

public class Operation {
	private Nombre nombre;

	public Operation(Nombre nombre) {
		super();
		this.nombre = nombre;
	}

	public Operation() {
		super();
	}

	public Nombre getNombre() {
		return nombre;
	}

	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}

	public int division() throws OperationException {
		if (nombre.getVar2() == 0)
			throw new OperationException();
		return (nombre.getVar1() / nombre.getVar2());

	}

	@Override
	public String toString() {
		return "Operation [nombre=" + nombre + "]";
	}

}

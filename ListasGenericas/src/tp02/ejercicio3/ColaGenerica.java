package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	private ListaGenerica<T> l;
	
	public ColaGenerica() {
		l = new ListaEnlazadaGenerica<T>();
	}
	
	public void encolar(T dato) {
		this.l.agregarFinal(dato);
	}
	
	public T desencolar() {
		T dato = l.elemento(1);
		this.l.eliminarEn(1);
		return dato;
	}
	
	public T tope() {
		return this.l.elemento(1);
	}
	
	public boolean esVacia() {
		return this.l.esVacia();
	}
}

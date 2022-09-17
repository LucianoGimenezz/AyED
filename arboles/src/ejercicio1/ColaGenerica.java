package ejercicio1;


public class ColaGenerica<T> {
	private ListaEnlazadaGenerica<T> l;
	
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

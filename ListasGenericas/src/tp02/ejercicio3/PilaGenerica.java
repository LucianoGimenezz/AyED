package tp02.ejercicio3;
import tp02.ejercicio2.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
    private ListaEnlazadaGenerica<T> l;
    
    public PilaGenerica() {
    	l = new ListaEnlazadaGenerica<T>();
    }
    
    public void apilar(T dato) {
    	this.l.agregarInicio(dato);
    }
    
    public T desapilar() {
    	T dato = this.l.elemento(1);
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

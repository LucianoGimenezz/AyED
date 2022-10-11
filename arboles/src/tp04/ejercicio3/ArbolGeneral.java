package tp04.ejercicio3;

import ejercicio1.ColaGenerica;
import ejercicio1.ListaEnlazadaGenerica;
import ejercicio1.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	
	public Integer altura() {
		Integer max = 0;
		if (!this.esHoja()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			Integer aux = 0;
			while (!hijos.fin()) {
				aux = hijos.proximo().altura() + 1;
				if (aux > max) {
					max = aux;
				}
			}
		}
		return max;
	}
	

	public Integer nivel(T dato) {
		int nivel = 0;
		if (!this.esVacio() && this.dato != null ) {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> arbol = null;
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol != null) {
					if (arbol.getDato() == dato) {
						break;
					}
					if (!arbol.esHoja()) {
				     	ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}	
					}
				}else {
					if (!cola.esVacia()) {
						nivel++;
						cola.encolar(null);
					}
				}
			}
		}else nivel = -1;
		return nivel;
	}

	public Integer ancho() {
		int ancho = Integer.MIN_VALUE;
		if (!this.esVacio() && this.dato != null ) {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			int aux = 0;
			ArbolGeneral<T> arbol = null;
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol != null) {
					aux++;
					if (!arbol.esHoja()) {
				     	ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}	
					}
				}else {
					if (!cola.esVacia()) {
						if (aux > ancho) {
							ancho = aux;
						}
						aux = 0;
						cola.encolar(null);
					}
				}
			}
		}
		return ancho;
	}

}
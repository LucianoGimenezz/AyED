package tp03.ejercicio3;

import ejercicio1.ArbolBinario;
import ejercicio1.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> ab;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		ab = arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPostOrden() {
		ArbolBinario<Integer> aux = this.ab;
		ListaEnlazadaGenerica<Integer> lsAux;
		ListaEnlazadaGenerica<Integer> ls = new ListaEnlazadaGenerica<Integer>();
		
		if (aux.tieneHijoIzquierdo()) {
			this.ab = aux.getHijoIzquierdo();
			lsAux = numerosParesInOrden();
			if (!lsAux.esVacia()) {
				lsAux.comenzar();
				while(!lsAux.fin()) {
					ls.agregarFinal(lsAux.proximo());
				}
			}
		}
		
		if (aux.tieneHijoDerecho()) {
			this.ab = aux.getHijoDerecho();
			lsAux = numerosParesInOrden();
			if (!lsAux.esVacia()) {
				lsAux.comenzar();
				while(!lsAux.fin()) {
					ls.agregarFinal(lsAux.proximo());
				}
			}
		}
		
		if ((aux.getDato() % 2 == 0)) {
			ls.agregarFinal(aux.getDato());
		}
		
		return ls;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrden() {
		ArbolBinario<Integer> aux = this.ab;
		ListaEnlazadaGenerica<Integer> lsAux;
		ListaEnlazadaGenerica<Integer> ls = new ListaEnlazadaGenerica<Integer>();
		
		if (aux.tieneHijoIzquierdo()) {
			this.ab = aux.getHijoIzquierdo();
			lsAux = numerosParesInOrden();
			if (!lsAux.esVacia()) {
				lsAux.comenzar();
				while(!lsAux.fin()) {
					ls.agregarFinal(lsAux.proximo());
				}
			}
		}
		if ((aux.getDato() % 2 == 0)) {
			ls.agregarFinal(aux.getDato());
		}
		
		if (aux.tieneHijoDerecho()) {
			this.ab = aux.getHijoDerecho();
			lsAux = numerosParesInOrden();
			if (!lsAux.esVacia()) {
				lsAux.comenzar();
				while(!lsAux.fin()) {
					ls.agregarFinal(lsAux.proximo());
				}
			}
		}
		return ls;
	}
}

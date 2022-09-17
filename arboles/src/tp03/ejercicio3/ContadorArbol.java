package tp03.ejercicio3;

import ejercicio1.ArbolBinario;
import ejercicio1.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> ab;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		ab = arbol;
	}
	
	public void numerosParesInOrden() {
		ArbolBinario<Integer> aux = this.ab;
		if (aux.tieneHijoIzquierdo()) {
			this.ab = aux.getHijoIzquierdo();
			numerosParesInOrden();
		}
		
		System.out.println(aux.getDato());
		
		if (aux.tieneHijoDerecho()) {
			this.ab = aux.getHijoDerecho();
			numerosParesInOrden();
		}
		//return null;
	}
}

package tp03.ejercicio5;

import ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
  private ArbolBinario<Integer> ab;
  
  public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
	  ab = arbol;
  }
  
  public int sumaElementosProfundidad(int p) {
	  ArbolBinario<Integer> aux = ab;
	  int sum = 0;
	 
	  if (p == 0) {
		  sum+= aux.getDato();
	  }
	  
	  if (aux.tieneHijoIzquierdo()) {
		 ab = aux.getHijoIzquierdo();
		 int profundidad = p;
	     sum += sumaElementosProfundidad(--profundidad);
	  }
	  
	  if (aux.tieneHijoDerecho()) {
		 ab = aux.getHijoDerecho(); 
		 int profundidad = p;
		 sum += sumaElementosProfundidad(--profundidad);
	   }

	  return sum;
 	}
}

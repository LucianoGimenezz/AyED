package tp04.ejercicio3;

import ejercicio1.ListaEnlazadaGenerica;
import ejercicio1.ListaGenerica;

public class RecorridosAG {
  public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
	  ListaGenerica<Integer> ls = new ListaEnlazadaGenerica<Integer>();
	  if (!a.esVacio()) {
		  numerosImparesMayoresQuePreOrdenRecu(a, n, ls);
	  }
	  return ls;
  }
  
  private static ListaGenerica<Integer> numerosImparesMayoresQuePreOrdenRecu(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> ls) {
	  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
		  ls.agregarFinal(a.getDato());
	  }
	  ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
	  hijos.comenzar();
	  while(!hijos.fin()) {
		  numerosImparesMayoresQuePreOrdenRecu(hijos.proximo(), n, ls);
	  }
	  return ls;
  }
}

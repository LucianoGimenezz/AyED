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
  
  public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
	  ListaGenerica<Integer> ls = new ListaEnlazadaGenerica<Integer>();
	  if (!a.esVacio()) {
		  numerosImparesMayoresQueInOrdenRecu(a, n, ls);
	  }
	  return ls;
  }
  
  public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
	  ListaGenerica<Integer> ls = new ListaEnlazadaGenerica<Integer>();
	  if (!a.esVacio()) {
		  numerosImparesMayoresQuePostOrdenRecu(a, n, ls);
	  }
	  return ls;
  }
  
  private static ListaGenerica<Integer> numerosImparesMayoresQuePreOrdenRecu(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> ls) {
	  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
		  ls.agregarFinal(a.getDato());
	  }
	  
	  if (a.esHoja()) {
		  return ls;
	  }
	  ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
	  hijos.comenzar();
	  while(!hijos.fin()) {
		  numerosImparesMayoresQuePreOrdenRecu(hijos.proximo(), n, ls);
	  }
	  return ls;
  }
  
  private static ListaGenerica<Integer> numerosImparesMayoresQueInOrdenRecu(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> ls) {
	  if (a.esHoja()) {
		  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			  ls.agregarFinal(a.getDato());
		  }
		  return ls;
	  }
	  ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
	  hijos.comenzar();
	  while(!hijos.fin()) {
		  numerosImparesMayoresQuePreOrdenRecu(hijos.proximo(), n, ls);
		  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			  ls.agregarFinal(a.getDato());
		  }
		  numerosImparesMayoresQuePreOrdenRecu(hijos.proximo(), n, ls);
	  }
	  return ls;
  }
  
  private static ListaGenerica<Integer> numerosImparesMayoresQuePostOrdenRecu(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> ls) {
	  if (a.esHoja()) {
		  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
			  ls.agregarFinal(a.getDato());
		  }
		  return ls;
	  }
	  ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
	  hijos.comenzar();
	  while(!hijos.fin()) {
		  numerosImparesMayoresQuePostOrdenRecu(hijos.proximo(), n, ls);	  
	  }
	  if ((a.getDato() % 2 == 1) & (a.getDato() > n)) {
		  ls.agregarFinal(a.getDato());
	  }
	  return ls;
  }
}

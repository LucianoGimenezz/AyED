package tp04.ejercicio3;

import ejercicio1.ListaEnlazadaGenerica;
import ejercicio1.ListaGenerica;

public class TestRecorridos {
 public static void main(String [] args) {
	 ArbolGeneral<Integer> ag = new ArbolGeneral<Integer>(11);
	 ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
	 hijos.agregarFinal(new ArbolGeneral<Integer>(3, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>()));
	 hijos.agregarFinal(new ArbolGeneral<Integer>(2, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>()));
	 hijos.agregarFinal(new ArbolGeneral<Integer>(5, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>()));
	 hijos.agregarFinal(new ArbolGeneral<Integer>(8, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>()));
	 hijos.comenzar();
	 int pos = 1;
	 while (!hijos.fin()) {
		 ArbolGeneral<Integer> aux = hijos.proximo();
		 aux.agregarHijo(new ArbolGeneral<Integer>(pos));
		 ag.agregarHijo(aux);;
		 pos++;
 	 }
	
	 
	 RecorridosAG r = new RecorridosAG();
	 //ListaGenerica<Integer>ls = r.numerosImparesMayoresQuePreOrden(ag, 0);
	 ListaGenerica<Integer>ls = r.numerosImparesMayoresQuePostOrden(ag, 0);
	 ls.comenzar();
	 
	 while(!ls.fin()) {
		 System.out.println(ls.proximo());
	 }
 }
}

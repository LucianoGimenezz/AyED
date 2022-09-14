package ejercicio1_6;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ejercicio1_6 {
  public static ListaDeEnteros createList(int n) {
	  ListaDeEnteros l = new ListaDeEnterosEnlazada();
	  if (n == 1) {
		  l.agregarFinal(n);
	  }else if (n % 2 == 0) {
		  l.agregarFinal(n);
		  n = n / 2;
		  createList(n);
	  } else {
		  l.agregarFinal(n);
		  n = 3*n+1;
		  createList(n);
	  }
	  return l;
  }
  
  public static void main(String [] args) {
	  ListaDeEnteros ls = createList(6);
	  
	  ls.comenzar();
	  
	  while(!ls.fin()) {
		  System.out.println(ls.proximo());
	  }
  }
}

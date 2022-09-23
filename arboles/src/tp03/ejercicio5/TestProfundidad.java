package tp03.ejercicio5;

import ejercicio1.ArbolBinario;

public class TestProfundidad {
  public static void main(String [] args) {
	  ProfundidadDeArbolBinario p = null;
	  
	  ArbolBinario<Integer> a = new ArbolBinario<Integer>(2);
	  ArbolBinario<Integer> b = new ArbolBinario<Integer>(4);
	  ArbolBinario<Integer> c = new ArbolBinario<Integer>(5);
	  a.agregarHijoIzquierdo(b);
	  a.agregarHijoDerecho(c);
	  b.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
	  b.agregarHijoDerecho(new ArbolBinario<Integer>(12));
	  c.agregarHijoIzquierdo(new ArbolBinario<Integer>(20));
	  c.agregarHijoDerecho(new ArbolBinario<Integer>(30));
	  p = new ProfundidadDeArbolBinario(a);
	  
	  System.out.println(p.sumaElementosProfundidad(2));
  }
}

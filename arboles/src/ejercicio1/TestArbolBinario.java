package ejercicio1;

public class TestArbolBinario {
 public static void main(String[] args) {
	 ArbolBinario<Integer> ab = new ArbolBinario<Integer>(2);
	 ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
	 ab.agregarHijoDerecho(new ArbolBinario<Integer>(3));
	 ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
	 ab.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(20));
	 //System.out.println(ab.contarHojas());
	 ArbolBinario<Integer> abEspejo = ab.espejo();
	 
	 System.out.println("Arbol original:  " + ab.getHijoDerecho().getHijoIzquierdo());
	 System.out.println("Arbol Espejo:  " + abEspejo.getHijoIzquierdo().getHijoIzquierdo());
 }
}

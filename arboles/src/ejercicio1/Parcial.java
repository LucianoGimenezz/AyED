package ejercicio1;

import tp04.ejercicio3.ArbolGeneral;

public class Parcial {
    public static void main(String[] args) {
       ArbolGeneral<Integer> arbol = null;
       ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
       hijos.agregarFinal(new ArbolGeneral<Integer>(10));
       hijos.agregarFinal(new ArbolGeneral<Integer>(7));
       hijos.agregarFinal(new ArbolGeneral<Integer>(9));
       arbol = new ArbolGeneral<Integer>(7, hijos);
       
       if (esDeSeleccion(arbol)) {
    	   System.out.println("Es de seleccion");
       }else System.out.println("No es de seleccion");
    }
    
	public static boolean esDeSeleccion(ArbolGeneral<Integer> arbol) {
		int min = Integer.MAX_VALUE;
		boolean flag = true;
		if (!arbol.esVacio()) {
			ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
			ArbolGeneral<Integer> arbolAux = null;
			cola.encolar(arbol);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbolAux = cola.desencolar();
				if (arbolAux != null) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbolAux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						ArbolGeneral<Integer> aux = hijos.proximo();
						if (aux.getDato() < min) {
							min = aux.getDato();
						}
						cola.encolar(aux);
					}
					
					if (arbolAux.getDato() != min) {
						flag= false;
						break;
					}
				}else {
					if (!cola.esVacia()) {
						cola.encolar(null);
					}
				}
			}
 		}
		return flag;
	}
	
	

}

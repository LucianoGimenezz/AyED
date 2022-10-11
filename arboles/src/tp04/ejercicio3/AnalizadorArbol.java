package tp04.ejercicio3;

import ejercicio1.ColaGenerica;
import ejercicio1.ListaGenerica;

public class AnalizadorArbol {
 public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
	 int mayorPromedio = 0;
	 int totalNodos = 0;
	 int sumTardanza = 0;
		if (!arbol.esVacio() && arbol.getDato() != null ) {
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ArbolGeneral<AreaEmpresa> arbolAux = null;
			cola.encolar(arbol);
			cola.encolar(null);
			while (!cola.esVacia()) {
				arbolAux = cola.desencolar();
				if (arbolAux != null) {
					totalNodos++;
					sumTardanza+=arbol.getDato().getTardanzaMsj();
					if (!arbolAux.esHoja()) {
				     	ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbolAux.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}	
					}
				}else {
					if (!cola.esVacia()) {
						if ((sumTardanza/totalNodos) > mayorPromedio) {
							mayorPromedio = sumTardanza/totalNodos;
						}
						totalNodos = 0;
						sumTardanza = 0;
						cola.encolar(null);
					}
				}
			}
		}
		return mayorPromedio;
 }
}

package ejercicio1;

public class Parcial {

	public boolean esDeSeleccion(ArbolGeneral<Integer> arbol) {
		boolean flag = false;
		if (!arbol.esVacio()) {
			esDeSeleccionRecu(arbol, flag);
		}
		return flag;
	}
	
	public boolean esDeSeleccionRecu(ArbolGeneral<Integer> ab, boolean flag) {
		if (ab.esHoja()) return flag;
		int dato = ab.getDato();
		ListaGenerica<ArbolGeneral<Integer>> hijos = ab.getHijos();
		hijos.comenzar();
		while(!hijos.fin() && !flag) {
			ArbolGeneral<Integer> aux = hijos.proximo(); 
			if (!(dato <= aux.getDato())) flag = true;
			else flag = esDeSeleccionRecu(aux, flag);
		}
		return flag;
	}
}

package ejercicio1_6;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ejercicio1_6 {
	public static ListaDeEnterosEnlazada ejercicio1_6(int n) {
		ListaDeEnterosEnlazada list;
		int resultado;
		if(n == 1) {
			list = new ListaDeEnterosEnlazada();
			list.agregarInicio(n);
			return list;	
		}
		if(n % 2 == 0) {
			resultado = n/2;
			list = ejercicio1_6(resultado);
			list.agregarInicio(n);
		}else {
			resultado = (3*n)+1;
			list = ejercicio1_6(resultado);
			list.agregarInicio(n);
		}
		return list;
	}
	
	public static void main(String[] args) {
		int n = 6;
		ListaDeEnterosEnlazada list = ejercicio1_6(n);
		list.comenzar();
		while(!list.fin()) {
			System.out.println(list.proximo());
		}
	}
	//6, 3, 10, 5, 16, 8, 4, 2, 1
}

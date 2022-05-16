package ejercicio1_2;

import tp02.ejercicio1.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {
	public static void main(String[] args) {
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		Integer[] numeros = new Integer[5];
		numeros[0] = 1;
		numeros[1] = 2;
		numeros[2] = 3;
		numeros[3] = 4;
		numeros[4] = 5;
		for(int i = 0; i < numeros.length; i ++) {
		   lista.agregarFinal(numeros[i]);
		}
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}

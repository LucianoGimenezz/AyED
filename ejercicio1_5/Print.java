package ejercicio1_5;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosConArreglos;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Print {
	public static void printList(ListaDeEnteros list) {
		int dato;
		if(!list.fin()) {
			dato = list.proximo();
			printList(list);
		}else {
			return;
		}
		System.out.println(dato);;
	}
	
	public static void main(String[] args) {
		//ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		ListaDeEnteros lista = new ListaDeEnterosConArreglos();
		Integer[] numeros = new Integer[5];
		numeros[0] = 1;
		numeros[1] = 2;
		numeros[2] = 3;
		numeros[3] = 4;
		numeros[4] = 5;
		for(int i = 0; i < numeros.length; i ++) {
			   lista.agregarFinal(numeros[i]);
			}
	  //lista.comenzar();
	  printList(lista);
	}
	
}

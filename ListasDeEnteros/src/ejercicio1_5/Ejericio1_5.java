package ejercicio1_5;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosConArreglos;

public class Ejericio1_5 {
	public static void Print(ListaDeEnteros l) {
		if (l.fin()) {
			return;
		}
		Integer dato = l.proximo();
		Print(l);
		System.out.println(dato);
	}
	
	
	public static void main(String [] args) {
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		for (int i = 1; i <= 10 ; i++) {
			l.agregarFinal(i);
		}
		
		l.comenzar();
		
		Print(l);
	}
}

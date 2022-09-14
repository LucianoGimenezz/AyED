package ejercicio1_2;

import tp02.ejercicio1.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglo {
	public static void main(String[] args) {
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		for(int i = 1; i <= 10 ; i++) {
			l.agregarInicio(i);
		}
		
		l.comenzar();
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
	}
}

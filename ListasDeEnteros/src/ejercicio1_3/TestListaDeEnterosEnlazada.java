package ejercicio1_3;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {
	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		
		for(int i = 1; i <= 10 ; i++) {
			l.agregarFinal(i);
		}
		
		l.comenzar();
		
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
	}
}

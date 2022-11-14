package Ejercicio6;

import ejercicio3.Grafo;
import ejercicio3.GrafoImplListAdy;
import ejercicio3.Vertice;
import ejercicio3.VerticeImplListAdy;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;

public class TestMapa {
	public static void main(String [] args) {
		Vertice<String> v1 = new VerticeImplListAdy<String>("A");
		Vertice<String> v2 = new VerticeImplListAdy<String>("B");
		Vertice<String> v3 = new VerticeImplListAdy<String>("C");
		Vertice<String> v4 = new VerticeImplListAdy<String>("D");
		Vertice<String> v5 = new VerticeImplListAdy<String>("H");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Z");
		Vertice<String> v7 = new VerticeImplListAdy<String>("L");
		Vertice<String> v8 = new VerticeImplListAdy<String>("P");
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		grafo.agregarVertice(v7);
		grafo.agregarVertice(v8);
		
		grafo.conectar(v1, v2, 20);
		grafo.conectar(v2, v1, 20);
		grafo.conectar(v2, v3, 12);
		grafo.conectar(v3, v2, 12);
		grafo.conectar(v3, v4, 7);
		grafo.conectar(v4, v3, 7);
		grafo.conectar(v3, v6, 11);
		grafo.conectar(v6, v3, 11);
		grafo.conectar(v4, v7, 7);
		grafo.conectar(v7, v4, 7);
		grafo.conectar(v5, v7, 12);
		grafo.conectar(v7, v5, 12);
		grafo.conectar(v6, v7, 1);
		grafo.conectar(v7, v6, 1);
		grafo.conectar(v5, v8, 10);
		grafo.conectar(v8, v5, 10);
		
		Mapa map = new Mapa(grafo, 45);
		ListaGenerica<String> caminos = new ListaEnlazadaGenerica<String>();
		caminos.agregarFinal("D");
		caminos.agregarFinal("Z");
		
		ListaGenerica<String> camino = map.caminoConMenorCargaDeCombustible("A","P", 39);
		camino.comenzar();
		while (!camino.fin()) {
			System.out.println(camino.proximo());
		}
	}
}

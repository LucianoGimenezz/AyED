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
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		
		grafo.conectar(v1, v2);
		grafo.conectar(v2, v1);
		grafo.conectar(v2, v3);
		grafo.conectar(v3, v2);
		grafo.conectar(v3, v4);
		grafo.conectar(v4, v3);
		grafo.conectar(v1, v5);
		grafo.conectar(v5, v1);
		grafo.conectar(v3, v6);
		grafo.conectar(v6, v3);
		grafo.conectar(v4, v7);
		grafo.conectar(v7, v4);
		grafo.conectar(v5, v7);
		grafo.conectar(v7, v5);
		grafo.conectar(v6, v7);
		grafo.conectar(v7, v6);
		
		Mapa map = new Mapa(grafo);
		ListaGenerica<String> caminos = new ListaEnlazadaGenerica<String>();
		caminos.agregarFinal("A");
		caminos.agregarFinal("C");
		ListaGenerica<String> camino = map.devolverCaminoExceptuando("L", "B", caminos);
		camino.comenzar();
		while (!camino.fin()) {
			System.out.println(camino.proximo());
		}
	}
}

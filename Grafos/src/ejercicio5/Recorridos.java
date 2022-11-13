package ejercicio5;

import ejercicio3.Arista;
import ejercicio3.ColaGenerica;
import ejercicio3.Grafo;
import ejercicio3.Vertice;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;

public class Recorridos {

	public <T> ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		boolean [] marcas = new boolean[grafo.listaDeVertices().tamanio()+1] ;
		ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<>();
		for(int i =1 ; i<grafo.listaDeVertices().tamanio(); i++) {
			if (!marcas[i]) {
				this.dfs(i, grafo, marcas, vertices);
			}
		}
		return vertices;
	}
	
	private <T> void dfs(int i, Grafo<T> grafo, boolean[] marcas, ListaGenerica<Vertice<T>> vertices) {
		marcas[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		vertices.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marcas[j]) {
				this.dfs(j, grafo, marcas, vertices);
			}
		}
	}
	
	public <T> ListaGenerica<Vertice<T>> bfs (Grafo<T> grafo) {
		boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<Vertice<T>>();
		for(int i =1 ; i<grafo.listaDeVertices().tamanio(); i++) {
			if (!marcas[i]) {
				this.bfs(i, grafo, marcas, vertices);
			}
		}
		return vertices;
	}
	
	private <T> void bfs (int i, Grafo<T> grafo, boolean [] marcas, ListaGenerica<Vertice<T>> vertice) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marcas[i] = true;
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			vertice.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marcas[j]) {
					Vertice<T> aux = arista.verticeDestino();
					marcas[j] = true;
					q.encolar(aux);
				}
			}
		}
	}
}

package Ejercicio6;

import ejercicio3.Arista;
import ejercicio3.ColaGenerica;
import ejercicio3.Grafo;
import ejercicio3.Vertice;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;

public class Mapa {
	Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> grafo) {
		this.mapaCiudades = grafo;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> list = new ListaEnlazadaGenerica<String>();
		int posCiudad1 = this.buscarCiudad(ciudad1);
		boolean [] marcas = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		if (posCiudad1 == 0) {
			return list;
		}
		boolean encontre = dfs(posCiudad1,ciudad2, list,marcas,this.mapaCiudades);
		if (!encontre) {
			list.eliminarEn(1);
		}
		return list;
	}
	
	private boolean dfs(int pos, String ciudadDestino, ListaGenerica<String> camino, boolean [] marcas, Grafo<String> grafo) {
		marcas[pos] = true;
		boolean encontre = false;
		Vertice<String> v = grafo.listaDeVertices().elemento(pos);
		System.out.println("Current:" + v.dato());
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudadDestino)) {
			System.out.println("Destino alcanzado:" + v.dato());
			return true;
		}
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while ((!encontre) & (!ady.fin())) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marcas[j]) {
				encontre = this.dfs(j, ciudadDestino, camino, marcas, grafo);
				if (!encontre) {
					System.out.println("Vertice eliminado" + grafo.listaDeVertices().elemento(j).dato());
					camino.eliminarEn(camino.tamanio());
				}
			}
		}
		return encontre;
	}
	
	private int buscarCiudad(String ciudad) {
		int posCiudad = 0;
		ListaGenerica<Arista<String>> ady = null;
		ColaGenerica<Vertice<String>> q = new ColaGenerica<Vertice<String>>();
		boolean [] marcas = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		q.encolar(this.mapaCiudades.listaDeVertices().elemento(1));
		marcas[1] = true;
		while (!q.esVacia()) {
			Vertice<String> v = q.desencolar();
			if (v.dato().equals(ciudad)) {
				posCiudad = v.getPosicion();
				break;
			}
			ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marcas[j]) {
					Vertice<String> aux = arista.verticeDestino();
					marcas[j] = true;
					q.encolar(aux);
				}
			}
		}
		return posCiudad ;
	}
}

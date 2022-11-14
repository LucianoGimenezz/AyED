package Ejercicio6;

import ejercicio3.Arista;
import ejercicio3.ColaGenerica;
import ejercicio3.Grafo;
import ejercicio3.Vertice;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;

public class Mapa {
	private Grafo<String> mapaCiudades;
	private int totalTanque;
	
	public Mapa(Grafo<String> grafo) {
		this.mapaCiudades = grafo;
	}
	
	public Mapa(Grafo<String> grafo, int totalTanque) {
		this.mapaCiudades = grafo;
		this.totalTanque = totalTanque;
	}
	
	// Ejercicio 5.1
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
	
	// Ejercicio 5.2
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
		ListaGenerica<String> list = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean[this.mapaCiudades.listaDeVertices().tamanio()+1];
		int posCiudad = this.buscarCiudad(ciudad1);
		if (posCiudad == 0) {
			return list;
		}
		boolean encontre = this.dfs(posCiudad, ciudad2, list, marcas, this.mapaCiudades, ciudades);
		if (!encontre) {
			list.eliminarEn(1);
		}
		return list;
	}
	
	private boolean dfs(int pos, String ciudadDestino, ListaGenerica<String> camino, boolean [] marcas, Grafo<String> grafo, ListaGenerica<String> ciudades) {
		marcas[pos] = true;
		boolean encontre = false;
		Vertice<String> v = grafo.listaDeVertices().elemento(pos);
		camino.agregarFinal(v.dato());
		
		if (ciudades.incluye(v.dato())) {
			return encontre;
		}
		
		if (v.dato().equals(ciudadDestino)) {
			
			return true;
		}
		
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while ((!encontre) & (!ady.fin())) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marcas[j]) {
				encontre = this.dfs(j, ciudadDestino, camino, marcas, grafo, ciudades);
				if (!encontre) {
					camino.eliminarEn(camino.tamanio());
				}
			}
		}
		return encontre;
	}
	
	//Ejercicio 5.3
	
	public ListaGenerica<String> caminoMasCorto (String ciudad1, String ciudad2) {
		ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		int minKm = Integer.MAX_VALUE;
		int kmActual = 0;
		int posCiudad = this.buscarCiudad(ciudad1);
		if (posCiudad == 0) {
			return caminoMin;
		}
		minKm = this.dfs(posCiudad, ciudad2, marcas, this.mapaCiudades, caminoMin, caminoActual, kmActual, minKm);
		System.out.println("El valor del camino mas corto fue:" +  minKm);
		return caminoMin;
	}
	
	private int dfs(int pos, String ciudadDestino, boolean [] marcas, Grafo<String> grafo, ListaGenerica<String> caminoMin, ListaGenerica<String> caminoActual, int totalKm, int minKm) {
		marcas[pos] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(pos);
		caminoActual.agregarFinal(v.dato());	
		
		if (v.dato().equals(ciudadDestino)) {
			if (totalKm < minKm) {
				minKm = totalKm;
				
				caminoMin.comenzar();
				
				while (!caminoMin.fin()) {
					caminoMin.eliminar(caminoMin.proximo());
				}
				
				caminoActual.comenzar();
				while (!caminoActual.fin()) {
					caminoMin.agregarFinal(caminoActual.proximo());
				}
				
			}
			return minKm;
		}
		
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			Arista<String> a = ady.proximo();
			int j = a.verticeDestino().getPosicion();
			if (!marcas[j]) {
				minKm = this.dfs(j, ciudadDestino, marcas, grafo, caminoMin,caminoActual, totalKm+a.peso(), minKm);
				caminoActual.eliminarEn(caminoActual.tamanio());
				marcas[j] = false;
			}
		}
		return minKm;
	}
	
	//Ejercicio5.4
	
	public ListaGenerica<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		int posCiudad = this.buscarCiudad(ciudad1);
		if (posCiudad == 0) {
			return camino;
		}
		if (!this.dfs(posCiudad, ciudad2, marcas, this.mapaCiudades, camino, tanqueAuto)) camino.eliminarEn(1);
		return camino;
	}
	
	private boolean dfs(int pos, String ciudadDestino, boolean [] marcas, Grafo<String> grafo, ListaGenerica<String> camino, int tanqueAuto) {
		Vertice<String> v = grafo.listaDeVertices().elemento(pos);
		camino.agregarFinal(v.dato());
		
		if (v.dato().equals(ciudadDestino)) {
			return true;
		}

		boolean encontre = false;
		marcas[pos] = true;
	
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while ((!encontre) & (!ady.fin())) {
			Arista<String> a = ady.proximo();
			int j = a.verticeDestino().getPosicion();
			if (!marcas[j]) {
				if ((tanqueAuto-a.peso()) > 0) {
					encontre = this.dfs(j, ciudadDestino, marcas, grafo, camino, tanqueAuto-a.peso());
					marcas[j] = false;     
					if (!encontre) {
						camino.eliminarEn(camino.tamanio());
					}
				}
			}
		}
		return encontre;
	}
	
	//Ejercicio 5.5
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean [this.mapaCiudades.listaDeVertices().tamanio()+1];
		int posCiudad = this.buscarCiudad(ciudad1);
		int cargasMin = Integer.MAX_VALUE;
		int cantCargas = 0;
		if (posCiudad == 0) {
			return caminoMin;
		}
		this.dfs(posCiudad, ciudad2, marcas, this.mapaCiudades, caminoMin, caminoActual, cantCargas, cargasMin, tanqueAuto);
		return caminoMin;
	}
		
	private int dfs(int pos, String ciudadDestino, boolean [] marcas, Grafo<String> grafo, ListaGenerica<String> caminoMin, ListaGenerica<String> caminoActual,
		int cantCargas, int cargasMin, int tanqueAuto) {
		
		Vertice<String> v = grafo.listaDeVertices().elemento(pos);
		caminoActual.agregarFinal(v.dato());
		if (v.dato().equals(ciudadDestino)) {
			System.out.println("Cantidad de veces cargadas:" + cantCargas);
			if (cantCargas < cargasMin) {
				cargasMin = cantCargas;
				
				caminoMin.comenzar();
				while (!caminoMin.fin()) {
					caminoMin.eliminar(caminoMin.proximo());
				}
				
				caminoActual.comenzar();
				while (!caminoActual.fin()) {
					caminoMin.agregarFinal(caminoActual.proximo());
				}
			}
			return cargasMin;
		}
		
		marcas[pos] = true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			Arista<String> a = ady.proximo();
			int j = a.verticeDestino().getPosicion();
			if (!marcas[j]) {
				
				if ((tanqueAuto - a.peso()) <= 0) {
					tanqueAuto = this.totalTanque;
					cantCargas+=1;
				}
				
				cargasMin = this.dfs(j, ciudadDestino, marcas, grafo, caminoMin, caminoActual,cantCargas, cargasMin, tanqueAuto-a.peso());
				marcas[j] = false;
				caminoActual.eliminarEn(caminoActual.tamanio());
			}
		}
		return cargasMin;
	}
}

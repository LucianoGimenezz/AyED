package ejercicio7;

import ejercicio3.Arista;
import ejercicio3.ColaGenerica;
import ejercicio3.Grafo;
import ejercicio3.Vertice;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;

public class VisitaOslo {
  
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int 
			maxTiempo, ListaGenerica<String> lugaresRestringidos) {
		
		int posOrigen = this.buscarLugar(lugares, "Ayuntamiento");
		int tiempoAct = 0;
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marcas = new boolean[lugares.listaDeVertices().tamanio()+1];
		if (posOrigen == 0) {
			return camino;
		}
		this.marcarLugaresRestringidos(lugares.listaDeVertices(), lugaresRestringidos, marcas);
		this.dfs(posOrigen, lugares, destino, maxTiempo, camino, marcas, tiempoAct);
		return camino;
	}
	
	private boolean dfs(int pos, Grafo<String> lugares, String destino, int maxTiempo, 
			ListaGenerica<String> camino, boolean [] marcas, int tiempoAct) {
		marcas[pos] = true;
		boolean encontre = false;
		Vertice<String> v = lugares.listaDeVertices().elemento(pos);
		camino.agregarFinal(v.dato());
		
		if (v.dato().equals(destino)) {
			return true;
		}
		
		ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
		ady.comenzar();
		while (!encontre && !ady.fin()) {
			Arista<String> a = ady.proximo();
			int j = a.verticeDestino().getPosicion();
			if (!marcas[j] && (tiempoAct+a.peso() < maxTiempo)) {
				encontre = this.dfs(j, lugares, destino, maxTiempo, camino, marcas, tiempoAct+a.peso());
				if (!encontre) {
					camino.eliminarEn(camino.tamanio());
					marcas[j] = false;
				}
			}
		}

		return encontre;
	}
	
	private void marcarLugaresRestringidos(ListaGenerica<Vertice<String>> vertices, ListaGenerica<String> lugares
			, boolean [] marcas ) {
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> aux = vertices.proximo();
			if (lugares.incluye(aux.dato())) {
				marcas[aux.getPosicion()] = true;
			}
		}
	}
	
	private int buscarLugar(Grafo<String> lugares, String origen) {
		int posCiudad = 0;
		ListaGenerica<Arista<String>> ady = null;
		ColaGenerica<Vertice<String>> q = new ColaGenerica<Vertice<String>>();
		boolean [] marcas = new boolean [lugares.listaDeVertices().tamanio()+1];
		q.encolar(lugares.listaDeVertices().elemento(1));
		marcas[1] = true;
		while (!q.esVacia()) {
			Vertice<String> v = q.desencolar();
			if (v.dato().equals(origen)) {
				posCiudad = v.getPosicion();
				break;
			}
			ady = lugares.listaDeAdyacentes(v);
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

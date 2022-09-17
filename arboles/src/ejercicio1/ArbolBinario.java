package ejercicio1;


public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int cant = 0;
		
		if (this.esHoja()) {
			return ++cant;
		}
		
		if (this.tieneHijoIzquierdo()) {
			cant += this.getHijoIzquierdo().contarHojas();
		}
		
		if (this.tieneHijoDerecho()) {
			cant += this.getHijoDerecho().contarHojas();
		}
		return cant;
	}
	

    public ArbolBinario<T> espejo() {
		ArbolBinario<T> ab = new ArbolBinario<T>(this.dato);
		
		if (this.esHoja()) {
			return ab;
		}
		
		if (this.tieneHijoIzquierdo()) {
			ab.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		
		if (this.tieneHijoDerecho()) {
			ab.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return ab;
	}


	public void entreNiveles(int n, int m){
		if (!this.esVacio() && this.dato != null) {
			int nivel = 0;
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			ArbolBinario<T> arbol = null;
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				
				if (arbol != null) {
					if ((nivel >= n) && (nivel <= m)) {
						System.out.println(arbol.getDato());
					}
			
					if (arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
					}
					if (arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
					}
				}else {
					if ((nivel >= n) && (nivel <= m)) {
						System.out.println("Nivel => " + nivel);
					}
					if (!cola.esVacia()) {
						nivel++;
						cola.encolar(null);
					}
				}
			}
		}
	}

	

}

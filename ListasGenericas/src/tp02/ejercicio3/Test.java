package tp02.ejercicio3;

public class Test {
  public static void main(String[] args) {
	  ColaGenerica<Integer> c = new ColaGenerica<Integer>();
	  Integer dato = 1;
	  Integer dato2 = 2;
	  Integer dato3 = 3;
	  Integer dato4 = 4;
	  c.encolar(dato);
	  c.encolar(dato2);
	  c.encolar(dato3);
	  c.encolar(dato4);
	  c.desencolar();
	  System.out.println(c.tope());
  }
}

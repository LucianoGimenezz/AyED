package tp02.ejercicio4.TestBalanceo;

import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {

	public static boolean apertura(char dato) {
		boolean flag;
		switch(dato) {
		case '(':
		case '[':
		case '{':
			flag = true;
			break;
		default:
			flag = false;
		}
		return flag;
	}
	
	public static boolean checkBalance(String s) {
		switch(s) {
		case "()":
		case "[]":
		case "{}":
			return true;
		default:
			return false;
		}
	}
	public static void main(String[] args) {
		String characters = "([{({[[]]})}])[]";
		boolean balanceado = true;
		PilaGenerica<Character> p = new PilaGenerica<Character>();
		
		for(int i = 0 ; i < characters.length(); i++) {
			char dato = characters.charAt(i);
			
			if (apertura(dato)) {
				p.apilar(dato);
				continue;
			}
			
			if ((i == 0) & (p.esVacia())) {
				balanceado = false;
				break;
			}
			
			char tope = p.desapilar();
			String s = String.valueOf(tope) + String.valueOf(dato);
			if(!checkBalance(s)) {
				balanceado = false;
				break;
			}
		}
		
		if ((p.esVacia()) & (balanceado)) {
			System.out.println("El string esta balanceado");
		}else {
			System.out.println("El string no esta balanceado");
		}
	}
}

package ejercicio1;
public class Ejercicio1 {
		
	public static void main(String[] args) {
		//PrintByFor(5, 20);
		//PrintByWhile(10, 1);
		PrintWhitoutIterables(5, 16);
	}
	
		
	public static void PrintWhitoutIterables(int a, int b) {
		if (a > b) {
			System.out.println(b);
			PrintWhitoutIterables(a, ++b);
		}else if (b > a) {
			System.out.println(a);
			PrintWhitoutIterables(++a, b);
		} else {
			System.out.println(a);
			return;
		}
	}
	
	public static void PrintByWhile(int a, int b) {
		int end = 0;
		int index = 0;
		if (a >= b) {
			index = b;
			end = a;
		}else {
			index = a;
			end = b;
		}
		
		System.out.println("PrintByWhile..");
		while (index <= end) {
			System.out.println(index++);
		}
	}
	
	public static void PrintByFor(int a, int b) { //a = 10 y b = 1
		int end = 0;
		int index = 0;
		if (a >= b) {
			index = b;
			end = a;
		}else {
			index = a;
			end = b;
		}
		
		System.out.println("PrintByFor..");
		for(; index <= end ; index++) {
			System.out.println(index);
		}
	}
}
package ejercicio2;
import java.util.Scanner;
public class Ejercicio2 {

	public int[] ReturnAnArray(int n) {
		if (n == 0) return null;
		int [] numbers = new int[n];
		for(int i = 1 ; i <= n; i ++) {
			numbers[i-1] = n*i;
		}
		return numbers;
	}
	
	public static void main(String [] args) {
		Ejercicio2 e = new Ejercicio2();
		Scanner s = new Scanner(System.in);
		int [] arr = e.ReturnAnArray(s.nextInt());
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		s.close();
	}
}




package ejercicio5;



public class Testmethods {
	static String chain = "";
	
	public void getDataWithIntanceVariable(int [] x) {
		int min = 9999;
		int max = -9999;
		int total = 0;
		for(int i = 0; i < x.length; i++) {
			total+= x[i];
			if (x[i] > max) {
				max = x[i];
			}
			if (x[i] < min) {
				min = x[i];
			}
		}
		Testmethods.chain =  "El elemento minimo es:" + "  " + min + ", " + "el maximo es: " + " " + max + "  y el promedio: " + (total/x.length);
	}
	
	public void getDataWithParams(int [] x, Result result) {
		int min = 9999;
		int max = -9999;
		int total = 0;
		String value;
		for(int i = 0; i < x.length; i++) {
			total+= x[i];
			if (x[i] > max) {
				max = x[i];
			}
			if (x[i] < min) {
				min = x[i];
			}
		}
		value =  "El elemento minimo es:" + "  " + min + ", " + "el maximo es: " + " " + max + "  y el promedio: " + (total/x.length);
		result.setValue(value);
		
		
	}
	
	public String getDataWithReturn(int [] x ) {
		String result;
		int min = 9999;
		int max = -9999;
		int total = 0;
		for(int i = 0; i < x.length; i++) {
			total+= x[i];
			if (x[i] > max) {
				max = x[i];
			}
			if (x[i] < min) {
				min = x[i];
			}
		}
		
		result = "El elemento minimo es:" + "  " + min + ", " + "el maximo es: " + " " + max + "  y el promedio: " + (total/x.length);
		return result;
	}
	
	public static void main(String [] args) {
		Testmethods test = new Testmethods();
		int [] array = new int [5];
		Result result = new Result();
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		array[4] = 15;
		//test.getDataWithParams(array, result);
		//System.out.println(test.getDataWithReturn(array));
		//System.out.println(result.getValue());
		test.getDataWithIntanceVariable(array);
		
		System.out.println(Testmethods.chain);
	}
}

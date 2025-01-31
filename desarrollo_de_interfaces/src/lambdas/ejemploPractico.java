package lambdas;

public class ejemploPractico {
	public static void main(String[] args) {
		Operacion suma = (a,b) -> a+b;
		System.out.println("Suma: " + suma.operacion(5,3));
		
	}
	
	@FunctionalInterface
	interface Operacion {
		int operacion(int a , int b);
	}
	
}

package mission;

public class TestGugudan2 {

	public static void main(String[] args) {
		
		int a = 2;
		int a2 = 3;
		int a3 = 4;
		
		for (int x = 0; x < 3; x++) {
			
			for (int b = 1; b <= 9; b++) {
										
					int c = a * b;
					System.out.print(a + " * " + b + " = " + c);
					
					int d = a2 * b;
					System.out.print("\t" + a2 + " * " + b + " = " + d);
					
					if (a3 < 10) {
						
						int e = a3 * b;
						System.out.println("\t" + a3 + " * " + b + " = " + e);
					} else System.out.println();
									
			}
			
			a += 3;
			a2 += 3;
			a3 += 3;
			System.out.println();
			
		}
			
	}

}

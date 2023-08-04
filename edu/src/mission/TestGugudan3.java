package mission;

public class TestGugudan3 {

	public static void main(String[] args) {
		
		int a = 2;
		int a2 = 3;
		
		for (int x = 0; x < (4); x++) {
			
			for (int b = 1; b <= 9; b++) {
									
				int c = a * b;
				System.out.print(a + " * " + b + " = " + c);
					
				int d = a2 * b;
				System.out.println("\t" + a2 + " * " + b + " = " + d);
								
			}
			
			a += 2;
			a2 += 2;
			System.out.println();
			
		}
			
	}

}

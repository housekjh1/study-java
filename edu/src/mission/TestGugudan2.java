package mission;

public class TestGugudan2 {

	public static void main(String[] args) {
		
		for (int k = 0; k <= 9; k++) {
		
			for (int j = 2; j <= 9; j++) {
				
				for(int i = 1; i <= 9; i++) {
				
					int a = j * i;
					System.out.println(j + " * " + i + " = " + a);
				}
				System.out.println();
			}
		}
	
	}

}

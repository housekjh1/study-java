package mission;

public class TestGugudan {
	
	public void printGugudan1() {
		
	}
	
	public static void main(String[] args) {
		
		TestGugudan gg = new TestGugudan();
		gg.printGugudan1();
		
		for (int j = 2; j <= 9; j++) {
					
			for(int i = 1; i <= 9; i++) {
			
				int a = j * i;
				System.out.println(j + " * " + i + " = " + a);
			}
			System.out.println();
		}
	}	

}

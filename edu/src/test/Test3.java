package test;

public class Test3 {
	private void swap(Integer a, Integer b) {
		int c = a;
		a = b;
		b = c;
	}
	
	public static void main(String[] args) {
		Test3 t = new Test3();
		
		int n = 10;
		int m = 5;
		t.swap(n, m);
		System.out.println(n + " " + m);
	}
}

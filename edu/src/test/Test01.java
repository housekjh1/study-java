package test;

class Test {
	int num;
	
	public Test(int num) {
		this.num = num;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Integer a = 10;
		Integer b = a;
		b++;
		System.out.println("a : " + a + ", b : " + b);
		
		Test t1 = new Test(10);
		Test t2 = t1;
		t2.num++;
		System.out.println("t1 : " + t1.num + ", t2 : " + t2.num);
	}
	
}

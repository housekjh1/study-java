package 자료구조2장기본자료구조;

import java.util.Arrays;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2() {}
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	
	public void showData(PhyscData2[] a) {
		
	}
	
	public PhyscData2[] sortData(PhyscData2[] a) {
		PhyscData2[] pd = new PhyscData2[3];
		return pd;
	}
	
	@Override
	public int compareTo(PhyscData2 p) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class Test_실습2_14객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
//		Arrays.sort(null, null);//이것을 사용하려면 Comparator를 써야한다.
		PhyscData2 pd = new PhyscData2();
		pd.showData(data);
		pd.sortData(data);
		pd.showData(data);
		
		
	}

}

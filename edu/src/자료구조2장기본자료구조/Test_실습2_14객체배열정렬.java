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
		for (PhyscData2 pd : a) {// for each문을 통해 객체 배열의 각 인덱스 객체를 가져옴
			System.out.print(pd);// 객체 출력은 오버라이드된 toString() 메서드의 출력내용을 가져옴
			System.out.println();
		}
	}
	
	public void sortData(PhyscData2[] a) {
//		Arrays.sort(a);// 배열이므로 Arrays.sort() 사용가능
//		List<PhyscData2> L = new ArrayList<>();
//		for (int i = 0; i < a.length; i++) {
//			L.add(a[i]);
//		}
//		
//		Collections.sort(L);
//		
//		for (int i = 0; i < a.length; i++) {
//	        a[i] = L.get(i);
//	    }// 소팅값 반환
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j<a.length; j++) {
				if(a[i].compareTo(a[j]) > 0) {// Override된 compareTo() 메서드 사용
					PhyscData2 s = a[i];
					a[i] = a[j];
					a[j] = s;
				}
			}
		}
	}
	
	@Override
	public int compareTo(PhyscData2 p) {// 소팅 조건을 오버라이드된 compareTo() 조건으로 반영
		int result = this.name.compareTo(p.name);// String 클래스의 compareTo()메서드 사용
		if (result != 0)
			return result;

	    int heightResult = this.height - p.height;
	    if (heightResult != 0) return heightResult;

	    int visionResult = Double.compare(this.vision, p.vision);
	    return visionResult;
	}
	
	@Override
	public String toString() {
		return "name: " + name + " height: " + height + " vision: " + vision;
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
		System.out.println("\nsort 후\n");
		pd.sortData(data);
		pd.showData(data);
		
	}
}

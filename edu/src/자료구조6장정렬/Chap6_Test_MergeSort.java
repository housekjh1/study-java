package 자료구조6장정렬;

import java.util.Comparator;

//PhyscData 클래스를 Comparable로 수정해야 한다.
//stack을 이용한 객체들의 non-recusrive MergeSort 구현

class PhyscData implements Comparator<PhyscData> {
	private String name;
	private int height;
	private double vision;

	public PhyscData() {
	}

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVision() {
		return vision;
	}

	public void setVision(double vision) {
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + height + ", " + vision + ">";
	}

	@Override
	public int compare(PhyscData o1, PhyscData o2) {
		if (o1.name.compareTo(o2.name) != 0)
			return o1.name.compareTo(o2.name);
		if (o1.height > o2.height)
			return 1;
		else if (o1.height < o2.height)
			return -1;
		if (o1.vision > o2.vision)
			return 1;
		else
			return -1;
	}

}

public class Chap6_Test_MergeSort {
	// MergeSort() 구현 소스 코드를 사용하여 객체들의 정렬 소스코드로 수정한다.

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {
		PhyscData[] tmp = new PhyscData[30];
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[ix].compare(a[p], a[q]) < 0)
				tmp[ix++] = a[p++];
			else if (a[ix].compare(a[p], a[q]) > 0)
				tmp[ix++] = a[q++];
			else {
				tmp[ix++] = a[p++];
				tmp[ix++] = a[q++];
			}
		}
		while (p > righta && q <= rightb) {
			tmp[ix++] = a[q++];
		}
		while (q > rightb && p <= righta) {
			tmp[ix++] = a[p++];
		}
		System.out.println();
		for (int j = 0; j < ix; j++) {
			a[lefta + j] = tmp[j];
			System.out.print(" " + a[lefta + j]);
		}
		System.out.println();
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("강민하", 162, 0.3), new PhyscData("김찬우", 173, 0.7),
				new PhyscData("박준서", 171, 2.0), new PhyscData("유서범", 171, 1.5), new PhyscData("이수연", 168, 0.4),
				new PhyscData("장경오", 171, 1.2), new PhyscData("황지안", 169, 0.8), };
		int nx = x.length;

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("오름차순으로 정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].getName(), x[i].getHeight(), x[i].getVision());
	}

}

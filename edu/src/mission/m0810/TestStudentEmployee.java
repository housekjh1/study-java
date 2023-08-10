package mission.m0810;

public class TestStudentEmployee {
	public static void main(String[] args) {
		Employee e = new Employee("230810-7777777", "홍길동", 1, "230810", "인사과", "부장", 50000000);
		Student s = new Student("220810-9999999", "홍길순", 2, "220810", "컴퓨터공학과", "2");
		
		Person arr[] = new Person[2]; 
		arr[0] = e;
		arr[1] = s;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

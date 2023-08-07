package mission;

public class MemberTest {
	public static void main(String[] args) {
		Member m1 = new Member();
		System.out.println(m1);
		
		Member m2 = new Member("Hong", 40);
		System.out.println(m2);
		
//		Member m3 = new Member(185);
//		System.out.println(m3);
	}
}

class Member {
	private String name;
	private int age;
//	private int height;
//	
	public Member() {
		name = "Lee";
		age = 10;
	}
//
//	public Member(int height) {
//		this.height = height;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//	@Override
//	public String toString() {
//		return "Member [height=" + height + "]";
//	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
		
}

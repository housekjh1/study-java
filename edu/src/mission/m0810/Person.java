package mission.m0810;

public abstract class Person {
	String pid;
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String pid) {
		this(pid, null);
	}
	
	public Person(String pid, String name) {
		this(pid, name, (Integer) null);
		
	}
	
	public Person(String pid, String name, int age) {
		this.pid = pid;
		this.name = name;
		this.age = age;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	public String toString() {
		return "pid = " + pid + " name = " + name + " age = " + age;
	}
}

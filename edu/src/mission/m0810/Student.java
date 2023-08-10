package mission.m0810;

public class Student extends Person {
	String sid;
	String dept;
	String year;
	
	public Student () {
		super();
	}

	public Student(String pid, String name, int age, String sid, String dept, String year) {
		super(pid, name, age);
		this.sid = sid;
		this.dept = dept;
		this.year = year;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String toString() {
		return super.toString() + " sid = " + sid + " dept = " + dept + " year = " + year;
	}
	
}

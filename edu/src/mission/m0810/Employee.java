package mission.m0810;

public class Employee extends Person {
	String eid;
	String dept;
	String role;
	int salary;
	
	public Employee() {
		super();
	}
	
	public Employee(String pid, String name, int age, String eid, String dept, String role, int salary) {
		super(pid, name, age);
		this.eid = eid;
		this.dept = dept;
		this.role = role;
		this.salary = salary;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return super.toString() + " eid = " + eid + " dept = " + dept + " role = " + role + " salary = " + salary;
	}
	
}

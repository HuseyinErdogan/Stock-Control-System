import java.util.Date;
public class Employee {
	private String name;
	private double salary;
	private Date workStartDate;
		
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
		this.workStartDate = new Date();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getWorkStartDate() {
		return workStartDate;
	}
	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}
	

}

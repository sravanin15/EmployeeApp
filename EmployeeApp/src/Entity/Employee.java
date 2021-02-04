package Entity;

public class Employee {
private int empId;
private String empName;
private String empDesig;
private double salary;
private int yearsofExp;
public Employee(int empId, String empName, String empDesig, double salary, int yearsofExp) {
	this.empId = empId;
	this.empName = empName;
	this.empDesig = empDesig;
	this.salary = salary;
	this.yearsofExp = yearsofExp;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public void setEmpDesig(String empDesig) {
	this.empDesig = empDesig;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public void setYearsofExp(int yearsofExp) {
	this.yearsofExp = yearsofExp;
}
public int getEmpId() {
	return empId;
}
public String getEmpName() {
	return empName;
}
public String getEmpDesig() {
	return empDesig;
}
public double getSalary() {
	return salary;
}
public int getYearsofExp() {
	return yearsofExp;
}

}

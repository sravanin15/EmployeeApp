package service.serviceImplement;

import java.util.List;
import java.util.Scanner;

import Entity.Employee;
import service.ServiceImpl;

public class Service implements ServiceImpl {
	static Scanner sc=new Scanner(System.in);
	@Override
	public List<Employee> addEmployee(List<Employee> list) {
		// TODO Auto-generated method stub
		System.out.println("Enter empId:");
		int empId=sc.nextInt();
		int flag=0;
		for(Employee value:list)
		{
			if(value.getEmpId()==empId)
			{
				flag=1;
			}
		}
		try {
			if(flag==0)
			{
				System.out.println("Enter employee name:");
				String empName=sc.next()+sc.nextLine();
				System.out.println("Enter designation:");
				String empDesig=sc.next();
				empDesig=validDesignation(empDesig);
				System.out.println("Enter salary");
				double salary=sc.nextDouble();
				System.out.println("Enter years of experience");
				int yearsofExp=sc.nextInt();
				list.add(new Employee(empId,empName,empDesig,salary,yearsofExp));
			}
			else
				throw new MyException("employee id-", empId, " already exist");
		}
		catch(MyException e)
		{
			System.out.println(e);
		}
		
		return list;
	}
	private String validDesignation(String empDesig) {
		// TODO Auto-generated method stub
		boolean valid=true;
		while(valid)
		{
			if(empDesig.equalsIgnoreCase("jrEngineer") || empDesig.equalsIgnoreCase("srEngineer") || empDesig.equalsIgnoreCase("Engineer") || empDesig.equalsIgnoreCase("Manager") || empDesig.equalsIgnoreCase("modulelead"))
			{
				valid=false;
			}
			else
			{
				System.out.println("enter valid designation");
				empDesig=sc.next()+sc.nextLine();
			}
		}
		return empDesig;
	}

	@Override
	public List<Employee> updateEmployeeSalary(List<Employee> list) {
		System.out.println("Enter employee id whose salary to be updated:");
		Employee emp=null;
		int id=sc.nextInt();
		for(Employee value:list)
		{
			if(value.getEmpId()==id)
			{
				emp=value;
			}
		}
		try {
			if(emp!=null)
			{
				for(Employee value:list)
				{
					if(value.getEmpId()==id)
						if(value.getYearsofExp()>=5)
						{
							double salary=value.getSalary()+5000.00;
							value.setSalary(salary);
						}
					if((value.getEmpDesig().compareToIgnoreCase("Modulelead")==0) || (value.getEmpDesig().compareToIgnoreCase("Engineer")==0) || value.getEmpDesig().compareTo("Manager")==0)
					{
						double salary=value.getSalary()+1000.00;
						value.setSalary(salary);
					}
				}
			}
			else
				throw new MyException("employee id-", id, " not exist");
		}
		catch(MyException e)
		{
			System.out.println(e);
		}
		return list;
	}
	@Override
	public Employee getEmployeeById(List<Employee> list) {
		// TODO Auto-generated method stub
		Employee emp=null;
		System.out.println("Enter employee Id");
		int id=sc.nextInt();
		for(Employee value:list)
		{
			if(value.getEmpId()==id)
			{
				emp=value;
			}
		}
		try {
			if(emp!=null)
				return emp;
			else
				throw new MyException("employee id-", id, " not exist");
		}
		catch(MyException e)
		{
			System.out.println(e);
		}
		return null;
	}
	@Override
	public void getAllEmployee(List<Employee> list) {
		// TODO Auto-generated method stub
		for(Employee emp:list)
		{
			System.out.println("EmpId:"+emp.getEmpId()+"\temp name:"+emp.getEmpName()+"\temp desig:"+emp.getEmpDesig()+"\temp salary"+emp.getSalary()+"\tyears of experience"+emp.getYearsofExp());
		}
	}
	@Override
	public List<Employee> deleteEmployee(List<Employee> list) {
		// TODO Auto-generated method stub
		Employee emp=null;
		System.out.println("Enter employee Id");
		int id=sc.nextInt();
		for(Employee value:list)
		{
			if(value.getEmpId()==id)
			{
				emp=value;
			}
		}
		try {
			if(emp!=null)
				list.remove(emp);
			else
				throw new MyException("employee id-", id, " not exist");
		}
		catch(MyException e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static void displayEmployee(Employee emp) {
		// TODO Auto-generated method stub
			if(emp!=null)
				System.out.println("EmpId:"+emp.getEmpId()+"\temp name:"+emp.getEmpName()+"\temp desig:"+emp.getEmpDesig()+"\temp salary"+emp.getSalary()+"\tyears of experience"+emp.getYearsofExp());	
	}
	public static int selectChoice() {
		// TODO Auto-generated method stub
		System.out.println("Enter your choice:\n1.To add details\n2.To update salary by\n3.To display employee by Id\n4.To delete an employee by Id\n5.To display all employees");
		int choice=intValidate();
		choice=checkPositive(choice);
		return choice;
	}

	private static int checkPositive(int choice) {
		if(choice<0)
	 	{
	 		System.out.println("Size cant be negative.so,please enter proper size");
	 		choice=sc.nextInt();
	 	}
	 	return choice;
	}
	private static int intValidate() {
		int data=0;
	 	boolean validation=false;
	 	while(validation==false)
	 	{
	 		if(sc.hasNextInt())
	 		{
	 			data=sc.nextInt();
	 			validation=true;
	 		}
	 		else if(!sc.hasNextInt())
	 		{
	 			System.out.println("Entered number is not a integer.Please enter integer");
	 			sc.next();
	 		}
	 	}
	 	return data;

		// TODO Auto-generated method stub
		
	}
}

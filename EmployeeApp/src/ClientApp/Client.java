package ClientApp;

import java.util.ArrayList;
import java.util.List;

import Entity.Employee;
import service.serviceImplement.Service;

public class Client {
	
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<Employee>();
		Service service=new Service();
		boolean check=true;
		do
		{
			int choice=Service.selectChoice();
			switch(choice)
			{
			case 1:
				list=service.addEmployee(list);
				break;
			case 2:
				list=service.updateEmployeeSalary(list);
				break;
			case 3:
				Employee emp=service.getEmployeeById(list);
				Service.displayEmployee(emp);
				break;
			case 4:
				service.deleteEmployee(list);
				break;
			case 5:
				service.getAllEmployee(list);
				break;
			case 6:
				check=false;
				break;
			}
		
		}while(check);
}

	
}

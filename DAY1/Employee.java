package companyname.projectname.modulename;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
	String name;
	String city;
	int sal;
	Employee(String name, String city, int sal){
		this.name = name;
		this.city = city;
		this.sal = sal;
	}
	
	public static void main(String[] args) {
		List<Employee> E = new ArrayList<>();
		E.add(new Employee("E1","BOM", 1000));
		E.add(new Employee("E2","DEL", 1200));
		E.add(new Employee("E3","BLR", 1000));
		Collections.sort(E, new EmployeeSort());
		for(int i=0; i<3; i++) {
			System.out.println(E.get(i).name);
		}
	}

}

class EmployeeSort implements Comparator{

	@Override
	public int compare(Object O1, Object O2) {
		
		Employee E1 = (Employee) O1;
		Employee E2 = (Employee) O2;
		
		if((E1.sal - E2.sal) !=0)
			return E2.sal - E1.sal;
		
		return E1.city.compareTo(E2.city);
	}
	
}

package companyname.projectname.modulename;

import java.util.*;

class User{
	String id;
	String name;
	User(String id, String name){
		this.id = id;
		this.name = name;
	}
}

class Employee extends User{
	Address address;
	Project project;
	double salary;
	Employee(String id, String name, Address address, Project project, double salary){
		super(id, name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}
	
}

class Address{
	String city;
	String zipCode;
	Address(String city, String zipCode){
		this.city = city;
		this.zipCode = zipCode;
	}
}

class Project{
	int projectId;
	String name;
	double budget;
	Project(int projectId,String name,double budget){
		this.projectId = projectId;
		this.name = name;
		this.budget = budget;
	}
	
	boolean equals(Project p) {
		return this.projectId == p.projectId;
	}
}

class EmployeeSort implements Comparator{

	@Override
	public int compare(Object O1, Object O2) {
		
		Employee E1 = (Employee) O1;
		Employee E2 = (Employee) O2;	
		return (int)(E2.salary - E1.salary);
	}
	
}

public class ProjectAlloc {

	public static void main(String[] args) {
		List<Project> P = new ArrayList<>();
		P.add(new Project(1, "XYZ1", 1000.0D));
		P.add(new Project(2, "XYZ2", 2000.0D));
		List<Employee> E = new ArrayList<>();
		List<User> U = new ArrayList<>();
		U.add(new User("201", "Jofra"));
		U.add(new User("202", "Jack"));
		U.add(new Employee("101", "Mohak Goel",
							new Address("Mau", "275101"),
							P.get(0),
							500.0D));
		U.add(new Employee("102", "Rupanshi Goel",
				new Address("Mau", "275101"),
				P.get(0),
				300.0D));
		U.add(new Employee("103", "Pankhuri Goel",
				new Address("Mau", "275101"),
				P.get(0),
				600.0D));
		U.add(new Employee("104", "Julie",
				new Address("Mau", "275101"),
				P.get(1),
				500.0D));
		U.add(new Employee("105", "Jhonny",
						new Address("Mau", "275101"),
						P.get(1),
						800.0D));
		U.add(new Employee("106", "James",
						new Address("Mau", "275101"),
						P.get(1),
						900.0D));
		
		for (User u : U) {
			if(u instanceof Employee)
				E.add((Employee)u);
		}
		
		Collections.sort(E, new EmployeeSort());
		
		for (Project project : P) {
			
			double budget=0.0D;
			
			System.out.println(project.name + " - "+ project.budget);
			
			for(int i=0; i<E.size(); i++) {
				
				if(project.equals(E.get(i).project)) {
					
					if(project.budget<(budget+E.get(i).salary))
						continue;
					
					budget+=E.get(i).salary;
					System.out.println(E.get(i).name + " - " + E.get(i).salary);
				
				}
			}
		}
	}

}

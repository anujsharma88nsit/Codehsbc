import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class SampleApp {
	public static void main(String[] args){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", new Double(10000)));
		employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(12000)));
		employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", new Double(14000)));
		employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", new Double(15000)));
		employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", new Double(16000)));
		employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", new Double(12000)));
		employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", new Double(12000)));
		employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", new Double(16000)));
		employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", new Double(20000)));
		employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", new Double(14000)));

		FindAverageSalaryApp app = new FindAverageSalaryApp();
		app.findAverageSalary(employees);	
	}
}

class FindAverageSalaryApp {
	public void findAverageSalary(List<Employee> employees){
		Map<String, Map<String, Double>> map = employees.parallelStream().collect(
				Collectors.groupingBy(e->e.getOfficeLocation(), 
						Collectors.groupingBy(e->e.getDesignation(), Collectors.averagingDouble(e->e.getSalary()))));
		map.forEach((a,b)->System.out.println(a+"-->"+b));
	}
}

class Employee {
	private String firstName;
	private String lastName;
	private String department;
	private String officeLocation;
	private String designation;
	private Double salary;

	public Employee(String firstName, String lastName, String department, String officeLocation, String designation, Double salary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.officeLocation = officeLocation;
		this.designation = designation;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDepartment() {
		return department;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public String getDesignation() {
		return designation;
	}

	public Double getSalary() {
		return salary;
	}
}

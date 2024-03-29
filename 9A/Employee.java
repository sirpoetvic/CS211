// A class to represent employees in general.
// Practice-IT Employee Class, changed a little by Iverson
// Bellevue College, January 2024
// private base fields changed to static
// added constructors for a name field
// added toString to at least show name
public class Employee {
	
	// Constructors and field added by Iverson
	// UW places fields at bottom, then changes for testing
	private String person;
	
	public Employee(String name) {
		person = name;
	}
	public Employee() {
		this("no name provided");
	}
	
	public String toString() {
		return person;
	}
	
	// remaining code below from U.W.
	public int getHours() {
		return baseHours;                // 40 hours/week
	}

	public double getSalary() {
		return baseSalary;               // $40,000.00
	}

	public int getVacationDays() {
		return baseVacationDays;         // 10 days
	}

	public String getVacationForm() {
		return baseVacationForm;         // yellow
	}

	// From UW:
	// These are so that test cases can change the base values
	// and make sure that subclasses also change their values.
	// (Your code that you submit is NOT supposed to directly use, call,
	// or modify the values below!  They are here only to help Practice-It
	// successfully test your code.  Please ignore them.)
	
	private static int baseHours = 40;
	private double baseSalary = 40000.0;
	private int baseVacationDays = 10;
	private String baseVacationForm = "yellow";
	
	public final void setBaseHours(int hours) {
		baseHours = hours;
	}
	public final void setBaseSalary(double salary) {
		baseSalary = salary;
	}
	public final void setBaseVacationDays(int days) {
		baseVacationDays = days;
	}
	public final void setBaseVacationForm(String form) {
		baseVacationForm = form;
	}
}
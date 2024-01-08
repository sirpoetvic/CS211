package Chapter_9A_Quiz;

/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/7/24
 * Chapter 9a Quiz
 * Data structure class for a Marketer
 */
public class Marketer extends Employee {
    //Empty Constructor
    public Marketer() {
        super();
    }

    //Adds an addition 10,000 dollars for Marketer position
    @Override
    public double getSalary() {
		return super.getSalary() + 10000;               // $50,000
	}

    //Additional toString for Marketer
    @Override
    public String toString() {
        return "Act now, while supplies last!";
    }
}

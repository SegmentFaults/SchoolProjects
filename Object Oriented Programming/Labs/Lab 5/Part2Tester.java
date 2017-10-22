/**
 * 
 * @author gentilm5
 *
 */
public class Part2Tester {
	public static void main(String[] args) {
		//test all the constructors
		Employee employee1=new Employee("SteveTheEmployee", 5);
		Manager manager1=new Manager("SteveTheManager", 10, "Steve's Department");
		Executive executive1=new Executive("SteveTheExecutive", 25, "SteveTheExecutive's Department", "Room 141");
		//Print out all of the the variables to make sure the constructors did everything correctly.
		System.out.println(employee1.toString());
		System.out.println("Expected: SteveTheEmployee 5");
		System.out.println(manager1.toString());
		System.out.println("Expected: SteveTheManager 10 Steve's Department ");
		System.out.println(executive1.toString());
		System.out.println("Expected: SteveTheExecutive 25 SteveTheExecutive's Department Room 141");
		//We were told not to test the getters and the setters
	}

}

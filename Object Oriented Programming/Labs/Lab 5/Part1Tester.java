
public class Part1Tester {

	public static void main(String[] args) {
		//test all the constructors
		Person person1=new Person("JimThePerson", 1990);
		Student student1=new Student("JimTheStudent", 1991, "Finance");
		Instructor instructor1=new Instructor("JimTheInstructor", 1989, 100000);
		System.out.println(person1.toString());
		System.out.println("Expected: JimThePerson 1990");
		System.out.println(student1.toString());
		System.out.println("Expected: JimTheStudent 1991 Finance");
		System.out.println(instructor1.toString());
		System.out.println("Expected: JimTheInstructor 1989 100000");
		//since the toString prints all the information, they are tested.
		
		
		
		//now all methods will be tested.
		
		//I will utilize the most generic version of the class possible to call the methods
		//Otherwise put, I will put the super class method when possible.
		person1.setName("NewNameJim");
		System.out.println(person1.getName());
		System.out.println("Expected: NewNameJim");
		person1.setYearBorn(1800);
		System.out.println(person1.getYearBorn());
		System.out.println("Expected: 1800");
		student1.setMajor("NewMajorJim");
		System.out.println(student1.getMajor());
		System.out.println("Expected: NewMajorJim");
		instructor1.setSalary(1);
		System.out.println(instructor1.getSalary());
		System.out.println("Expected: 1");
	}

}

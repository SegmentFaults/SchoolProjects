/**
 * 
 */
package edu.miamioh.gentilm5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author gentilm5
 *
 */
public class Person implements Comparable<Person> {
	private String name;
	/**
	 * 
	 * @param name of the person
	 */
	Person (String name){
		this.name=name;
	}
	@Override
	/**
	 * @param comparedPerson is the person that is compared
	 * This method simply utilize the String compareTo method.
	 */
	public int compareTo(Person comparedPerson) {
		return name.compareTo(comparedPerson.name);
	}
	public static void main(String[] args){
		//declare a scanner and an array of Strings to work with.
		Person people[]=new Person[10];
		Scanner scanner=new Scanner(System.in);
		for (int x=0; x<10; x++){
			//take in the Names.
			System.out.println("Give a name then press enter.");
			people[x]=new Person(scanner.nextLine());
		}
		//sort the arrays
		Collections.sort(Arrays.asList(people));
		//print out the first and the last person in the list. 
		System.out.println(people[0].name);
		System.out.println(people[9].name);
	}

}

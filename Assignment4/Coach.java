/* Assignment #: 4
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 2 hours
 Description: Coach Class for Assignment 4, creates a coach class that instantiates a Coach's first name and last name and years coached to use in Assignment 4 main.
 */
public class Coach {
//instantiate private variables used in Coach class
	private String firstName;
	private String lastName;
	private int yearsCoached;
	
// Default Constructor used to set variables to null or nothing to be changed later 
	public Coach() {
		firstName = "?";
		lastName = "?";
		yearsCoached = 0;
	}
	
//Overloaded Constructor used to set variables to variables being put in
	public Coach(String firstName, String lastName, int yearsCoached) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsCoached = yearsCoached;
	}
	
//getter methods used to grab the variables to be used outside of this class
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getYearsCoached() {
		return yearsCoached;
	}
	
//setter methods used to set variables to the variables being inputed
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setYearsCoached(int yearsCoached) {
		this.yearsCoached = yearsCoached;
	}
	
//Used to change variables to string
	public String toString() {
		return "\nLast Name:\t"+ lastName + "\nFirst Name:\t" + firstName + "\nYears of Experience:\t"+ yearsCoached + "\n";
	}
}

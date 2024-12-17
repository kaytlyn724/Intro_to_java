/* Assignment #: 4
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 2 hours
 Description: Team Class for Assignment 4, creates a team class that instantiates a team name, a team coach from Coach class, and a team city to use in Assignment 4 main.
 */
public class Team {
//instantiate private variables used in Team class
	private String name;
	private Coach coach;
	private String city;
	
// Default Constructor used to set variables to null or nothing to be changed later 
	public Team() {
		name = "?";
		Coach coach = new Coach();
		city = "?";
	}
	
//Overloaded Constructor used to set variables to variables being put in
	public Team(String name, Coach coach, String city) {
		this.name = name;
		this.coach = coach;
		this.city = city;
	}
	
//getter methods used to grab the variables to be used outside of this class
	public String getName() {
		return name;
	}
	
	public Coach getCoach() {
		return coach;
	}
	
	public String getCity() {
		return city;
	}
	
//setter methods used to set variables to the variables being inputed
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
//Used to change variables to string
	public String toString() {
		return "Team's name:\t" + name + " from " + city + "\nCoach Information:" + coach.toString();
	}
}

/* Assignment #: 5
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 20 minutes
 Description: Mage class to instantiate Mage heroes for Assignment 5 class
*/
import java.text.NumberFormat;

public class Mage extends PlayerEntity {
	//instantiate private variables for this class
	private double mana;
	
	//constructor to make variables equal to themselves and set equal to 0
	public Mage(double health, String name, int stamina, int attack, double mana) {
		super (health, name, stamina, attack); //takes variables instantiated in class extended from
		this.mana = mana;
	}
	
	//sets combat power points based on this persons power
	public void computeCombatPower() {
		combatPoints = (int)((attack + health) * (1 + mana));
	}
	
	//turn to string to turn the information into one complete message for users
	public String toString() {
		NumberFormat fmt2 = NumberFormat.getPercentInstance(); //used to present a better formula
		String newToString = "\nMage Hero:" + super.toString() + "Mana:\t\t\t" + fmt2.format(mana) + "\n";
		return newToString;
	}
}
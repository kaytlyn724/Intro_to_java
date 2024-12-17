/* Assignment #: 5
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 20 minutes
 Description: Fighter class to instantiate fighter-type heros for Assignment 5 class
*/
import java.text.NumberFormat;

public class Fighter extends PlayerEntity {
	//instantiate private variables for this class
	private double armor;
	private int maxAttack;
	private Boolean isRanged;
	
	
	//constructor to make variables equal to themselves and set equal to 0
	public Fighter(double health, String name, int stamina, int attack, boolean isRanged) {
		super (health, name, stamina, attack); //takes variables instantiated in class extended from
		
		this.isRanged = isRanged;
		
		//decides if isRanged is true or false and makes variables equal to specific values based on this
		if (isRanged == true) {
			armor = 0.25;
			maxAttack = 125;
		}
		else {
			armor = 0.5;
			maxAttack = 100;
		}
	}
	
	//sets combat power points based on this persons power and is specific based on range type
	public void computeCombatPower() {
		if (maxAttack <= attack) {
			combatPoints = (int)((maxAttack + health) * (1 - armor));
		}
		else {
			combatPoints = (int)((attack + health) * (1 - armor));
		}
	}
	
	//turn to string to turn the information into one complete message for users
	public String toString() {
		NumberFormat fmt2 = NumberFormat.getPercentInstance(); //used to present a better formula
		String fighterRange;
		//prints specific text based on type of range
		if (isRanged == true) {
			fighterRange = "Ranged Type";
		}
		else {
			fighterRange = "Melee Type";
		}
		
		String newToString = "\nFighter Hero:\t\t" + fighterRange + "" + super.toString() + "Armor:\t\t\t" + fmt2.format(armor) + "\n";
		return newToString;
	}
	
	
}
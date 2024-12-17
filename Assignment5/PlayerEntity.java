/* Assignment #: 5
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 20 minutes
 Description: Player Entity class for Assignment 5.
 */

public abstract class PlayerEntity {
	//instantiate protected variables for extended classes to use
	protected double health;
	protected String entityName;
	protected int stamina;
	protected int attack;
	protected int combatPoints;
	
	//constructor to make variables equal to themselves and set equal to 0
	public PlayerEntity(double health, String name, int stamina, int attack) {
		this.health = health;
		entityName = name;
		this.stamina = stamina;
		this.attack = attack;
		combatPoints = 0;
	}
	
	//getter method to allow variable to be used outside of this class
	public int getCombatPoints() {
		return combatPoints;
	}
	
	//abstract method to be extended onto child classes used to be changed specifically for those classes
	abstract void computeCombatPower();
	
	//turn to string to turn the information into one complete message for users
	public String toString() {
		return ("\nHero name:\t\t"+ entityName + "\nCurrent Health:\t\t" + health + "\nStamina:\t\t" + stamina + "\nAttack Damage:\t\t" + attack + "\nCurrent Combat Points:\t"+ combatPoints +"\n");
	}
}

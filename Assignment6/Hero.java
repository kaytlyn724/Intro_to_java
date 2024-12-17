/* Assignment #: 6
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 2 days
 Description: Hero class used to create heros to be implemented and shown to the user in other classes
 */

public class Hero {
	private String name;
	private String type;
	private int strength;
	private int charisma;
	private int damage;
	
	/**
	 * 
	 * @param _name Name
	 * @param _type	Type (Mage or Fighter)
	 * @param _strength Strength
	 * @param _charisma Charisma
	 * @param _damage Damage
	 */
	public Hero(String _name, String _type, int _strength, int _charisma, int _damage) {
		this.name = _name;
		this.type = _type;
		this.strength = _strength;
		this.charisma = _charisma;
		this.damage = _damage;
	}
	
	public Hero() {
		this("?", "?", 0, 0, 0);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getCharisma() {
		return charisma;
	}


	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}


	public double getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public String toString() {
		return String.format("Hero name: %s\t\t\t(%s)\nStrength: %d\tCharisma: %d\tDamage: %d\n", this.name, this.type, this.strength, this.charisma, this.damage);		
	}
}

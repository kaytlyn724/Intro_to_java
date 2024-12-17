/* Assignment #: 5
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 30 minutes
 Description: PlayerParser class for Assignment 5 used to parse through a line of text inputed by a user and split to create the type of hero they are from other classes used in Assignment 5.
*/

public class PlayerParser {
	
	public static PlayerEntity parseNewPlayer(String lineToParse) {
		String[] arr = lineToParse.split("/"); //decides where to break in the String to split into parts
		
		//decides what type of hero this player has picked and parses based on that.
		if ((arr[0].toUpperCase()).equals("MAGE")) {
			Mage mage = new Mage(Double.parseDouble(arr[1]), arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Double.parseDouble(arr[5]));
			return mage;
		}
		//decides what type of fighter this player has picked and parses based on that.
		else {
			if ((arr[5].toUpperCase()).equals("RANGE")) {
				Fighter fighter = new Fighter(Double.parseDouble(arr[1]), arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), true);
				return fighter;
			}
			else {
				Fighter fighter = new Fighter(Double.parseDouble(arr[1]), arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), false);
				return fighter;
			}
		}
		
	}
}
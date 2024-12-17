// Assignment: 11
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 hours
// Description: Used to create a new node and get the x or y of the node.

public class Node extends MazeSolver{
	
	private int x;
	private int y;
	
	public Node(int y, int x) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
}

// Assignment: 11
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 hours
// Description: MazeSolver class offers useful methods to print a maze given 
// after the easter bunny goes through it to find eggs. Uses the depthFirstSearch class to branch through the maze.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MazeSolver {
	
	private Stack<Node> stack;
	private char[][] maze;
	private int eggFound;
	private int mHeight;
	private int mWidth;
	
	
	public MazeSolver() {
		
		stack = new Stack<Node>();
		eggFound = 0;
	}
	
	public void printMaze() {
		
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void depthFirstSearch() {
		
		Node first = new Node(0,0);
		stack.push(first);
		
		while(stack.isEmpty() == false) {
			
			Node find = stack.pop();
			
			if(maze[find.getY()][find.getX()] == 'E') {
				
				eggFound++;
				maze[find.getY()][find.getX()] = 'x';
			}
			
			//SOUTH DIRECTION 
			
			if ((find.getY() + 1) < mHeight) {
				
				if((maze[find.getY() + 1][find.getX()] != '#') && (maze[find.getY() + 1][find.getX()] != 'x')) {
					
					if((maze[find.getY() + 1][find.getX()] == 'E') || (maze[find.getY() + 1][find.getX()] == '.')) {
						
						Node posNode = new Node(find.getY() + 1, find.getX());
						stack.push(posNode);
						maze[find.getY()][find.getX()] = 'x';
						
					}
					
				}
			}
			
			//EAST DIRECTION
			
			if ((find.getX() + 1) < mWidth) {
				
				if((maze[find.getY()][find.getX() + 1] != '#') && (maze[find.getY()][find.getX() + 1] != 'x')) {
					
					if((maze[find.getY()][find.getX() + 1] == 'E') || (maze[find.getY()][find.getX() + 1] == '.')) {
						
						Node posNode = new Node(find.getY(), find.getX() + 1);
						stack.push(posNode);
						maze[find.getY()][find.getX()] = 'x';
						
					}
					
				}
			}
			
			//NORTH DIRECTION
			
			if ((find.getY() - 1) >= 0) {
				
				if((maze[find.getY() - 1][find.getX()] != '#') && (maze[find.getY() - 1][find.getX()] != 'x')) {
					
					if((maze[find.getY() - 1][find.getX()] == 'E') || (maze[find.getY() - 1][find.getX()] == '.')) {
						
						Node posNode = new Node(find.getY() - 1, find.getX());
						stack.push(posNode);
						maze[find.getY()][find.getX()] = 'x';
						
					}
					
				}
			}
			
			//WEST DIRECTION
			
			if ((find.getX() - 1) >= 0) {
				
				if((maze[find.getY()][find.getX() - 1] != '#') && (maze[find.getY()][find.getX() - 1] != 'x')) {
					
					if((maze[find.getY()][find.getX() - 1] == 'E') || (maze[find.getY()][find.getX() - 1] == '.')) {
						
						Node posNode = new Node(find.getY(), find.getX() - 1);
						stack.push(posNode);
						maze[find.getY()][find.getX()] = 'x';
						
					}
					
				}
			}
			
			maze[find.getY()][find.getX()] = 'x';
		}
		
	}

	public int getEggFound() {
		
		return eggFound;
	}
	
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

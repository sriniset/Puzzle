/*
 * Java enum Cardinal
 * 
 * This enum delineates which numerical values are given to which cardinal direction
 * that the puzzle pieces are in. This enum will be used to rotate the pieces when the user
 * needs to do so. 
 * 
 * Author: Srinivas Setty
 * Last Edited: April 25, 2016
 */
public enum Cardinal {
	
	// declaration and assignment of each enum
	NORTH(0), EAST(1), SOUTH(2), WEST(3); 

	// a private int to represent the direction in the enum
	private int dir; 

	// a private ctor for the enum, the direction is the value of the given enum
	private Cardinal(int n){
		dir = n; 
	}
	/* a public getter for other classes to have access to the direction of a piece
	 * parameter: none
	 * return: the direction
	 */
	public int getDir(){
		return dir; 
	}
}

/*
 * Java enum Side
 * 
 * This enum delineates what numerical value will be given to which shape on the puzzle piece. 
 * There are four different shapes that the puzzles utilize, being heart, diamond, club, and spade,
 * and there are also some shapes that point inwards, and others that point outwards. This means that there
 * are eight unique numbers overall for each shape. The out version of a shape is just the negative 
 * of the in version so that when determining if a piece fits, if the sum of the shapes equals 0, the piece
 * will fit within that area. 
 * 
 * Author: Paul Nelson
 * Last Edited: April 25, 2016
 * 
 */



public enum Side {
	
	// declaration and assignment 
	HEART_IN(1), HEART_OUT(-1), DIAMOND_IN(2), DIAMOND_OUT(-2), CLUB_IN(3), CLUB_OUT(-3), SPADE_IN(4), SPADE_OUT(-4);

	private int num;

	private Side(int n){
		num=n;
	}

	public int getNum(){
		return num;
	}

}

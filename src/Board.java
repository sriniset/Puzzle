
public class Board {
	private int height; 
	private int width; 
	private Piece[][] board; 

	public int getHeight(){
		return this.height; 
	}

	public int getWidth(){
		return this.width; 
	}

	public Piece getPiece(int row, int col){
		if(!isValid(row,col) || !isOccupied(row,col)){
		return null; 
		}
		return this.board[row][col];
		
	}

	public Board(int width ,int height ){
		this.width = width;
		this.height=height;
		this.board = new Piece[width][height]; 

	}


	public boolean isOccupied(int row, int col){
		
		return (isValid(row,col) && this.board[row ][col] != null );
	}


	public Piece placePiece(int row, int col, Piece piece){
		if (isValid(row,col) && this.isOccupied(row, col)){
			return this.getPiece(row, col); 
		}

		this.board[row][col] = piece;

		return piece; 

	}


	public Piece removePiece(int row, int col){
//		if(!isValid(row,col) && !isOccupied(row,col)){
//			return null;
//		}
		Piece x = this.getPiece(row, col); 
		this.board[row][col] = null;
		return x; 

	}

	public boolean isValid(int row, int col){
		
		return ((row>=0 && row<3) && (col>=0 && col<3));
			

	}


	public void clear(){
		Piece[][] newArray = new Piece[board.length][board[0].length];
		board = newArray;
	}

	public String toString(){
		String printer = "";
		for (Piece[] row : this.board) {
			for (Piece piece : row) {
				printer += piece + " ";
			}
			printer += '\n';
		}
		return printer;
	}



	//	public static void main(String [] args){
	//	Board board = new Board(5,5); 
	//	Piece piece = new Piece(4); 
	//	System.out.println( board.isValid(90, 90)); 
	//	System.out.println(board);
	//	board.placePiece(2, 3, piece);
	//	System.out.println(board.isOccupied(2, 3));
	//	System.out.println(board);
	//	board.removePiece(2,3); 
	//	System.out.println(board);
	//	board.placePiece(2, 3, piece);
	//	System.out.println(board);
	//	board.clear(); 
	//	System.out.println(board);
	//	
	//	Test code with a dummy piece class, that's why the piece ctor is weird	
	//	}




}

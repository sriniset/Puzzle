import java.util.ArrayList;

public class PuzzleTester {

	
	
	
	public static void main(String[] args){
		Piece p1 = new Piece(Side.DIAMOND_OUT, Side.CLUB_OUT, Side.CLUB_IN, Side.DIAMOND_IN);
		Piece p2 = new Piece(Side.CLUB_OUT, Side.HEART_OUT, Side.DIAMOND_IN, Side.CLUB_IN);
		Piece p3 = new Piece(Side.SPADE_OUT, Side.DIAMOND_OUT, Side.SPADE_IN, Side.HEART_IN);
		Piece p4 = new Piece(Side.HEART_OUT, Side.SPADE_OUT, Side.SPADE_IN, Side.CLUB_IN);
		Piece p5 = new Piece(Side.HEART_OUT, Side.DIAMOND_OUT, Side.CLUB_IN, Side.CLUB_IN);
		Piece p6 = new Piece(Side.SPADE_OUT, Side.SPADE_OUT, Side.HEART_IN, Side.CLUB_IN);
		Piece p7 = new Piece(Side.HEART_OUT, Side.DIAMOND_OUT, Side.DIAMOND_IN, Side.HEART_IN);
		Piece p8 = new Piece(Side.SPADE_OUT,Side.DIAMOND_OUT, Side.HEART_IN, Side.DIAMOND_IN);
		Piece p9 = new Piece(Side.CLUB_OUT, Side.HEART_OUT, Side.SPADE_IN, Side.HEART_IN);
		
		ArrayList<Piece> queue = new ArrayList<Piece>(){{
			add(p1);
			add(p2);
			add(p3);
			add(p4);
			add(p5);
			add(p6);
			add(p7);
			add(p8);
			add(p9);
		}
		};
		System.out.println(queue);
		Puzzle test = new Puzzle(3,3,queue);
		System.out.println();
		//System.out.println(test.getList());
		//test.printPuz();
		test.solve();
//		System.out.println(test.getPiece(1, 1));
//		System.out.println(test.isSolved());
		System.out.println(test.isSolved());
		test.printPuz();
//		for(int r = 0; r<test.getHeight();r++){
//			for(int c = 0; c<test.getWidth();c++){
//				System.out.println(test.getPiece(r, c));
//			}
//		}
		
	}
}


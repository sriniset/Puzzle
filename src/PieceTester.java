
public class PieceTester {
	


		public static void main(String[] args){
			Piece test1 = new Piece(Side.HEART_IN, Side.CLUB_OUT, Side.SPADE_IN, Side.DIAMOND_OUT);
			System.out.println(test1.toString());
			//			System.out.println(test1.getRotation());
			//			test1.rotateClockwise();
			//			test1.rotateClockwise();
			//			System.out.println(test1.getRotation());
			//			test1.rotateCounterClockwise();
			//			System.out.println(test1.getRotation());
			//			
			//			
			//			test1.rotateCounterClockwise();
			//			test1.rotateCounterClockwise();
			//			test1.rotateCounterClockwise();
			//			test1.rotateCounterClockwise();
			////			test1.rotateCounterClockwise();
			////			test1.rotateCounterClockwise();
			//
			//			System.out.println(test1.getRotation());

			System.out.println(test1.getSide(Cardinal.SOUTH));

		}


	}

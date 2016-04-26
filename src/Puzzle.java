
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle {

	private Board board; 
	private ArrayList<Piece> list;

	public Puzzle( int width, int height, ArrayList<Piece> list){
		this.board = new Board(width,height); 
		this.list = list;
	}
	public int getWidth(){
		return this.board.getWidth();
	}
	public int getHeight(){
		return this.board.getHeight();
	}
	public ArrayList<Piece> getList(){
		return list;
	}

	public boolean isSolved(){
		for(int row = 0; row<this.getHeight();row++){
			for(int col=0; col<this.getWidth();col++){
				if(!this.board.isValid(row,col) || !this.board.isOccupied(row,col) || !this.doesFit(row, col, this.getPiece(row, col))){
					return false;
				}
			}
		}
		return true; 
	}

	//	private static Side getAdjacent(Cardinal car, Piece piece){
	//		//int rotated = piece.getRotation();
	//		Side adjSide = piece.getSide(Cardinal.NORTH);
	//		if(car==Cardinal.WEST){
	//			adjSide=piece.getSide(Cardinal.EAST);
	//		}
	//		else if(car==Cardinal.NORTH){
	//			adjSide=piece.getSide(Cardinal.SOUTH);
	//		}
	//		else if(car==Cardinal.EAST) adjSide=piece.getSide(Cardinal.WEST);
	//		return adjSide;
	//		
	//	}

	private boolean northFit(int row, int col, Piece p){
		boolean nFit = false;
		if((!this.board.isValid(row-1,col)) || !this.board.isOccupied(row-1, col)){
			nFit = true;
		}

		else if(sideFit(p.getSide(Cardinal.NORTH), getPiece(row-1, col).getSide(Cardinal.SOUTH) )){
			nFit=true;
		}
		return nFit;
	}
	private boolean eastFit(int row, int col, Piece p){
		boolean eFit = false;
		if((!this.board.isValid(row,col+1)) || !this.board.isOccupied(row, col+1)){
			eFit = true;
		}

		else if(sideFit(p.getSide(Cardinal.EAST), getPiece(row, col+1).getSide(Cardinal.WEST) )){
			eFit=true;
		}
		return eFit;
	}
	private boolean southFit(int row, int col, Piece p){
		boolean sFit = false;
		if((!this.board.isValid(row+1,col)) || !this.board.isOccupied(row+1, col)){
			sFit = true;
		}

		else if(sideFit(p.getSide(Cardinal.SOUTH), getPiece(row+1, col).getSide(Cardinal.NORTH) )){
			sFit=true;
		}
		return sFit;
	}
	private boolean westFit(int row, int col, Piece p){
		boolean wFit = false;
		if((!this.board.isValid(row,col-1)) || !this.board.isOccupied(row, col-1)){
			wFit = true;
		}

		else if(sideFit(p.getSide(Cardinal.WEST), getPiece(row, col-1).getSide(Cardinal.EAST) )){
			wFit=true;
		}
		return wFit;
	}

	public boolean doesFit(int row, int col, Piece p){

		boolean fits = false;
		//System.out.println("doesfit called"+row+"    "+col);
		if(!this.board.isValid(row,col)){
			System.out.println("does fit thinks orig call not valid. Row = "+row+ "isValid(row,col) = "+ this.board.isValid(row,col));
			return false;
		}
		else if(northFit(row,col,p)){
			if(eastFit(row,col,p)){
				if(southFit(row,col,p)){
					if(westFit(row,col,p)){
						fits = true;
					}

				}

			}

		}
		System.out.println("doesFit returns "+fits);
		return fits;
	}

	private boolean sideFit(Side s1, Side s2){
		//System.out.println("sideFit called");
		if((s1.getNum()+s2.getNum())==0){
			return true;
		}
		//		else if(s1==null || s2==null){
		//			return true;
		//		}
		return false;
	}

	public void solve(){
		this.placePiece(0, 0, this.list.get(0));
		solve(2);
		
	}
	public void solve(int times){
		int row = (times-1)/3;
		int col= (times-1)%3;
		if(times<=9 && times>=1){
			
			Piece p = list.get(0);
			for(int rotate = 0;rotate <4;rotate++){
				if(doesFit(row,col,p)){
					placePiece(row,col,p);
					solve(times+1);
					rotate += 10;
				}
				else if(!doesFit(row,col,p)){
					if(rotate==4){
						removePiece((times-2)/3,(times-2)%3);
						solve(times-1);
					}
				}
			}
		}
		
	}
	
	
//	public void solve(int row, int col){
//		if(row<3 && col < 3 && list.size()>0 && row >-1 && col >-1 /*&& !this.isSolved()*/){
//			boolean solved = false;
//			int i = 0;
//		
//
//			for (int index = 0; index < list.size() && !solved; index++) {
//				Piece piece = list.get(index);
//				for (int rotate=0; rotate <= 4 && !solved; ) {
//					System.out.println("row = "+row+" col="+col+"rotation = "+piece.getRotation());
//					solved = this.doesFit(row, col, piece);
//					if(solved){
//						i++;
//						System.out.println("forward,  "+i);
//						this.placePiece(row, col, piece);
//						if(col==2){
//							this.solve(row+1, 0);
//						}else this.solve(row, col+1);
//					} else if(!solved){
//						piece.rotateClockwise();
//						rotate++;
//					}
//					
//
//					
//				}
//			}
//
//			if(!solved){
//				i--;
//				System.out.println("backward  "+i);
//				if(col>0){
//					
//					this.removePiece(row, col-1);
//					this.shuffle();
//					solve(row,col-1);
//				}
//				else if(col==0){
//					this.removePiece(row-1, 2);
//					this.shuffle();
//					this.solve(row-1, 2);
//				}
//
//
//				
//			}
//
//			
//		}
//	}

	//	public void solve() {		// try with recursion instead (maybe)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//		boolean solved = false;
	//		System.out.println("solve called");
	//		System.out.println(this.getHeight());
	//		for (int row = 0; row < this.getHeight(); row++) {
	//			System.out.println("first for passed in solve");
	//			for (int col = 0; col < this.getWidth(); col++) {
	//System.out.println("second for passed");
	//				solved = false;
	//				for (int index = 0; index < list.size() && !solved; index++) {
	//					System.out.println("third for passed");
	//					for (int rotate = 0; rotate <= 4 && !solved; rotate++) {
	//						System.out.println("row = "+row+" col="+col+"");
	//						if (doesFit(row, col, list.get(index))) {
	//							solved = true;
	//							this.placePiece(row, col, list.get(index));
	//							System.out.println(this.getPiece(row, col)+"placed at "+row+" , "+col);
	//						}
	//						
	//						else list.get(index).rotateClockwise();
	//					}
	//					if (index == list.size() && !solved){
	//						
	//						if(col>0){
	//							col--;
	//							this.removePiece(row, col);
	//						}
	//						else if(col==0 && row >0 ){
	//							col = this.getWidth()-1;
	//							row--;
	//							this.removePiece(row, col);
	//						}
	//						
	//						
	//						
	//						//solvable = false;
	//					}
	//						
	//				}
	//
	//			}
	//		}
	//		System.out.println("solve ended");
	//	}

	public void shuffle(){
		//this.clear();
		Collections.shuffle(list);
	}

	public void clear(){
		for(int row = 0; row<board.getHeight(); row++){
			for(int col = 0; col<board.getWidth(); col++){
				if(getPiece(row, col) != null){
					this.list.add(getPiece(row,col));
				}
			}
		}
		this.board.clear(); 
	}

	public Piece placePiece(int row, int col, Piece p){
		System.out.println("placePiece called");
		if(!doesFit(row,col,p)){
			return null;
		}
		int index = list.indexOf(p);
		list.remove(index);
		return this.board.placePiece(row, col, p); 
	}


	public Piece removePiece(int row, int col){
		Piece p = this.board.removePiece(row,col);
		this.list.add(p);
		return p;
	}


	public Piece getPiece(int row, int col){
		if(!this.board.isValid(row,col)){
			return null;
		}
		return this.board.getPiece(row, col);
	}

	public void printPuz(){
		//System.out.println(list);
		String charby = " + ";
		String str = "";
		System.out.println("Printing has started");
		for(int row=0; row<this.board.getHeight(); row++){
			for(int col0 = 0;col0<this.board.getWidth();col0++){

				System.out.print(charby+charby+this.getPiece(row,col0).getSide(Cardinal.NORTH)+charby);
			}
			System.out.println();
			for(int col1 = 0; col1<this.board.getWidth(); col1++){
				System.out.print(this.getPiece(row, col1).getSide(Cardinal.WEST)+charby+list.indexOf(getPiece(row,col1))+charby+this.getPiece(row, col1).getSide(Cardinal.EAST));
			}
			System.out.println();
			for(int col2 = 0;col2<this.board.getWidth();col2++){
				System.out.print(charby+charby+this.getPiece(row,col2).getSide(Cardinal.SOUTH)+charby);
			}
			System.out.println("hi");
		}
		System.out.println("Printing has ended");
		//		return str;

	}

	//getList method

}
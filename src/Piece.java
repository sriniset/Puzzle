
public class Piece {
	private Side north;
	private Side east;
	private Side south;
	private Side west;
	private int rotation;
	
	public Piece(Side north, Side east, Side south, Side west){
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.rotation = 0;
	}
	public int getRotation(){
		return rotation;
	}
	public Side getSide(Cardinal car){
		if(this.equals(null)) return null;
		Side s=west;
		if(car==Cardinal.NORTH){
			s=north;
		}
		else if(car==Cardinal.EAST){
			s=east;
		}
		else if(car==Cardinal.SOUTH){
			s=south;
		}
		
		return s;
	}
	
	public void rotateClockwise(){
		rotation++;
		rotation = rotation%3;
		Side northTemp = north;
		north=east;
		east=south;
		south=west;
		west=northTemp;
	}
	
	//recheck this at a later date
	public void rotateCounterClockwise(){
		rotation--;
		if(rotation<0){
		rotation = rotation+4;
		}
		Side northTemp = north;
		north=west;
		west=south;
		south=east;
		east=northTemp;
	}
	
	public String toString(){
		String s = "";
		if(this.equals(null)){
			return null;
		}
		s="<||>" +"North =" +north+" East= "+east+" South= "+south+" West= "+west+" Rotation at "+rotation+ "<||> \n";
		return s;
	}
	
}



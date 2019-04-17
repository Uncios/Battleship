



public class Cell{

	private Piece piece;
	private boolean selected=false;

	public Cell(){
	}
	
	public CellStatus changeStatus(){
		if (!this.selected){
			return(this.piece== null?CellStatus.full:CellStatus.empty);
		}
		if (!(this.piece==null)){
			return CellStatus.full;
		} 
		else {
			return CellStatus.empty;
		}
	}

    public CellStatus getStatus() {
        if (!this.selected) {
            return(this.piece == null?CellStatus.empty:CellStatus.full);
		}
		if (this.piece==null){
			return CellStatus.empty;
		}
		else {
			return CellStatus.full;
		}
	}

	public Piece getPiece() {
		return this.piece;
	}

}
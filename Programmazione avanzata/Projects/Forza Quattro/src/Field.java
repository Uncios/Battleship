

import java.util.List;
import java.util.LinkedList;
import java.util.function.BiFunction;


public class Field{

    public int length_DEFAULT=6;
    public int heigth_DEFAULT=5;
    private Cell[][] field;
    public CellStatus status;
    public int row;
    private int column;
    private Field myfield;
    private boolean control = false;
    private Piece piece;
    private Piece pezzo;

    public Field() {
        this.field=new Cell[this.length_DEFAULT][this.heigth_DEFAULT];
        fill();
    }

    private  void fill() {
        for (int i=0;i<this.heigth_DEFAULT;i++){
            for(int j=0;j<this.length_DEFAULT;j++){
                this.field[j][i]=new Cell();
            }
        }
    }

    public int getLength() {
        return this.length_DEFAULT;
    }

    public int getHeigth() {
        return this.heigth_DEFAULT;
    }

    public Integer choseSlot(int column){
        
        for (int i=0;i<=heigth_DEFAULT;i++){

            status=this.field[column][i].getStatus();

            if (status==CellStatus.full){
				this.field[column][i-1].changeStatus();
				row=i-1;
            }

            if (status==CellStatus.empty & i==heigth_DEFAULT){
                this.field[column][i].changeStatus();
                row=i-1;
            }
        }

        return row;
    }

    public boolean columnFull(int column){

        status=this.field[column][0].getStatus();

        if (status==CellStatus.full){
            return false;
        } else {
            return true;
        }
    }

    public int choseColumn(int column){
        if (column>6 & column<0) {
            System.out.println("The column chosen isn't avaible, please choose another");
        } else; {
            control=this.myfield.columnFull(column);
        }
        if (!control){
            System.out.println("The column is full, please chose another");
    } else; {
        return column;
        }
    }

    public CellStatus getStatus( int i , int j ) {
		return this.field[i][j].getStatus();
    }
    
    public boolean isInBound( int x , int y ) {
		if ((x<0)||(x>=this.length_DEFAULT)) return false;
		if ((y<0)||(y>=this.heigth_DEFAULT)) return false;
        return true;
    }
    
    public BiFunction<Integer,Integer,CellStatus> getView() {
		return (x,y) -> {
			if (!isInBound(x, y)) {
				return null;
			}
			return getStatus(x, y);
		};
    }
    
    public boolean WinCondition(Piece pezzo){
        
        boolean win = false;
        int count = 1;
        int column = pezzo.getX();
        int row = pezzo.getY();
        Color color = pezzo.getColor();
        count=CheckLeftRow(column, row, count);
        count=CheckRightRow(column, row, count);
        count=CheckColumn(column, row, count);
        count=CheckLeftUp(column, row, count);
        count=CheckLeftDown(column, row, count);
        count=CheckRightUp(column, row, count);
        count=CheckRightDown(column, row, count);
        if (count==4){
             win = true;
        }
        return win;
    }

    public Integer CheckLeftRow(int column, int row, int count){
        
        boolean position = true;
        int a = column;

        while (position){
            
            if (count==4){
                break;
            }
            pezzo = field[a][row].getPiece();
            a-=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, row)){
                piece=field[a][row].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckRightRow(int column, int row, int count){
        
        int a = column;
        boolean position = true;

        while (position){
            
            if (count==4){
                break;
            }
            pezzo = field[a][row].getPiece();
            a+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, row)){
                piece=field[a][row].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckColumn(int column, int row, int count){
        
        boolean position = true;
        int b = row;
        
        while (position){
            
            if (count==4){
                break;
            }
            pezzo = field[column][b].getPiece();
            b-=1;
            if (field[column][b].getStatus()==CellStatus.full & myfield.isInBound(column, b)){
            piece=field[column][b].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckLeftUp(int column, int row, int count){
        
        boolean position = true;
        int a = column;
        int b = row;

        while (position){
            
            if (count==4){
                break;
            }
            pezzo = field[a][b].getPiece();
            a-=1;
            b+=1;
            if (field[a][b].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            } 
            }
        }

        return count;
    }

    public Integer CheckLeftDown(int column, int row, int count){
        
        boolean position = true;
        int a = column;
        int b = row;

        while (position){

            if (count==4){
                break;
            }
            pezzo = field[a][b].getPiece();
            a+=1;
            b+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }

    public Integer CheckRightUp(int column, int row, int count){
        
        boolean position = true;
        int a = column;
        int b = row;
        
        while (position){

            if (count==4){
                break;
            }
            pezzo = field[a][b].getPiece();
            a+=1;
            b+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }
    
    public Integer CheckRightDown(int column, int row, int count){
        
        boolean position = true;
        int a = column;
        int b = row;
        
        while (position){

            if (count==4){
                break;
            }
            pezzo = field[a][b].getPiece();
            a+=1;
            b-=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }
}
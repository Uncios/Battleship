public class Direction{
    
    private Piece piece;
    private Piece pezzo;
    private Field myfield;
    
    public Integer CheckLeftRow(Cell[][] field, int row, int column, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int a = column;

        while (position){
            
            if (count==4){
                break;
            }
            this.pezzo = field[a][row].getPiece();
            a-=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, row)){
                piece=field[a][row].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckRightRow(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        int a = column;
        boolean position = true;

        while (position){
            
            if (count==4){
                break;
            }
            this.pezzo = field[a][row].getPiece();
            a+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, row)){
                piece=field[a][row].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckColumn(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int b = row;
        
        while (position){
            
            if (count==4){
                break;
            }
            this.pezzo = field[column][b].getPiece();
            b-=1;
            if (field[column][b].getStatus()==CellStatus.full & myfield.isInBound(column, b)){
            piece=field[column][b].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }

        return count;
    }

    public Integer CheckLeftUp(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int a = column;
        int b = row;

        while (position){
            
            if (count==4){
                break;
            }
            this.pezzo = field[a][b].getPiece();
            a-=1;
            b+=1;
            if (field[a][b].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            } 
            }
        }

        return count;
    }

    public Integer CheckLeftDown(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int a = column;
        int b = row;

        while (position){

            if (count==4){
                break;
            }
            this.pezzo = field[a][b].getPiece();
            a+=1;
            b+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }

    public Integer CheckRightUp(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int a = column;
        int b = row;
        
        while (position){

            if (count==4){
                break;
            }
            this.pezzo = field[a][b].getPiece();
            a+=1;
            b+=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }
    
    public Integer CheckRightDown(Cell[][] field, int column, int row, int count, Field myfield){
        
        this.myfield=myfield;
        boolean position = true;
        int a = column;
        int b = row;
        
        while (position){

            if (count==4){
                break;
            }
            this.pezzo = field[a][b].getPiece();
            a+=1;
            b-=1;
            if (field[a][row].getStatus()==CellStatus.full & myfield.isInBound(a, b)){
            piece=field[a][b].getPiece();
            if (piece.getColor()==this.pezzo.getColor()){
                count+=1;
            } else; {
                position=false;
            }
            }
        }
        
        return count;
    }
}
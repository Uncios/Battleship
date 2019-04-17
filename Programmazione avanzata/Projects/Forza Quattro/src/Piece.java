

public class Piece{
   
    private int x;
    private int y;
    private Color color;
   
    public Piece(int x, int y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;  
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Color getColor(){
        return this.color;
    }
    
    public String tostring(){
        return "<"+x+","+y+">";
    }

    public void setColor(int pid){
        if (pid==0){
             this.color=Color.red;
        }
        if (pid==1){
            this.color=Color.yellow;
        }
    }
}
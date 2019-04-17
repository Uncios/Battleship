import java.util.Random;

public class Computer implements Player{
    
    private int column;
    private Piece pezzo;
    private Color color;
    private int row;
    private Field myfield;
    private Random random;
    private int myId;
    private String name;

    public Computer(String name) {
		this.name = name;
		this.random = new Random();
    }
    
    public void Matchstart(){
        System.out.println("The match has started, first to go is the computer");
        this.myfield=new Field();
    }

    public void Win(){
        System.out.println("The computer has won");
    }
    
    public void Lose(){
        System.out.println("The computer has lost");
    }

    public int Turn(int pid){

        this.column=this.random.nextInt(myfield.getLength());
        this.myfield.choseColumn(column);
        return column;
    }

    public Piece NewPiece(int column, int pid){

        this.column=column;

        this.row=this.myfield.choseSlot(column);
        this.pezzo.setColor(pid);
        this.color=this.pezzo.getColor();
        this.pezzo = new Piece(column, row, color);
        return this.pezzo;
        
    }   

    public void init(int pid) {
		this.myId = pid;
		this.myfield = new Field();
		System.out.print("I have index "+pid);
	}
}
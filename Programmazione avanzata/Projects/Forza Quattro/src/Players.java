import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Players implements Player{

    public String name;
    private Field myfield;
    private BufferedReader in;
    private PrintStream out;
    private Random random;
    private Scanner tastiera;
    private int column;
    private Piece pezzo;
    private int row;
    private Color color;
    private int myId;

    public Players(String name){
        this(name,System.in,System.out);
    }
    public Players(String name, InputStream in, PrintStream out){
        this.name=name;
        this.in=new BufferedReader(new InputStreamReader(in));
        this.out=out;
        this.random=new Random();
    }

    public void Matchstart(){
        System.out.print("The match has started. It's your turn, this is the field:");
        this.myfield=new Field();
    }

    public int Turn(int pid){

        System.out.println("Chose the column where to enter the piece");
        
        this.tastiera=new Scanner(in);
        this.column=tastiera.nextInt();
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
    public void Lose(){
        System.out.println("The computer has won, you lost");
    }

    public void Win(){
        System.out.println("You have won!");
    }

    public void init(int pid) {
		this.myId = pid;
		this.myfield = new Field();
		System.out.print("I have index "+pid);
	}
}
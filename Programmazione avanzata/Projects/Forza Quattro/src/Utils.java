import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class Utils{
		
	public static void printField(Field field ) {
		printField( System.out, field.getView() , field.getHeigth(), field.getLength() );
	}

	public static void printField(PrintStream writer ,  Field field ) {
		printField( writer, field.getView() , field.getHeigth(), field.getLength() );
	}

	public static void printField(BiFunction<Integer, Integer, CellStatus> view, int size) {
		printField(System.out,view,size);
	}

	public static void printField(PrintStream writer , BiFunction<Integer, Integer, CellStatus> view, int size, int length, int heigth) {
		for( int i=0; i<length ; i++ ) {
			printRowDelimiter(writer,size);
		}
		for (int j=0; j<heigth; j++){
			printRow(writer, view, j, heigth);
		}
		printRowDelimiter(writer,heigth);
	}
	
	private static void printRowDelimiter( PrintStream writer , int heigth ) {
		writer.print("    ");
		for( int i=0 ; i<heigth ; i++ ) {
			writer.print("+---");
		}
		writer.println("+");
	}
	
	private static void printRow(PrintStream writer , BiFunction<Integer, Integer, CellStatus> view, int row , int heigth) {
		writer.print(String.format("%4d", row ));
		for( int i=0 ; i<heigth ; i++ ) {
			writer.print("| "+view.apply(row, i)+" ");
		}
		writer.println("|");
	}
}
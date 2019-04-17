

public class InteractiveMatch {

    public static void main(String[] argv) {
		Player p1 = new Players("");
		Player p2 = new Computer("");
		Match m = new Match(p1, p2);
		m.play();
    }
}
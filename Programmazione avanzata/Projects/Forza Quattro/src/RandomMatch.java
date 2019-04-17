public class RandomMatch {

	public static void main(String[] argv) {
		Player p1 = new Computer("");
		Player p2 = new Computer("");
		Match m = new Match(p1, p2);
		m.play();
	}

}
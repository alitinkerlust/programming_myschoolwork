
/**
 * Name         : Raymond Victorio Handoko
 * Matric. No   : A0187525W
 * PLab Acct.   :
 */
import java.util.Scanner;
import java.util.HashSet;
import java.util.*;

public class Boxes {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int numOperations = sc.nextInt();
		int row = sc.nextInt();
		int col = sc.nextInt();

		HashSet<Cat> cats = new HashSet<>();
		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> cols = new HashSet<>();

		for (int i = 0; i < numOperations; i++) {
			String operation = sc.next();
			int x;
			int y;
			switch (operation) {
			case "SIT":
				x = sc.nextInt();
				y = sc.nextInt();
				cats.add(new Cat(x, y));
				rows.add(x);
				cols.add(y);
				break;
			case "BOX":
				x = sc.nextInt();
				y = sc.nextInt();
				if (cats.contains(new Cat(x, y))) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
				break;
			case "ROW":
				x = sc.nextInt();
				if (rows.contains(x)) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
				break;
			case "COL":
				y = sc.nextInt();
				if (cols.contains(y)) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
				break;
			}
		}

	}

	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}

class Cat {
	int x;
	int y;

	public Cat(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Cat c) {
		// if (!(o instanceof Cat)) {
		// return false;
		// }
		// Cat c = (Cat) o;
		return c.x == this.x && c.y == this.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

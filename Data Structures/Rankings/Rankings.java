
import java.util.*;

public class Ranking {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int numStudents = sc.nextInt();

		Student[] students = new Student[numStudents];
		for (int i = 0; i < numStudents; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			students[i] = new Student(score, name);
		}

		Arrays.sort(students, (Student a, Student b) -> {
			return b.score - a.score; // orders from highest score to lowest score
		});

		students[0].setRank(1);
		for (int i = 1; i < numStudents; i++) {
			if (students[i].getScore() == students[i - 1].getScore()) {
				students[i].setRank(students[i - 1].getRank());
			} else {
				students[i].setRank(i + 1);
			}
		}

		Arrays.sort(students, (Student a, Student b) -> {
			return a.inputOrder - b.inputOrder; // orders from lowest inputorder to highest inputorder
		});

		for (Student s : students) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}

class Student {

	static int numStudents;
	int inputOrder;
	String name;
	int score;
	int rank;

	Student(int score, String name) {
		numStudents++;
		this.score = score;
		this.inputOrder = numStudents;
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public int getScore() {
		return score;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String toString() {
		return name + " " + rank;
	}
}

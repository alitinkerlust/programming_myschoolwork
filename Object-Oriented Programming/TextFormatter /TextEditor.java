import java.util.ArrayList;
import java.util.PriorityQueue;

class TextEditor {
    private ArrayList<TextFormatter> formatter; // List of different formatter types
    // private ArrayList<TextFormatter> outputs = new ArrayList<TextFormatter>();
    private PriorityQueue<TextFormatter> pq = new PriorityQueue<>();

    public TextEditor(ArrayList<TextFormatter> formatter) {
        this.formatter = formatter;
    }

    public void addString(String s) {
        pq.add(formatter.get(0).clone(s));
        pq.add(formatter.get(1).clone(s));
        pq.add(formatter.get(2).clone(s));
    }

    public void printAll() {
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}

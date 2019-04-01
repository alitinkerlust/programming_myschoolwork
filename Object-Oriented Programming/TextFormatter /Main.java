import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // An arraylist of formatters created to store the different types of
        // TextFormatters
        ArrayList<TextFormatter> formatters = new ArrayList<TextFormatter>();
        // Different types of text formatters added to the arraylist
        SnakeFormatter snakeFormatter = new SnakeFormatter("");
        formatters.add(snakeFormatter);
        KebabFormatter kebabFormatter = new KebabFormatter("");
        formatters.add(kebabFormatter);
        PascalFormatter pascalFormatter = new PascalFormatter("");
        formatters.add(pascalFormatter);

        TextEditor textEditor = new TextEditor(formatters);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            textEditor.addString(s);
        }

        textEditor.printAll();
    }

}

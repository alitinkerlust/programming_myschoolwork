class SnakeFormatter implements TextFormatter, Comparable<TextFormatter> {

    private String original;

    public SnakeFormatter(String str) {
        original = str;
    }

    // to ensure when we format, we know which class' format method to follow
    public SnakeFormatter clone(String str) {
        return new SnakeFormatter(str);
    }

    public String format() {
        return original.toLowerCase().replace(" ", "_");
    }

    public int compareTo(TextFormatter anotherFormatter) {
        // generate output of formatted strings
        String anotherOutput = anotherFormatter.format();
        String thisOutput = this.format();
        // Take the ASCII value of each character in the output and sum them up
        int anotherFormatterVal = getValue(anotherOutput);
        int thisFormatterVal = getValue(thisOutput);

        if (thisFormatterVal > anotherFormatterVal) {
            return 1;
        } else if (thisFormatterVal == anotherFormatterVal) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getValue(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }

    public String toString() {
        return this.format();
    }

}

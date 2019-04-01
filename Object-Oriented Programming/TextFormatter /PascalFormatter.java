class PascalFormatter implements TextFormatter, Comparable<TextFormatter> {

    private String original;

    public PascalFormatter(String str) {
        original = str;
    }

    // to ensure when we format, we know which class' format method to follow
    public PascalFormatter clone(String str) {
        return new PascalFormatter(str);
    }

    public String format() {
        original = original.toLowerCase();
        char[] array = original.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                array[i + 1] = Character.toUpperCase(array[i + 1]);
            }
        }
        String formattedString = new String(array);
        StringBuilder formatted = new StringBuilder(formattedString);
        for (int i = 0; i < formatted.length(); i++) {
            if (formatted.charAt(i) == ' ') {
                formatted.deleteCharAt(i);
            }
        }
        return formatted.toString();
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

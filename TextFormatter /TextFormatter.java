interface TextFormatter {
    // Return a formatted string
    public String format();

    // Create a clone of the TextFormatter with another string
    public TextFormatter clone(String s);

    public int getValue(String str);

    public String toString();
}

class Student {
    public String name;
    public double gpa;

    // A parameterized student constructor
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student's name is: " + this.name + " who got score of " + this.gpa;
    }
}

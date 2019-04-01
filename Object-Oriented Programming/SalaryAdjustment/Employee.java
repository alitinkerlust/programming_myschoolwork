class Employee {

    private String firstName;
    private String lastName;
    private double monthlySalary;
    private double annualRaise;
    private SalaryAdjust adjustType;

    Employee(String firstName, String lastName, double monthlySalary, SalaryAdjust adjustType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
        this.adjustType = adjustType;
    }

    public void setSalaryIncrease(double raise) {
        this.annualRaise = this.adjustType.adjust(raise * 100 - 100);
    }

    public String toString() {
        return firstName + " " + lastName + ": salary is " + String.format("%.0f", monthlySalary / 1000)
                + "K, annual raise is " + String.format("%.0f", annualRaise) + "%";
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getAnnualRaise() {
        return annualRaise;
    }
}

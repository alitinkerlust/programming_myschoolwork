class Bank {

    private String name;
    private double annualX; // annual interest rate
    public static Bank[] BANKS;

    Bank(String name, double annualX) {
        this.name = name;
        this.annualX = annualX;
    }

    public double getMonthlyX() {
        return annualX / 12;
    }

    public String getName() {
        return name;
    }

    public static Bank getBankByName(String bankName) {
        int index = 0;
        for (int i = 0; i < BANKS.length; i++) {
            if (BANKS[i].getName().equals(bankName)) {
                index = i;
            }

        }
        return BANKS[index];
    }
}

class SavingsAccount implements Comparable<SavingsAccount> {

   private Employee employee;
   private Bank bank;
   private double balance;

   SavingsAccount(Employee e, Bank b) {
      employee = e;
      bank = b;
   }

   public void compute(int months) {
      double salary = employee.getMonthlySalary();
      for (int i = 0; i < months; i++) {
         this.balance += (salary + (salary + balance) * bank.getMonthlyX());
         if ((i + 1) % 12 == 0) {
            salary *= ((100 + employee.getAnnualRaise()) / 100);
         }
      }
   }

   public int compareTo(SavingsAccount another) {
      return (int) (this.getBalance() - another.getBalance());
   }

   public double getBalance() {
      return balance;
   }

   @Override
   public String toString() {
      return this.employee.toString() + " has balance of " + String.format("%.2f", this.balance);
   }
}

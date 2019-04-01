import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SalaryAdjust adjustment = new Type1Adjustment();

        int months = sc.nextInt();

        PriorityQueue<SavingsAccount> accounts = new PriorityQueue<SavingsAccount>();

        Bank.BANKS = new Bank[4];
        for (int i = 0; i < Bank.BANKS.length; i++) {
            Bank.BANKS[i] = new Bank(sc.next(), sc.nextDouble());
        }

        while (sc.hasNext()) {
            Employee employee = new Employee(sc.next(), sc.next(), sc.nextDouble(), adjustment);
            employee.setSalaryIncrease(sc.nextDouble());
            SavingsAccount account = new SavingsAccount(employee, Bank.getBankByName(sc.next()));
            account.compute(months);
            accounts.add(account);
        }

        while (!accounts.isEmpty()) {
            System.out.println(accounts.poll());
        }

    }
}

import java.util.Scanner;

class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Menu menu = new Menu();
      int counter = 0;
      while (sc.next().equals("add")) {
         String type = sc.next();
         if (type.equals("Combo")) {
            int item1 = sc.nextInt();
            int item2 = sc.nextInt();
            int item3 = sc.nextInt();
            try {
               menu.addCombo(counter, item1, item2, item3);
               counter++;
            } catch (IndexOutOfBoundsException | ClassCastException ex) {
               System.err.println("Error: Invalid combo input" + " " + item1 + " " + item2 + " " + item3);
            }
         } else {
            String desc = sc.next();
            int price = sc.nextInt();
            menu.add(counter, type, desc, price);
            counter++;
         }
      }
      menu.printAll();

      // read order
      System.out.println("--- Order ---");
      while (sc.hasNext()) {
         int orderNo = sc.nextInt();
         System.out.println(menu.getOrderNo(orderNo));
      }

      menu.printTotalPrice();
   }
}

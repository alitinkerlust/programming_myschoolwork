import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {

   Scanner sc = new Scanner(System.in);

   private String type;
   private List<Food> menuList = new ArrayList<>();
   private List<Burger> burgerList = new ArrayList<>();
   private List<Snack> snackList = new ArrayList<>();
   private List<Drink> drinkList = new ArrayList<>();
   private List<Combo> comboList = new ArrayList<>();
   private int totalPrice = 0;

   public void addCombo(int ID, int item1, int item2, int item3) {
      Combo c = new Combo(ID, (Burger) menuList.get(item1), (Snack) menuList.get(item2), (Drink) menuList.get(item3));
      menuList.add(c);
      comboList.add(c);
   }

   public void add(int ID, String type, String desc, int price) {
      if (type.equals("Burger")) {
         Burger f = new Burger(ID, desc, price);
         menuList.add(f);
         burgerList.add(f);
      } else if (type.equals("Snack")) {
         Snack f = new Snack(ID, desc, price);
         menuList.add(f);
         snackList.add(f);
      } else {
         Drink f = new Drink(ID, desc, price);
         menuList.add(f);
         drinkList.add(f);
      }
   }

   public void printAll() {
      for (Burger burgers : burgerList) {
         System.out.println(burgers);
      }
      for (Snack snacks : snackList) {
         System.out.println(snacks);
      }
      for (Drink drinks : drinkList) {
         System.out.println(drinks);
      }
      for (Combo combos : comboList) {
         System.out.println(combos);
      }
   }

   public String getOrderNo(int orderNo) {
      this.totalPrice += menuList.get(orderNo).getPrice();
      return menuList.get(orderNo).toString();
   }

   public void printTotalPrice() {
      System.out.println("Total: " + this.totalPrice);
   }
}

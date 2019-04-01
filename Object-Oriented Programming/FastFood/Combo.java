class Combo extends Food {

   private Food[] combo = new Food[3];

   Combo(int ID, Food burger, Food snack, Food drink) {
      super(ID, "Combo", burger.getPrice() + snack.getPrice() + drink.getPrice() - 50);
      combo[0] = burger;
      combo[1] = snack;
      combo[2] = drink;
   }

   @Override
   public String toString() {
      return "#" + this.getID() + " Combo " + "(" + this.getPrice() + ")" + "\n" + "   " + combo[0] + "\n" + "   "
            + combo[1] + "\n" + "   " + combo[2];
   }

   @Override
   public int getPrice() {
      return combo[0].getPrice() + combo[1].getPrice() + combo[2].getPrice() - 50;
   }
}

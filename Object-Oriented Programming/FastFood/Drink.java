class Drink extends Food{

   Drink(int ID, String desc, int price){
      super(ID,desc,price);
   }

   @Override
   public String toString(){
      return "#" + this.getID() + " Drink: " + this.getDesc() + " (" + this.getPrice() + ")";
   }
}

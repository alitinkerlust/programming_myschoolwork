class Burger extends Food{

   Burger(int ID, String desc, int price){
      super(ID, desc, price);
   }

   @Override
   public String toString(){
      return "#" + this.getID() + " Burger: " + this.getDesc() + " (" + this.getPrice() + ")";
   }
}


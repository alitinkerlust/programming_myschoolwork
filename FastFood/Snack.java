class Snack extends Food{

   Snack(int ID, String desc, int price){
      super(ID, desc, price);
   }

   @Override
   public String  toString(){
      return "#" + this.getID() + " Snack: " + this.getDesc() + " (" + this.getPrice() + ")";
   }
}

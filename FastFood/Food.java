class Food{
   
   private int ID;
   private String desc;
   private int price;
  
   Food(int ID, String desc, int price){
      this.ID = ID;
      this.desc = desc;
      this.price = price;
   }

   public String getDesc(){
      return desc;
   }

   public int getPrice(){
      return price;
   }

   public int getID(){
      return ID;
   }

  public void setID(int newID){
     this.ID = newID;
  }

}

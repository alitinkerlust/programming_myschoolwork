class Circle{

   private double radius = 1;
   private Point center;

   public Circle(Point center){
      this.center = center;
      radius = 1;
   }

   public static Point getCircleCenter(Point p, Point q){
      Point m = p.getMidPoint(q);
      double distancePQ = p.getDistance(q);
      double theta = p.angleTo(q) + Math.PI / 2;
      double d = Math.sqrt(1 - (distancePQ / 2) * (distancePQ/2));
      return m.moveWithAngleAndDistance(theta , d);
   }


}




class Point{

    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

//returns a string representation of each point
    @Override
    public String toString(){
        return ( "(" + String.format("%.3f", this.x ) + ", " + 
            String.format("%.3f", this.y) + ")" );
    }
//returns midpoint, m, of current point and another point
    public Point getMidPoint(Point another){
        return new Point(this.midPointX(another),this.midPointY(another));
    }
//returns the x-coordinate of MidPoint between a point p and another point,q
    public double midPointX(Point another){
    	double xMid = (this.x + another.x)/2;
    	return xMid;
    }

//returns the y-coordinate of MidPoint between a point p and another point, q
    public double midPointY(Point another){
    	 double yMid = (this.y + another.y)/2;
    	 return yMid;
    }

//returns the angle of line PQ in radians
   public double angleTo(Point another){
      return Math.atan2(another.y-this.y,another.x-this.x);
    }

//returns the distance between two points
    public double getDistance(Point another){
      double diffX = this.x-another.x;
      double diffY = this.y-another.y;

      return Math.sqrt(diffX*diffX+diffY*diffY);
    }


    public Point moveWithAngleAndDistance(double theta, double d){

      double xCenter = this.x + d * Math.cos(theta);
      double yCenter = this.y + d * Math.sin(theta);

       return new Point(xCenter,yCenter);
   }
}




  




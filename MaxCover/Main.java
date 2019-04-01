//A disc that covers the maximum number of points must pass through at least two points.

//For every pair of points that is of no more than distance 2 away from each other, 
//there is at most two unit discs that have their perimeter passing through the two points.


import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int numCoords = sc.nextInt();

        Point points[] = new Point[numCoords];

//for loop to type in coords of points
        for(int j = 0; j<numCoords; j++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[j] = new Point(x,y);
        }
       
        int maxCoverage = 0;

        for(int k = 0; k<numCoords-1; k++){
            for(int l = k+1; l<numCoords; l++){
                Point p = points[k];
                Point q = points[l];

                double distancePQ = p.getDistance(q);
                if(distancePQ<=2){
                    int numCovered = 0;
                    for(int i = 0; i<numCoords; i++){
                        if(points[i].getDistance(Circle.getCircleCenter(p,q))<=1){
                        numCovered++;
                        }
                    }
                    maxCoverage = Math.max(maxCoverage,numCovered);
                    /*numCovered = 0;
                    for(int i = 0; i<numCoords; i++){
                        if(points[i].getDistance(Circle.getCircleCenter(q,p))<1){
                         numCovered++;
                        }
                    }
                    maxCoverage = Math.max(maxCoverage,numCovered);
                    */
                }
            }
          
        }

     System.out.println("Maximum Disc Coverage: " + maxCoverage); 
    }
}

            

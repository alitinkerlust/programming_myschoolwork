import java.util.Scanner;

//Main class that reads the Rubik's cube as input, 
//followed by the turns and output the final Rubik's cube after all the turns have been made.
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] rubik = new int[6][3][3];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    rubik[i][j][k] = sc.nextInt();
                }
            }
        }

        Rubik myRubik = new Rubik(rubik);

        // turning the faces clockwise (F/R/U/L/B/D), anti-clockwise (F'/R'/U'/L'/B'/D')
        // or half-turn (F2/R2/U2/L2/B2/D2)
        while (sc.hasNext()) {
            String input = sc.next();
            switch (input) {
            case "F":
                myRubik = myRubik.frontfaceRight();
                break;
            case "R":
                myRubik = myRubik.rightfaceRight();
                break;
            case "U":
                myRubik = myRubik.upfaceRight();
                break;
            case "L":
                myRubik = myRubik.leftfaceRight();
                break;
            case "B":
                myRubik = myRubik.backfaceRight();
                break;
            case "D":
                myRubik = myRubik.downfaceRight();
                break;
            case "F\'":
                myRubik = myRubik.frontfaceLeft();
                break;
            case "R\'":
                myRubik = myRubik.rightfaceLeft();
                break;
            case "U\'":
                myRubik = myRubik.upfaceLeft();
                break;
            case "L\'":
                myRubik = myRubik.leftfaceLeft();
                break;
            case "B\'":
                myRubik = myRubik.backfaceLeft();
                break;
            case "D\'":
                myRubik = myRubik.downfaceLeft();
                break;
            case "F2":
                myRubik = myRubik.frontfaceHalf();
                break;
            case "R2":
                myRubik = myRubik.rightfaceHalf();
                break;
            case "U2":
                myRubik = myRubik.upfaceHalf();
                break;
            case "L2":
                myRubik = myRubik.leftfaceHalf();
                break;
            case "B2":
                myRubik = myRubik.backfaceHalf();
                break;
            case "D2":
                myRubik = myRubik.downfaceHalf();
                break;
            }
        }
        System.out.println(myRubik);
    }
}
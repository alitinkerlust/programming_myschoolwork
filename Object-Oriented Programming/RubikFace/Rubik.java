class Rubik {

   private int[][][] grid;
   private Face top;
   private Face left;
   private Face front;
   private Face right;
   private Face down;
   private Face back;

   Rubik(int[][][] grid) {
      this.grid = grid;
      this.top = new Face(grid[0]);
      this.left = new Face(grid[1]);
      this.front = new Face(grid[2]);
      this.right = new Face(grid[3]);
      this.down = new Face(grid[4]);
      this.back = new Face(grid[5]);
   }

   Rubik viewRight() {
      int[][][] rotatedRubik = new int[6][3][3];
      rotatedRubik[0] = this.top.rotateRight().getGrid();
      rotatedRubik[1] = this.front.getGrid();
      rotatedRubik[2] = this.right.getGrid();
      rotatedRubik[3] = this.back.rotateHalf().getGrid();
      rotatedRubik[4] = this.down.rotateLeft().getGrid();
      rotatedRubik[5] = this.left.rotateHalf().getGrid();
      Rubik newRubik = new Rubik(rotatedRubik);
      return newRubik;
   }

   Rubik viewLeft() {
      return this.viewRight().viewRight().viewRight();
   }

   Rubik viewUp() {
      int[][][] rotatedRubik = new int[6][3][3];
      rotatedRubik[0] = this.back.getGrid();
      rotatedRubik[1] = this.left.rotateRight().getGrid();
      rotatedRubik[2] = this.top.getGrid();
      rotatedRubik[3] = this.right.rotateLeft().getGrid();
      rotatedRubik[4] = this.front.getGrid();
      rotatedRubik[5] = this.down.getGrid();
      Rubik newRubik = new Rubik(rotatedRubik);
      return newRubik;
   }

   Rubik viewDown() {
      return this.viewUp().viewUp().viewUp();
   }

   // ---change front face---//
   Rubik frontfaceRight() { // turns the front face clockwise and returns the new Rubik object
      int[][][] rotatedRubik = new int[6][3][3];
      int[][] frontFace = new int[3][3];
      frontFace = this.front.rotateRight().getGrid();

      // copy all the elements in the rubix cube to rotatedRubik

      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
               rotatedRubik[i][j][k] = grid[i][j][k];
            }
         }
      }

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            rotatedRubik[2][i][j] = frontFace[i][j];
         }
      }
      // rotatedRubik[2] = this.front.rotateRight().getGrid();
      // this.front = new Face(rotatedRubik[2]);

      int[] temp1 = new int[3];
      for (int j = 0; j < 3; j++) { // store leftmost column of right face
         temp1[j] = rotatedRubik[3][j][0];
      }

      // shift bottomost row of top face to leftmost column right face
      for (int i = 0; i < 3; i++) {
         rotatedRubik[3][i][0] = rotatedRubik[0][2][i];
      }

      // store topmost row of down face
      int[] temp2 = new int[3];
      for (int i = 0; i < 3; i++) {
         temp2[i] = rotatedRubik[4][0][i];
      }

      // shift leftmost column of right face to topmost row of down face
      for (int i = 0; i < 3; i++) {
         rotatedRubik[4][0][2 - i] = temp1[i];
      }

      // store rightmost column of left face
      for (int i = 0; i < 3; i++) {
         temp1[i] = rotatedRubik[1][i][2];
      }

      // shift topmost row of down face to rightmost column of left face
      for (int i = 0; i < 3; i++) {
         rotatedRubik[1][i][2] = temp2[i];
      }

      // shift rightmost column of left face to bottomost row of top face
      for (int i = 0; i < 3; i++) {
         rotatedRubik[0][2][2 - i] = temp1[i];
      }
      return new Rubik(rotatedRubik);
   }

   Rubik frontfaceLeft() {
      return this.frontfaceRight().frontfaceRight().frontfaceRight();
   }

   Rubik frontfaceHalf() {
      return this.frontfaceRight().frontfaceRight();
   }
   // ---------------------//

   // ---change right face---//
   Rubik rightfaceRight() {
      return this.viewRight().frontfaceRight().viewLeft();
   }

   Rubik rightfaceLeft() {
      return this.viewRight().frontfaceLeft().viewLeft();
   }

   Rubik rightfaceHalf() {
      return this.viewRight().frontfaceHalf().viewLeft();
   }
   // ----------------------//

   // ---change left face---//
   Rubik leftfaceRight() {
      return this.viewLeft().frontfaceRight().viewRight();
   }

   Rubik leftfaceLeft() {
      return this.viewLeft().frontfaceLeft().viewRight();
   }

   Rubik leftfaceHalf() {
      return this.viewLeft().frontfaceHalf().viewRight();
   }
   // ---------------------//

   // ---change up face---//
   Rubik upfaceRight() {
      return this.viewUp().frontfaceRight().viewDown();
   }

   Rubik upfaceLeft() {
      return this.viewUp().frontfaceLeft().viewDown();
   }

   Rubik upfaceHalf() {
      return this.viewUp().frontfaceHalf().viewDown();
   }
   // --------------------//

   // ---change down face---//
   Rubik downfaceRight() {
      return this.viewDown().frontfaceRight().viewUp();
   }

   Rubik downfaceLeft() {
      return this.viewDown().frontfaceLeft().viewUp();
   }

   Rubik downfaceHalf() {
      return this.viewDown().frontfaceHalf().viewUp();
   }
   // ---------------------//

   // ---change back face---//
   Rubik backfaceRight() {
      return this.viewRight().viewRight().frontfaceRight().viewLeft().viewLeft();
   }

   Rubik backfaceLeft() {
      return this.viewRight().viewRight().frontfaceLeft().viewLeft().viewLeft();
   }

   Rubik backfaceHalf() {
      return this.viewRight().viewRight().frontfaceHalf().viewLeft().viewLeft();
   }
   // ---------------------//

   public String toString() {
      String dots = "......";
      String s = "";

      for (int i = 0; i < 3; i++) { // print top face
         s += (dots + top.getRow(i) + dots);
         s += "\n";
      }

      for (int i = 0; i < 3; i++) { // print left, front and right faces
         s += left.getRow(i) + front.getRow(i) + right.getRow(i);
         s += "\n";
      }

      for (int i = 0; i < 3; i++) { // print down faces
         s += (dots + down.getRow(i) + dots);
         s += "\n";
      }

      for (int i = 0; i < 3; i++) { // print bacl faces
         s += (dots + back.getRow(i) + dots);
         // if(i!=2){
         s += "\n";
         // }
      }
      return s;
   }
}

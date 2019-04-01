class Face {

    private int[][] grid = new int[3][3];

    Face(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public Face rotateRight() {
        int[][] rotatedFace = new int[3][3];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                rotatedFace[col][grid.length - 1 - row] = grid[row][col];
            }
        }
        Face newFace = new Face(rotatedFace);
        return newFace;
    }

    public Face rotateLeft() {// rotate right 3 times
        return this.rotateRight().rotateRight().rotateRight();
    }

    public Face rotateHalf() {// rotate right 2 times
        return this.rotateRight().rotateRight();
    }

    public int[][] getGrid() {
        int[][] newGrid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newGrid[i][j] = this.grid[i][j];
            }
        }
        return newGrid;
    }

    public String toString() {
        String s = "";
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                s += String.format("%02d", this.getGrid()[row][col]);
            }
            s += "\n";
        }
        return s;
    }

    public String getRow(int i) {
        String s = "";
        for (int col = 0; col < 3; col++) {
            s += String.format("%02d", this.getGrid()[i][col]);
        }
        return s;
    }
}

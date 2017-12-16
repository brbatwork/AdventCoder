public class DukeDay3 {

    public static void main(String[] args) {
        int size = 8;
        int[][] sm = DukeDay3.buildMatrix(size);
//        int needleX = 0;
//        int needleY = 0;
//        int oneX = 0;
//        int oneY = 0;
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (sm[i][j] == 289326) {
//                    needleX = i;
//                    needleY = j;
//                }
//                if (sm[i][j] == 1) {
//                    oneX = i;
//                    oneY = j;
//                }
//            }
//        }
//
//        int result = (Math.abs(needleX - oneX) + Math.abs(needleY - oneY));
//        System.out.println(result);
    }

    public static int[][] buildMatrix(int n) {
        int[][] spiral = new int[n][n];

        int value = n * n;

        int minCol = 0;

        int maxCol = n-1;

        int minRow = 0;

        int maxRow = n-1;

        while (value > 0)
        {
            for (int i = minRow; i <= maxRow; i++)
            {
                spiral[i][minCol] = DukeDay3.calcNeighbors(spiral, i, minCol);
                value--;
            }

            for (int i = minCol+1; i <= maxCol; i++)
            {
                spiral[maxRow][i] = DukeDay3.calcNeighbors(spiral, maxRow, i);
                value--;
            }

            for (int i = maxRow-1; i >= minRow; i--)
            {
                spiral[i][maxCol] = DukeDay3.calcNeighbors(spiral, i, maxCol);
                value--;
            }

            for (int i = maxCol-1; i >= minCol+1; i--)
            {
                spiral[minRow][i] = DukeDay3.calcNeighbors(spiral, minRow, i);
                value--;
            }

            minCol++;

            minRow++;

            maxCol--;

            maxRow--;
        }

        return spiral;
    }

    public static int calcNeighbors(int[][] spiral, int x, int y) {
        int total = 0;

        total += DukeDay3.getValueAt(spiral, x - 1, y); // left
        total += DukeDay3.getValueAt(spiral, x + 1, y); // right
        total += DukeDay3.getValueAt(spiral, x, y + 1); // up
        total += DukeDay3.getValueAt(spiral, x, y - 1); //down
        total += DukeDay3.getValueAt(spiral, x - 1, y - 1); // lower left
        total += DukeDay3.getValueAt(spiral, x + 1, y - 1); // lower right
        total += DukeDay3.getValueAt(spiral, x + 1, y + 1); // upper right
        total += DukeDay3.getValueAt(spiral, x - 1, y + 1); // upper left

        if (total == 0) total++;
        System.out.println(total + " for positon " + x + ":" + y);
        return total;
    }

    public static int getValueAt(int[][] spiral, int x, int y)  {
        try {
            return spiral[x][y];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return 0;
        }
    }
}

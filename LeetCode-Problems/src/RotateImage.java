import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage obj = new RotateImage();
        obj.rotate(matrix);
        for (var row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    //           num1 = 6  num2 =
    //{1,2,3}    {7,6,1}    [7,4,1]
    //{4,5,6} -> {4,5,2} -> [8,5,2]
    //{7,8,9}    {9,8,3}    [9,6,3]
    public void rotate(int[][] matrix) {
        for (int y = 0; y < matrix.length / 2; y++) {
            for (int x = y; x < matrix.length - y - 1; x++) {
                Point rotated = new Point(x,y);

                for (int i = 0; i < 3; i++) {
                    rotated.rotateInPlace(matrix.length);
                    int hold = matrix[rotated.y][rotated.x];
                    matrix[rotated.y][rotated.x] = matrix[y][x];
                    matrix[y][x] = hold;
                }
            }
        }
    }

    class Point {
        int x = 0;
        int y = 0;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void rotateInPlace (int length) {
            int rotatedY = x;
            int rotatedX = length - y - 1;

            this.x = rotatedX;
            this.y = rotatedY;
        }
    }
}


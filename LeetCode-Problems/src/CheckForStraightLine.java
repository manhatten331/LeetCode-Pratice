public class CheckForStraightLine {
    public static void main (String[] args) {
        int[][] coordinates = {{0,0},{0,1},{0,-1}};
        // [0,0],[1,0],[2,2] x1 = 1, y1 = 2

        CheckForStraightLine obj = new CheckForStraightLine();

        System.out.println(obj.checkStraightLine(coordinates));
    }

    public double calculateSlope (int[] point1, int[] point2) {
        int x1 = 0;
        int y1 = 0;
        double sentinel = Double.POSITIVE_INFINITY;

        x1 = point2[0] - point1[0]; // 0
        y1 = point2[1] - point1[1]; // 1

        if (x1 == 0) {
            return sentinel;
        }

        return (double)y1 / (double)x1;
    }

    public boolean checkStraightLine(int[][] coordinates) {

        double m = calculateSlope(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++) {
            double m1 = calculateSlope(coordinates[i-1], coordinates[i]);
            //{0,1}              {0,-1}
            if (m != m1) {
                return false;
            }

//            if (m == Double.POSITIVE_INFINITY) {
//                return false;
//            }
        }


        return true;
    }
}

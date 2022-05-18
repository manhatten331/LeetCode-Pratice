import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> mapAns = new HashMap<>();
    public static void main(String[] args) {
//        int n = 3;
//        int n = 4;
//        int n = 5;
        int n = 7;
//        0 1
//        1 2
//        2 3
//        3 4
//        5 5
//        8 6
//        13 7
//        21 8
//        34 9
//        55 10
//

        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(n));
    }

    public int climbStairs(int n) {
        //base case
        if (n <= 3) {
            return n;
        }

        Integer stairs = mapAns.get(n);

        if (stairs != null) {
            return stairs;
        }

        int Pnum = climbStairs(n - 1);
        int P2num = climbStairs(n - 2);

        int sum = Pnum + P2num;

        mapAns.put(n,sum);

        System.out.println(sum);

        return sum;
    }
}

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;

        CountingBits obj = new CountingBits();
        System.out.println(Arrays.toString(obj.countBits(n)));
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = popCount(i);
        }

        return ans;
    }

    public int popCount(int n) {
        int i;
        for (i = 0;n != 0;i++) {
//            n = (n - 1 & n);  Samething as below
            n &= n - 1;
        }
        return i;
    }
}

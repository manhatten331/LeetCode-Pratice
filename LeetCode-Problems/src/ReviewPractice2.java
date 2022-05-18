import java.math.BigInteger;

public class ReviewPractice2 {
    static int[] fibArray;
    static int sumAns = 0;
    public static void main(String[] args) {
        String p = "600851475143";
        BigInteger poker = new BigInteger(p);

        ReviewPractice2 obj = new ReviewPractice2();
//        fibArray = new int[n+1];

//        System.out.println(obj.multiples(n));
//        System.out.println(obj.evenFib(n));
        System.out.println(obj.primeFactor(poker));
    }

    public static int multiples(int n){
        int sum = 0;
        for (int i = 3; i < n + 1; i++) {
//            if (i < 3) {continue;}
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int evenFib(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibArray[n] != 0) return fibArray[n];

        int sum = (evenFib(n-1) + evenFib(n-2));

        fibArray[n] = sum;

        if(sum % 2 == 0) sumAns += sum;
        System.out.println(sumAns + " yessir");

        return sum;
    }

    public static int primeFactor(BigInteger n) {
        int ans = 0;


        return ans;
    }
}


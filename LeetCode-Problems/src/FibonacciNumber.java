public class FibonacciNumber {
    static int[] fibArray;
    public static void main(String[] args) {
        int n = 7;

        fibArray = new int[n + 1];

        FibonacciNumber obj = new FibonacciNumber();
        System.out.println(obj.fib(n));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibArray[n] != 0) return fibArray[n];

       int sum = (fib(n - 1) + fib(n - 2));

        fibArray[n] = sum;

        return sum;
    }
}

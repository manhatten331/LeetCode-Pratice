public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";

        AddBinary obj = new AddBinary();

        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        String ans = "";
        int carry = 0;

        for (int i = 1; i <= a.length() || i <= b.length(); i++) {
            int valueA = 0;
            int valueB = 0;

            if (i <= a.length()) {
                valueA = a.charAt(a.length() - i) - 48;
            }

            if (i <= b.length()) {
                valueB = b.charAt(b.length() - i) - 48;
            }

            int sum = valueA + valueB + carry;


            if(sum == 1) {
                ans = "1" + ans;
                carry = 0;
            } else if (sum == 0) {
                ans = "0" + ans;
                carry = 0;
            } else if (sum == 2) {
                carry = 1;
                ans = "0" + ans;
            } else if (sum == 3){
                carry = 1;
                ans = "1" + ans;
            }
        }
        if (carry == 1) {
            ans = "1" + ans;
        }
        return ans;
    }
}
public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3}; // 123 + 1 -> {1,2,4}
//        int[] digits = {4,3,2,1}; 4321
//        int[] digits = {9};
        int[] digits = {9,9};
//        int[] digits = {1,9,8,9};


        PlusOne obj = new PlusOne();
        System.out.println(obj.plusOne(digits));
    }

    // Base 2 means it's binary. Considering individual digits is unrelated to the base.
    // But what the digits can actually be is related

    //    int[] digits = {1,10,0,0}
    public int[] plusOne(int[] digits) {
        int digit = digits[digits.length - 1] + 1;
        if (digit < 9) {
            digits[digits.length - 1] = digit;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                // change logic below to handle test case: {1,9,8,9} ans: 1990
//                 {9,9}
                if (digits[i] == 9){
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            }
            if (digits[0] == 0) {
                int[] newDigits = new int[digits.length + 1]; // this needs work, (???length may only be increased by 1 at most???)
                newDigits[0] = newDigits[0] + 1;
                return newDigits;
            }
        }
        return digits;
    }
}

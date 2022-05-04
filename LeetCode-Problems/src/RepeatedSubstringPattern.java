public class RepeatedSubstringPattern {
    public static void main(String[] args) {
//        String s = "abab";
//        String s = "aba";
//        String s = "abcabcabcabc";
        String s = "aa";
//        String s = "ccdccd";
        RepeatedSubstringPattern obj = new RepeatedSubstringPattern();

        System.out.println(obj.SubstringPattern(s));
    }

// check if a substring from 0 to i repeated (length / i) times is equal to the string

    public boolean SubstringPattern(String s) {
        for (int i = 1; i < s.length()/2 + 1; i++) {
            if (s.length() % i != 0) {
                continue;
            }

            String pattern = s.substring(0,i);
            String ans = pattern.repeat(s.length()/i);

            if (s.equals(ans)) {
                return true;
            }
        }

        return false;

    }
}

import java.util.HashMap;

public class RomanInteger {
    public static void main(String[] args) {
//        String s = "III";
//        String s = "LVIII";
        String s = "MCMXCIV";

        RomanInteger obj = new RomanInteger();

        System.out.println(obj.romanToInt(s));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanNum = new HashMap();

        romanNum.put('I', 1);
        romanNum.put('V', 5);
        romanNum.put('X', 10);
        romanNum.put('L', 50);
        romanNum.put('C', 100);
        romanNum.put('D', 500);
        romanNum.put('M', 1000);

        int ans = romanNum.get(s.charAt(s.length()-1));

        for (int i = 0; i < s.length() - 1; i++) {

            if (romanNum.get(s.charAt(i)) >= romanNum.get(s.charAt(i+1))) {
                ans += romanNum.get(s.charAt(i));
            } else {
                ans -= romanNum.get(s.charAt(i));
            }

        }

        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

public class FindDifference {
    public static void main(String[] args) {
//        String s = "abcd", t = "baced";
//        String s = "", t = "y";
//        String s = "aa", t = "aaa";
//        String s = "abc", t = "baac";
        String s = "abcd", t = "bcdca";

        FindDifference obj = new FindDifference();
        System.out.println(obj.findTheDifferenceSteve(s, t));
    }
//    Because of the random shuffle, !!!! the position will never matter !!!!

    public char findTheDifference(String s, String t) {
        //You can't put primitives into Java Collections, because of how Java generics <-(Look this up) works
        List<Character> tList = new ArrayList();
        for (int i = 0; i < t.length(); i++) {
            tList.add(t.charAt(i));
        }

//        You need to tell Java that you're passing a Character to the remove method
//        Because the remove method has multiple overloads, one of which takes in T,
//        which you set to Character, and another that takes in an int, the index
//        So Java has to figure out if you're calling the int overload or the T overload...
//        And you're actually passing in a char, which is a primitive type
//        So I suspect Java is preferring to convert the char to an int over boxing it into a Character

        for (int i = 0; i < s.length(); i++) {
            tList.remove((Character)s.charAt(i));
        }

        return tList.get(0); //Placeholder
    }

    public char findTheDifferenceSteve(String s, String t) {
//        var counts = new int[26];
//        counts[t.charAt(s.length()) - 'a'] = 1;
//        for (var i = 0; i < s.length(); ++i) {
//            ++counts[s.charAt(i) - 'a'];
//            ++counts[t.charAt(i) - 'a'];
//        }
//        for (var i = 0; i < counts.length; ++i)
//            if ((counts[i] & 1) == 1)
//                return (char)(i + 'a');
//        return '\0';
        System.out.print((int)('a'));
        var toggles = new boolean[26];
        toggles[t.charAt(s.length()) - 'a'] = true;
        for (var i = 0; i < s.length(); ++i) {
            int sIndex = s.charAt(i) - 'a', tIndex = t.charAt(i) - 'a';
            toggles[sIndex] = !toggles[sIndex];
            toggles[tIndex] = !toggles[tIndex];
        }
        for (var i = 0; i < toggles.length; ++i)
            if (toggles[i]) return (char)(i + 'a');
        return '\0';
    }
}

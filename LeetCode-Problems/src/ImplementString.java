public class ImplementString {
    public static void main(String[] args) {
//         String haystack = "hello", needle = "ll";
//         String haystack = "aaaaa", needle = "bba";
//         String haystack = "cabcd", needle = "cd";
        // String haystack = "ababc", needle = "abc";
        // String haystack = "abcd", needle = "bc";
        // String haystack = "abcdabcdabce", needle = "abcdabce";
        String haystack = "a", needle = "b";
        ImplementString obj = new ImplementString();


        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {

            int charCode = haystack.charAt(i);
            int findNeedle = needle.charAt(j);

            if(charCode == findNeedle) {
                if(needle.length() - 1 == j) {
                    return i - j;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}

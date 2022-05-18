import java.util.*;

public class SmallestStringSwaps {
    public static void main(String[] args) {
       String s = "dcab";
        List<List<Integer>> test = new ArrayList<>();
        test.add(Arrays.asList(0,3));
        test.add(Arrays.asList(1,2));
        test.add(Arrays.asList(0,2));

        SmallestStringSwaps obj = new SmallestStringSwaps();
        System.out.println(obj.smallestStringWithSwaps(s, test));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind union = new UnionFind(s.length());

        for (List<Integer> pair : pairs) {
            union.union(pair.get(0), pair.get(1));
        }

        HashMap<Integer, List<Character>> dict = new HashMap();

        for (int i = 0; i < s.length(); i++) {
           var set = dict.computeIfAbsent(union.find(i), k -> new ArrayList<>());
           set.add(s.charAt(i));
        }

        for (var characters : dict.values()) {
            characters.sort(Collections.reverseOrder());
        }

        char[] lex = new char[s.length()];

        for (int i = 0; i < lex.length; i++) {
            var q = dict.get(union.find(i));
            lex[i] = q.get(q.size() - 1);
            q.remove(q.size() - 1);
        }

        return new String(lex);
    }
}

class UnionFind{
    int[] parents;
    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    public int find(int n){
        if (n == parents[n]) {
            return n;
        }

        return find(parents[n]);
    }
    public void union(int n, int c){
        n = find(n);
        c = find(c);

        if(n == c){
            return;
        }

        parents[c] = n;
    }
}

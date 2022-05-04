import java.util.List;

public class ReviewPractice1 {
    public static void main(String[] args) {
//       ListNode l1 = [2,4,3], l2 = [5,6,4]
//       l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] ans: [8,9,9,9,0,0,0,1]
//       l1 = [9,9,9,9], l2 = [9,9,9]
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = (l1.val + l2.val) > 9;
        ListNode collection = new ListNode((l1.val + l2.val) % 10);
        ListNode ans = collection;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null){
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + (carry ? 1 : 0);
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + (carry ? 1 : 0);
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + (carry ? 1 : 0);
                l1 = l1.next;
                l2 = l2.next;
            }

            carry = sum > 9;
            if(carry) sum -= 10;

            collection.next = new ListNode(sum);
            collection = collection.next;

            //  So the first thing that evaluates there is "new ListNode(sum)",
            //  which returns the reference to the new ListNode instance.
            //  Then the first assignment that runs is "collection.next = thatNewListNodeReference".
            //  Then the final assignment runs
            //  So when everything's said and done, since ListNode is a reference type, both collection
            //  and collection.next point to the same ListNode
            collection = collection.next = new ListNode(sum);
        }

        if(carry) {
            collection.next = new ListNode(1);
        }

        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

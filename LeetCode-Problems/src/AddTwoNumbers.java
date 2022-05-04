import java.util.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
//       ListNode l1 = [2,4,3], l2 = [5,6,4]
//        l1 = [0], l2 = [0] ans: [0]
//        l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] ans: [8,9,9,9,0,0,0,1]
//        l1 = [9,9,9,9], l2 = [9,9,9]
    }

//    A linked list is a data structure with one important property...
//    The linked list doesn't know where all its nodes are at any given time
//    (assuming there are more than 1 element in the list)
//    Instead, each node in the linked list knows where the next node is
//    But it also carries with it the implication that you CAN NOT randomly access elements.
//    You can ONLY access elements in linear time by traversing every node in the list until you hit the one you want
//    So, because you have linked lists, each node in your list knows two things:
//    it knows about its value, and it knows about the next node in the list

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ansList = new ListNode();
        ListNode startList = ansList;

        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

            carry = 0;

            if (sum > 9) {
                sum -= 10;
                carry = 1;
            }

            ansList.next = new ListNode(sum);
            ansList = ansList.next;
        }

        if(carry > 0) {
            ansList.next = new ListNode(carry);
        }

        return startList.next;
    }


    //    ListNode doesn't contain an iterable
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

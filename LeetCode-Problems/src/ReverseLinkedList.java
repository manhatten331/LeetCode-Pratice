import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] headArray = {1, 2, 3, 4};

        ReverseLinkedList obj = new ReverseLinkedList();

        ListNode head = obj.makeListNode(headArray);

        System.out.println(obj.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode num = reverseList(head.next);

        // Each node points to the next node in the list. So you have a previous node pointing to the next node,
        // and then you point the next node back at the previous node
        //  In other words, when you reverse the list, the original first node has to point to null as its next node,
        //  because the original first node becomes the last node when you reverse the list
        ListNode previous = head;
        ListNode next = head.next;
        next.next = previous;

        // the nodes point to each other
        previous.next = null;

        return num;
    }

    public ListNode makeListNode(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode tail = head;

        for (int i = 1; i < array.length; i++) {
            ListNode newTail = new ListNode(array[i]);
            tail.next = newTail;
            tail = newTail;
            //tail = tail.next
        }

        return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
}

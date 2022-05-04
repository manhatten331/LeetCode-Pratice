public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // list1 = [1,2,4], list2 = [1,3,4]
        // list1 = [1,2,4], list2 = [2,3,4]
        // list1 = [1,3], list2 = [-1,2]
        // list1 = [0,1], list2 = [20,21]
        // list1 = [1], list2 = []

//        The in place merge doesn't have to allocate new nodes.
//        It just mutates what's already there (look at Steve's code)

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ansList = new ListNode();
        ListNode realAns = ansList;

        // The first time the loop runs, ansList is the dummy node, and ansList.next is the first real node....
        while(list1 != null || list2 != null) {
            if (list1 == null) {
                ansList.next = new ListNode(list2.val);
                ansList = ansList.next;
                list2 = list2.next;
            } else if (list2 == null) {
                ansList.next = new ListNode(list1.val);
                ansList = ansList.next;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                ansList.next = new ListNode(list1.val);
                ansList = ansList.next;
                list1 = list1.next;
            } else {
                ansList.next = new ListNode(list2.val);
                ansList = ansList.next;
                list2 = list2.next;
            }
        }

        return realAns.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

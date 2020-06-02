public class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode p = new ListNode(0);
        ListNode l1 = new ListNode(2);
        p.next = l1;
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        printListNode(l1);

        ListNode q = new ListNode(0);
        ListNode l2 = new ListNode(5);
        q.next = l2;
        q = q.next;
        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(4);
        printListNode(l2);

        ListNode result = addTwoNumbers(l1, l2);
        printListNode(result);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummy;

        while(p != null || q !=null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void printListNode(ListNode l) {
        while(l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }
}

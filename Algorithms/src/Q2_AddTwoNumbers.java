public class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        // 不能直接使用第一个节点来生成之后的链表，需用一个指针（p，q）
        ListNode p = new ListNode(0);   // 初始化为0
        ListNode l1 = new ListNode(2);
        p.next = l1;                        // 设置为表头
        p = p.next;                         // 指针向后移动
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

    // 链表定义
    public static class ListNode {
        int val;                                // 节点值
        ListNode next;                          // 定义下个节点
        ListNode(int x) {
            val = x;
        }            // 节点构造器
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);    // 用来返回的空节点
        int carry = 0;                          // 需要进位的数
        ListNode p = l1;                        // 空节点，初始化为l1的表头
        ListNode q = l2;                        // 空节点，初始化为l2的表头
        ListNode curr = dummy;                  // 当前节点，初始化为空节点

        while (p != null || q !=null) {
            int x = (p != null) ? p.val : 0;    // 目前l1节点的值，到达末尾为0
            int y = (q != null) ? q.val : 0;    // 目前l2节点的值，到达末尾为0
            int sum = x + y + carry;            // l1和l2目前节点与进位的和
            carry = sum / 10;                   // 计算需进位多少
            curr.next = new ListNode(sum % 10); // 链接当前节点与下个节点，下个节点的值为sum % 10
            curr = curr.next;                   // 移动当前节点至下个节点
            if(p != null) {
                p = p.next;                     // 下个l1节点
            }
            if(q != null) {
                q = q.next;                     // 下个l2节点
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);    // 遍历结束，如果进位仍大于0，则创造新的节点，值为1 例：三位数 -> 四位数
        }

        return dummy.next;                      // 返回结果链表，表头dummy为空
    }

    // print link list
    public static void printListNode(ListNode l) {
        while(l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }
}

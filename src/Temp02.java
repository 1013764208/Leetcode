import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Temp02 {

    public static void main(String[] args) {

        // 实例化ListNode，初始化 val=0，next=null，头结点：(0,null)
        ListNode node = new ListNode();
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);


//        node.print();   // 0-->1-->2-->3-->4--> （带头结点）


        // -----不带头结点---------------------
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(3);
        node1.add(4);
        node1.add(5);
        node1.add(6);
        node1.add(7);


//        System.out.println(isPalindrome(node1));

//        middleNode(node1).print();
//        reverse(node1).print();

        reverseBetween(node1, 3, 5).print();
//        node1.print();  // 1-->2-->3-->4-->

//        reverseList(node1).print();

//        System.out.println(hasCycle(node1));

//        deleteDuplicates(node1).print();


    }


    /**
     * 题目：给你链表的头结点head，请将其按升序排列并返回排序后的链表
     * 思路：归并排序
     */
    public ListNode sortList(ListNode head) {

        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2.找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3.当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);

    }

    // 找到链表中间节点（876. 链表的中间结点）
//    public static ListNode middleNode(ListNode head) {
//        // 若头节点为空，或头节点的下一个为空，则返回head
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    // 合并两个有序链表（21. 合并两个有序链表）
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }


    /**
     * 链表反转
     *
     * @param head
     * @return
     */
//    public static ListNode reverseList(ListNode head) {
//
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode tmp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tmp;
//        }
//        return pre;
//    }

    // 给你一个链表的头节点 head ，判断链表中是否有环
    // 每次访问结束时，标记地址，若重复识别到地址，则有环
//    public static boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//
//        HashMap<Object, Integer> map = new HashMap<>();
//
//        ListNode cur = head;
//        while (cur != null) {
//            map.put(cur,map.getOrDefault(cur,0)+1); // 此时传+1，没写出来
//            if (map.get(cur) != 1) {
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
//    }


    // HashSet：存储无序，不可重复的数据
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (cur.val != next.val) {
                cur = cur.next;
                next = next.next;
            } else {
                next = next.next;
                cur.next = next;
            }
        }
        return head;
    }


    /**
     * 快慢指针：将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较，比较完后再恢复
     * 1. 找到前半部分的链表
     * 2. 反转后半部分链表
     * 3. 判断是否回文
     * 4. 恢复链表，返回结果
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾结点并反转后半部分
        ListNode firstHalfEnd = middleNode(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    // 链表的中间结点（快慢指针）
    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转链表，当前结点next赋临时（当结下赋），再反转，后移动
    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
    public static void reverse(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {


        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        // 1：从虚拟头节点走 left-1 步，到 left 结点前一个位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 2：从 pre 再走 right-left+1 步，到 right 结点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }


        // 3：保留左右结点，截出子链
        ListNode leftNode = pre.next;   // 保存left结点
        ListNode curr = rightNode.next;  // 保存right后继结点


        pre.next = null;  // 切断
        rightNode.next = null; // 切断


        // 4：反转子链
        reverseLinkedList(leftNode);

        // 接链
        pre.next = rightNode;
        leftNode.next = curr;


        return dummyNode.next;

    }
}



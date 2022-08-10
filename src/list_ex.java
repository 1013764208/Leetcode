import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class list_ex {

    public static void main(String[] args) {

        // 实例化ListNode，初始化 val=0，next=null，头结点：(0,null)
        ListNode node = new ListNode(-1);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);


//        node.print();   // -1-->1-->2-->3-->4--> （带头结点）


        // -----不带头结点---------------------
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(3);
        node1.add(4);


        ListNode node2 = new ListNode(1);
        node2.add(3);
        node2.add(5);
        node2.add(6);


        reserve19(node1).print();

//        System.out.println(node1);
//        System.out.println(copy(node1));
//        copy(node1).print();

//        mergeTwoLists(node1, node2).print();

//        System.out.println(isPalindrome(node1));

//        middleNode(node1).print();
//        reverse(node1).print();

//        reverseBetween(node1, 3, 5).print();
//        node1.print();  // 1-->2-->3-->4-->

//        reverseList(node1).print();

//        System.out.println(hasCycle(node1));

//        deleteDuplicates(node1).print();

//        reserve19(node1).print();


    }


//    /**
//     * 题目：给你链表的头结点head，请将其按升序排列并返回排序后的链表
//     * 思路：归并排序
//     */
//    public ListNode sortList(ListNode head) {
//
//        // 1.递归结束条件
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // 2.找到链表中间节点并断开链表 & 递归下探
//        ListNode midNode = middleNode(head);
//        ListNode rightHead = midNode.next;
//        midNode.next = null;
//
//        ListNode left = sortList(head);
//        ListNode right = sortList(rightHead);
//
//        // 3.当前层业务操作（合并有序链表）
//        return mergeTwoLists(left, right);
//
//    }
//
//    //     找到链表中间节点（876. 链表的中间结点）
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
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode sentry = new ListNode(-1);
//        ListNode curr = sentry;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//
//            curr = curr.next;
//        }
//        curr.next = l1 != null ? l1 : l2;
//        return sentry.next;
//    }


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


    @Test
    public void deTest() {
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(2);
        node1.add(3);

        deleteDuplicates(node1).print();

    }

    public ListNode deleteDuplicates(ListNode head) {

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


//    /**
//     * 快慢指针：将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较，比较完后再恢复
//     * 1. 找到前半部分的链表
//     * 2. 反转后半部分链表
//     * 3. 判断是否回文
//     * 4. 恢复链表，返回结果
//     */
//    public static boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//        // 找到前半部分链表的尾结点并反转后半部分
//        ListNode firstHalfEnd = middleNode(head);
//        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
//
//        // 判断是否回文
//        ListNode p1 = head;
//        ListNode p2 = secondHalfStart;
//        boolean result = true;
//        while (result && p2 != null) {
//            if (p1.val != p2.val) {
//                result = false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return result;
//    }

    // 链表的中间结点（快慢指针）
//    public static ListNode middleNode(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

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

    public static ListNode reverse1(ListNode head) {
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

    // 408 2019.41
    public static ListNode reserve19(ListNode head) {

        // 因为反转后破坏其原来结构，故需要克隆链表
        ListNode copy = copy(head);
        ListNode rever = reverseList(copy);
        return mergeEx(head, rever);
    }

    public static ListNode copy(ListNode head) {

        ListNode new_head = new ListNode(-1);

        while (head != null) {
            new_head.add(head.val);
            head = head.next;
        }
        return new_head.next;
    }

    public static ListNode mergeEx(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        int flag = 0;
        while (list1 != null && list2 != null) {
            if (flag % 2 != 0) {
                prev.next = list1;
                list1 = list1.next;

            } else if (flag % 2 == 0) {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
            flag++;
        }

        // 剩下的，直接指向
        prev.next = list1 == null ? list2 : list1;

        return prehead.next;
    }

    // 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 设置哨兵节点，方便容易返回合并后的链表
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 合并后l1和l2最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表
        prev.next = list1 == null ? list2 : list1;

        // next 跳过哨兵节点
        return prehead.next;
    }

    @Test
    public void Ex_2017_Test() {
        ListNode node = new ListNode(-1);
        node.add(21);
        node.add(-15);
        node.add(-15);
        node.add(-15);
        node.add(-7);
        node.add(15);

        Ex_2017(node).print();
    }

    public ListNode Ex_2017(ListNode head) {

        ListNode cur = head;
        ListNode next = head.next;  // 需要提前判断是否删除，故设其
        HashSet<Integer> set = new HashSet<>(Math.abs(head.val));

        while (next != null) {
            // 如果map不包含next其绝对值的值
            if (!set.contains(Math.abs(next.val))) {
                // 添加其值到set中
                set.add(Math.abs(next.val));
                cur = cur.next;
                next = next.next;
            } else {
                // 当前结点next跳指下一个结点
                next = next.next;
                cur.next = next;
            }
            // 不能写在这里，如果next=null，next=next.next 空指针异常
            // 不用担心else没有运行，next，cur 后移，只要不包含，就走if，便会后移
//            cur = cur.next;
//            next = next.next;

            // 为什么不用 cur.next = cur.next.next，代替以上代码？
            // 可实现跳指，但无法判断 cur.next.next 是否为空，
        }
        return head;
    }

    public ListNode temp(ListNode head) {

        ListNode cur = head;
        cur.next = cur.next.next;
        return head;
    }
}




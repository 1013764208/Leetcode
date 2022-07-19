public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public void add(int newdata) {
        ListNode newNode = new ListNode(newdata);
        if (this.next == null) { // 此that为调用该add的node
            this.next = newNode;
        } else {
            this.next.add(newdata);
        }
    }


    public void print() {

        System.out.print(this.val + "-->");
        if (this.next != null) {
            this.next.print();
        }
    }
}
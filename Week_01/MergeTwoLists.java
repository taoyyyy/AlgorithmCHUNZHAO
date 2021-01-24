package list;

//14.23
//https://leetcode-cn.com/problems/merge-two-sorted-lists/ 合并有序链表
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    //哨兵节点+两次遍历链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);//哨兵节点
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

    public static class ListNode {
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
    }
}

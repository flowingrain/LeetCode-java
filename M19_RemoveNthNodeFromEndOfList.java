package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class M19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead=new ListNode(-1);
        prehead.next=head;
        ListNode fast=prehead,slow=prehead;//快慢指针
        int count=0;
        while(count++<=n){
            if(fast!=null)
                fast=fast.next;
            else
                return head;//没有倒数第n个节点
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next= slow.next.next;//删除下一个节点
        return prehead.next;
    }
    public static void main(String[] args){
        M19_RemoveNthNodeFromEndOfList m19=new M19_RemoveNthNodeFromEndOfList();
        //int[] input={1,2,3,4,5,6};
        int[] input={1};
        //ListNode.printList(ListNode.buildListNode(input));
        int n=1;
        ListNode.printList(m19.removeNthFromEnd(ListNode.buildListNode(input),n));
    }
}

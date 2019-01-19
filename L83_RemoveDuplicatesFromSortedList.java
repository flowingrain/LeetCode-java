package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode cur=head;
        //ListNode temp;
        while(cur.next!=null){
            if(cur.val!=cur.next.val)
                cur=cur.next;
            else{
                /*temp=cur.next.next;
                cur.next=temp;*/
                cur.next=cur.next.next;
            }
        }
        return head;
    }
}
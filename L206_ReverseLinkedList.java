package LeetCode;

public class L206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
       if(head==null||head.next==null)
           return head;
       ListNode curr=head.next;
       ListNode newTail=head;
       newTail.next=null;
       while(curr!=null){
           ListNode tmp=curr.next;
           curr.next=newTail;
           newTail=curr;
           curr=tmp;
       }
        return newTail;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4,5};
        ListNode ln=L141_LinkedListCycle.buildList(nums);
        L206_ReverseLinkedList l206=new L206_ReverseLinkedList();
        ListNode ln1=l206.reverseList(ln);
        while(ln1!=null){
            System.out.print(ln1.val+"\t");
            ln1=ln1.next;
        }
    }
}
package LeetCode;

public class L203_RemoveLinkedListElements {
    public ListNode buildList(int[] nums){
        ListNode head;
        ListNode pointer;
        pointer=head=new ListNode(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            pointer.next=new ListNode(nums[i]);
            pointer=pointer.next;
        }
        return head;
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev,cur;
        prev=dummyHead;
        cur=head;
        while(cur!=null)
        {
            if(cur.val==val)
                prev.next=cur.next;
            else
                prev=cur;
            cur=cur.next;
        }
        return dummyHead.next;
    }
    public static void main(String[] args){
        int[] nums={1,2,6,3,4,5,6};
        int n=6;
        L203_RemoveLinkedListElements l203=new L203_RemoveLinkedListElements();
        ListNode head=l203.buildList(nums);
        l203.removeElements(head,n);
        while(head!=null){
            System.out.print(head.val+"\t");
            head=head.next;
        }
    }
}
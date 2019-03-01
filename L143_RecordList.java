package LeetCode;

public class L143_RecordList {
    public void reorderList(ListNode head) {
        /*
        https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps
        Find the middle of the list
        Reverse the half after middle
        Start reorder one by one
         */
        //找中间节点，使用快慢指针
        if(head==null||head.next==null)
            return;
        ListNode fast,slow;
        fast=slow=head;
        while(fast.next!=null&&fast.next.next!=null){//slow.next刚好是后半段的开始。方便翻转之后的连接
            fast=fast.next.next;
            slow=slow.next;
        }

        //翻转后半段链表。
        ListNode curr,head2;
        head2=slow.next;
        curr=head2.next;
        head2.next=null;
        while(curr!=null){
            ListNode tmp=curr.next;
            curr.next=head2;
            head2=curr;
            curr=tmp;
        }//newtail即新的后半段的头部。
        slow.next=null;//拆成两条短链表

        //连接
        ListNode indexFront=head,indexBehand=head2;
        while(indexBehand!=null){
            ListNode temp1=indexFront.next;
            ListNode temp2=indexBehand.next;
            indexFront.next=indexBehand;
            indexBehand.next=temp1;
            indexFront=temp1;
            indexBehand=temp2;
        }
    }
    public static void main(String[] args){
        L143_RecordList l143=new L143_RecordList();
        int[] nums={1,2,3,4,5};
        //int[] nums={1,2,3,4};
        ListNode head=ListNode.buildListNode(nums);
        ListNode.printList(head);
        l143.reorderList(head);
        ListNode.printList(head);
    }
}
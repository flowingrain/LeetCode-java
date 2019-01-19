package LeetCode;

public class L148_SortList {
    public ListNode merge(ListNode l1, ListNode l2) {//合并两个有序列表
        ListNode prehead=new ListNode(-1);
        ListNode pointer=prehead;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                pointer.next=l2;
                pointer=pointer.next;
                l2=l2.next;
            }else{
                pointer.next=l1;
                pointer=pointer.next;
                l1=l1.next;
            }
        }
        if(l1!=null){
            pointer.next=l1;
        }else
            pointer.next=l2;
        return prehead.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
      /*  ListNode prehead=new ListNode(Integer.MIN_VALUE);
        prehead.next=head;*/
        //ListNode preslow=head,slow=head,fast=head;//快慢指针
        //ListNode preslow=prehead,slow=head,fast=head;//快慢指针
        ListNode preslow=null,slow=head,fast=head;//快慢指针
        while(fast!=null&&fast.next!=null){
            //preslow=preslow.next;
            preslow=slow;
            /*if(slow!=head)//需要反复对if里的条件进行判断，效率差
                preslow=preslow.next;*/
            slow=slow.next;
            fast=fast.next.next;
        }
        preslow.next=null;//分为两个链表
        head=sortList(head);//对两个子链表分别合并
        slow=sortList(slow);
        return merge(head,slow);
        //return prehead.next;
    }
    public static void main(String[] args){
    /*    int[] nums1={1,3,5};
        int[] nums2={2,4,6};
        ListNode l1=ListNode.buildListNode(nums1);
        ListNode l2=ListNode.buildListNode(nums2);
        L148_SortList l148=new L148_SortList();
        ListNode.printList(l148.merge(l1,l2));*/
        int[] nums={4,2,1,3};
        ListNode head=ListNode.buildListNode(nums);
        L148_SortList l148=new L148_SortList();
        ListNode.printList(l148.sortList(head));
    }
}
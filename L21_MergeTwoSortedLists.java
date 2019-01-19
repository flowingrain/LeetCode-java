package LeetCode;

public class L21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);//指示当前节点
        ListNode ln=temp;//ln为链表头部，返回的链表头部加入了一个节点。
        while(l1!=null &&l2!=null)
        {
            if(l1.val>l2.val){
                temp.next=l2;
                l2=l2.next;
            }
            else{
                temp.next=l1;
                l1=l1.next;
            }
            temp=temp.next;//注意链表上的移动，
        }
        if(l1!=null){
            temp.next=l1;
        }else
        {
            temp.next=l2;
        }
        return ln.next;
    }
}
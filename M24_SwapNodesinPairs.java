package LeetCode;

public class M24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prehead=new ListNode(-1);
        prehead.next=head;
        ListNode pointer=prehead;
        while(pointer.next!=null&&pointer.next.next!=null)
        {
            ListNode first=pointer.next;//借助两个临时变量
            ListNode second=pointer.next.next;
            pointer.next=second;
            first.next=second.next;
            second.next=first;
            pointer=pointer.next.next;
        }
        return prehead.next;
    }
    public static void main(String[] args){
        M24_SwapNodesinPairs m24=new M24_SwapNodesinPairs();
        int[] input={1,2,3,4};
        ListNode list=ListNode.buildListNode(input);
        ListNode.printList(m24.swapPairs(list));
    }
}
package LeetCode;

public class L147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {//插入排序，而非冒泡排序，对每一个节点，向前查找合适的位置插入。当前节点之前部分有序
        if(head==null)
            return head;
        ListNode prehead=new ListNode(Integer.MIN_VALUE);
        prehead.next=head;//应对节点插入head的情况。
        ListNode cur=head.next;//插入排序从第二个节点开始
        ListNode precur=head;//precur表示cur前面的节点
        ListNode temp;
        while(cur!=null){
            if(precur.val>cur.val){//从前往后找到插入位置。前面的值大，后边的值小，即找到待插入节点
                //此时，只移动cur
                temp=new ListNode(cur.val);//保存需要往前进行插入操作的节点的值。
                cur=cur.next;
                precur.next=cur;//在原位置删除需要进行插入操作的节点
                ListNode pointer=prehead;
                while(temp.val>pointer.next.val)//找到temp.val
                {
                    pointer=pointer.next;
                }
                ListNode temp2=pointer.next;
                pointer.next=temp;
                temp.next=temp2;
            }else{//同时移动cur和precur
                precur=precur.next;
                cur=cur.next;
            }
        }
        return prehead.next;
    }
    public static void main(String[] args){
        int[] nums={-1,5,3,4,0};
        ListNode head=ListNode.buildListNode(nums);
        //ListNode.printList(head);
        L147_InsertionSortList l147=new L147_InsertionSortList();
        l147.insertionSortList(head);
        ListNode.printList(head);
    }
}
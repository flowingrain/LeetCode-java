package LeetCode;

public class L160_IntersectionOfTwoLinkedLists {
    /*把第一个链表的结尾指向第二个链表的开头。
    如果两个链表有交集，则新的链表有环
    环的开始处即两个链表交集的起始节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode temp=headA;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=headB;
        ListNode fast=headA;
        ListNode slow=headA;
        while( fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode slow2=headA;
                while(slow2!=slow){
                    slow=slow.next;
                    slow2=slow2.next;
                }
                temp.next=null;//恢复原链表结构
                return slow2;
            }
        }
        temp.next=null;
        return null;
    }
}
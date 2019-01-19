package LeetCode;

public class L234_PalindromeLinkedList {
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
    public ListNode reverList(ListNode ln){//翻转从ln开始的列表
        if(ln==null||ln.next==null)
            return ln;
        ListNode cur,next,temp;
        cur=ln.next;
        next=ln;
        next.next=null;//初始化翻转后的列表尾部
        while(cur!=null){
            temp=cur.next;
            cur.next=next;
            next=cur;
            cur=temp;
        }
        return next;
    }
    public boolean isPalindrome(ListNode head) {//列表是否回文
        //快慢指针
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;//fast非空的时候slow肯定非空
        }
        ListNode half=reverList(slow);//后半段头结点
        ListNode pointer=head,pointer1=half;//pointer为前半段上的指针，pointer1为后半段上的指针
        while(pointer!=half&&pointer1!=null)//列表长为奇数时，翻转队列较剩余队列长1。比较至剩余队列结束
        {
            if(pointer.val!=pointer1.val)
                return false;
            pointer=pointer.next;
            pointer1=pointer1.next;
        }
        return true;
    }
    public static void main(String[] args){
        int[] nums={1,0,1};
        L234_PalindromeLinkedList l234=new L234_PalindromeLinkedList();
        ListNode ln=l234.buildList(nums);
        System.out.println(l234.isPalindrome(ln));
    }
}
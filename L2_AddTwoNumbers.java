package LeetCode;

public class L2_AddTwoNumbers {
    public ListNode String2List(String num){//链表的头是数字低位
        ListNode ln=new ListNode(-1);
        ListNode pointer=ln;
        for(int i=num.length()-1;i>=0;i--){
            pointer.next=new ListNode(Integer.valueOf(num.charAt(i)-'0'));
            pointer=pointer.next;
        }
        return ln.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0,temp=0;
        ListNode presum=new ListNode(-1);
        ListNode pointer=presum;
        while(l1!=null||l2!=null){
            temp=carry;//carry为上一步的进位
            if(l1!=null) {
                temp += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                temp+=l2.val;
                l2=l2.next;
            }
            carry=temp/10;//当前步产生的进位
            pointer.next=new ListNode(temp%10);
            pointer=pointer.next;
        }
        if(carry!=0)
            pointer.next=new ListNode(carry);
        return presum.next;
    }

    public static void main(String[] args){
        //int num1=342,num2=465;
        String num1="9";
        String num2="9999999991";
        L2_AddTwoNumbers l2=new L2_AddTwoNumbers();
        ListNode ln1=l2.String2List(num1);
        ListNode.printList(ln1);
        ListNode ln2=l2.String2List(num2);
        ListNode.printList(ln2);
        ListNode.printList(l2.addTwoNumbers(ln1,ln2));
    }
}

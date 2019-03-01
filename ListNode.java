package LeetCode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next=null;
    }
    public static ListNode buildListNode(int[] nums){
        boolean ishead=true;
        ListNode head=null,pointer=null;
        for(int i=0;i<nums.length;i++){
            if(ishead){
                head=new ListNode(nums[i]);
                pointer=head;
                ishead=false;
            }else{
                pointer.next=new ListNode(nums[i]);
                pointer=pointer.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head){
        ListNode pointer=head;
        while(pointer!=null&&pointer.next!=null){
            System.out.print(pointer.val+"->");
            pointer=pointer.next;
        }
        System.out.print(pointer.val);
        System.out.println();
    }
}

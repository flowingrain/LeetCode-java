package LeetCode;

public class L141_LinkedListCycle {
    public static ListNode buildList(int[] nums){
        int len=nums.length;
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
    public static ListNode buildCycleList(int[] nums){
        int len=nums.length;
        ListNode head;
        ListNode pointer;
        pointer=head=new ListNode(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            pointer.next=new ListNode(nums[i]);
            pointer=pointer.next;
        }
        int cicleStartNum=(int)(Math.random()*(len-1));
        System.out.println(cicleStartNum);
        ListNode cicleStart=head;
        for(int i=0;i<cicleStartNum;i++){
            cicleStart=cicleStart.next;
        }
        pointer.next=cicleStart;//环
        return head;
    }
    public boolean hasCycle(ListNode head) {
        //快慢指针。简单版本不需要返回循环开始节点
        if(head==null)
            return false;
        ListNode fast=head;
        ListNode slow=head;
        while(true){//fast.next不空则slow.next不空
          if( fast.next==null||fast.next.next==null)
              return false;
          else
          {
              fast=fast.next.next;
              slow=slow.next;
              if(slow==fast)
                  return true;
          }
        }
    }
    public static void main(String[] args){
        L141_LinkedListCycle l141=new L141_LinkedListCycle();
        //int[] nums={-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        int[] nums={-21,10,17,8,4,26,5,35,33,-7};
        ListNode head=l141.buildCycleList(nums);
        ListNode pointer=head;
        while(pointer!=null){
            System.out.print(pointer.val+"\t");
            pointer=pointer.next;
        }
        System.out.println(l141.hasCycle(head));
    }
}

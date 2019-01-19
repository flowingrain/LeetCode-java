package LeetCode;

public class L142_LinkedListCycleII {
    public ListNode buildList(int[] nums,boolean withCircle){
        int len=nums.length;
        ListNode head;
        ListNode pointer;
        pointer=head=new ListNode(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            pointer.next=new ListNode(nums[i]);
            pointer=pointer.next;
        }
        if(withCircle){
            int cicleStartNum=(int)(Math.random()*(len-1));
            ListNode cicleStart=head;
            for(int i=0;i<cicleStartNum;i++){
                cicleStart=cicleStart.next;
            }
            pointer.next=cicleStart;//环
        }
        return head;
    }
    public ListNode detectCycle(ListNode head) {
        /*
        环之前节点数 a
        从环起始节点到快慢指针相遇位置，节点数 b
        快慢指针fast slow相遇，慢指针走过 a+b
                    快指针走过2*(a+b)
        快慢指针相遇时，创建第二个慢指针 slow2
        同上，slow再走过a+b时，slow走过2(a+b)
        slow2走过a+b，二者在快慢指针相遇处相遇。
        slow slow2速度相同，往前回推，二者从环开始处即相遇然后并行
         */
        ListNode fast=head;
        ListNode slow=head;
        while( fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode slow2=head;
                while(slow2!=slow){
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
    public static void main(String[] args){
        L142_LinkedListCycleII l142=new L142_LinkedListCycleII();
        int[] nums={-21,10,17,8,4,26,5,35,33,-7};
        ListNode ln;
        if(Math.random()>0.5)
            ln=l142.buildList(nums,true);
        else
            ln=l142.buildList(nums,false);
        ListNode result=l142.detectCycle(ln);
        if(result!=null)
            System.out.println(result.val);
        else
            System.out.println("没有环");
    }
}
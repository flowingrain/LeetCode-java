package LeetCode;

public class H25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        for (ListNode i = head; i != null;i = i.next)
            count++;
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode prev=dmy,tail=head;
        for(; count >= k; count -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;//保存tail下一个节点的下一个节点
                tail.next.next = prev.next;//tail的下一个节点指向prev的下一个节点。为新的头结点建立与后续节点的连接
                prev.next = tail.next;//tail的下一个节点成为prev的下一个节点，断开与tail的连接
                tail.next = next;//tail指向之前保存的节点。通过这种方式，在该循环中实现tail不断后移，prev保持在原来位置。后续节点依次插入到prev后
            }
            //ListNode.printList(prev.next);
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
    public static void main(String[] args){
        H25_ReverseNodesInKGroup h25=new H25_ReverseNodesInKGroup();
        int[] input={1,2,3,4,5,6,7};
        int k=3;
        ListNode list=ListNode.buildListNode(input);
        ListNode.printList(h25.reverseKGroup(list,k));
    }
}
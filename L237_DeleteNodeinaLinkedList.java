package LeetCode;

public class L237_DeleteNodeinaLinkedList {
    public static ListNode head;
    public void deleteNode(ListNode node) {//难点在于链表的获取？
        node.val=node.next.val;//不是最后一个node的用处。通过将值改为下一个的值，下一个节点改为下下一个节点实现删除，有点意思
        node.next=node.next.next;
    }
    public static void main(String[] args){
        int[] nums={4,5,1,9};
        ListNode pointer=ListNode.buildListNode(nums);
        L237_DeleteNodeinaLinkedList l237=new L237_DeleteNodeinaLinkedList();
        ListNode node=pointer.next;
        l237.deleteNode(node);
        while(pointer!=null){
            System.out.print(pointer.val+"\t");
            pointer=pointer.next;
        }
    }
}
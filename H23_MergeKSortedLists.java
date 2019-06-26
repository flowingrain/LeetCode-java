package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class H23_MergeKSortedLists {
     public ListNode mergeKLists(ListNode[] lists) {//使用优先级队列实现
         if(lists==null||lists.length==0)
             return null;
         PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {//设置优先级队列的大小等于链表数组的长度。后边每次都是先出后进
             @Override
             public int compare(ListNode o1, ListNode o2) {
                 /*if(o1.val>o2.val)
                     return 1;
                 else if(o2.val==o2.val)
                     return 0;
                 else
                     return -1;*/
                 return o1.val-o2.val;//奇了怪，不知道为什么这个可以上边不行
             }
         });
         ListNode prehead=new ListNode(0);
         ListNode pointer=prehead;
        for(ListNode node:lists){//这里只是把链表数组的首节点加入优先级队列
             if(node!=null)
                 pq.add(node);
         }
/*         for(int i=0;i<lists.length;i++){//这里只是把链表数组的首节点加入优先级队列
             if(lists[i]!=null)
                 pq.add(lists[i]);
         }*/
         while(!pq.isEmpty()){
             pointer.next=pq.poll();
             pointer=pointer.next;
             if(pointer.next!=null){
                 pq.add(pointer.next);//当前链表的下一个节点加入优先级队列，并重新排序
             }
         }
         return prehead.next;
     }
    public static void main(String[] args){
        H23_MergeKSortedLists h23=new H23_MergeKSortedLists();
        int[] nums1={1,4,5};
        int[] nums2={1,3,4};
        int[] nums3={2,6};
        ListNode list1=ListNode.buildListNode(nums1);
        ListNode list2=ListNode.buildListNode(nums2);
        ListNode list3=ListNode.buildListNode(nums3);
        ListNode[] lists={list1,list2,list3};
        /*int[] nums1={1};
        int[] nums2={0};
        ListNode list1=ListNode.buildListNode(nums1);
        ListNode list2=ListNode.buildListNode(nums2);
        ListNode[] lists={list1,list2};*/
        ListNode.printList(h23.mergeKLists(lists));
    }
}
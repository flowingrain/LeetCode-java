package LeetCode;

public class L138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        //复制每个节点
        Node index=head;
        while(index!=null){//复制的都是非空节点。
            Node next=index.next;
            index.next=new Node(index.val,next,null);
            index.next.next=next;//插入index节点的复制节点。
            index=next;//跳两步，到原来的下一个节点位置。
        }
        //设置random
        index=head;
        while(index!=null){
            if(index.random!=null)
                index.next.random = index.random.next;
            else
                index.next.random = null;
            index = index.next.next;//跳两步，到原来的下一个节点位置。
        }

        //拆分链表
        index=head;
        Node copyIndex,copyHead;
        copyIndex=copyHead=head.next;
        //while(copyIndex!=null&&copyIndex.next!=null)
        while(copyIndex.next!=null)//index.next.next节点为null时，大括号内第三步右侧null节点没有next，会产生空指针，所以判断条件不能使用index！=null
        {
            index.next=copyIndex.next;
            index=index.next;
            copyIndex.next=index.next;//null节点没有next
            copyIndex=copyIndex.next;
        }
        index.next=null;
        return copyHead;
    }
    public static void main(String[] args){
        L138_CopyListWithRandomPointer l138=new L138_CopyListWithRandomPointer();
       /* Node node1=new Node(1,null,null);
        Node node2=new Node(2,null,null);
        node2.random=node2;
        node1.next=node2;
        node1.random=node2;*/
        //Node node1=new Node(-1,null,null);

        //{"$id":"1","next":{"$id":"2","next":{"$id":"3","next":{"$id":"4","next":null,"random":null,"val":4},"random":null,"val":3},"random":{"$ref":"3"},"val":2},"random":{"$ref":"3"},"val":1}
        Node node1=new Node(1,null,null);
        Node node2=new Node(2,null,null);
        Node node3=new Node(3,null,null);
        Node node4=new Node(4,null,null);
        node1.next=node2;
        node1.random=node3;
        node2.next=node3;
        node2.random=node3;
        node3.next=node4;
        node3.random=null;
        node4.next=null;
        node4.random=null;

        Node index=node1;
        while(index!=null)
        {
            System.out.println(index+"\t"+ index.next+"\t"+index.random);
            index=index.next;
        }
        System.out.println();

        index=l138.copyRandomList(node1);
        while(index!=null)
        {
            System.out.println(index+"\t"+ index.next+"\t"+index.random);
            index=index.next;
        }
        System.out.println();

        index=node1;
        while(index!=null)
        {
            System.out.println(index+"\t"+ index.next+"\t"+index.random);
            index=index.next;
        }
        System.out.println();
    }
}

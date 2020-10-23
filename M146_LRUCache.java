import java.util.HashMap;

public class M146_LRUCache {
    private static class DLinkedNode{//双端链表，可以快速抽取元素
        int key;
        int value;
        DLinkedNode pre;//指向前一个节点
        DLinkedNode next;//指向后一个节点
    }

    private HashMap<Integer,DLinkedNode>
        cache=new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;//容量
    private DLinkedNode head,tail;//加入首尾指针

    public M146_LRUCache(int capacity) {
        this.count=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        head.pre=null;
        tail=new DLinkedNode();
        tail.next=null;

        head.next=tail;
        tail.pre=head;
    }

    private void printcache(){
        DLinkedNode index=head.next;
        while(index.next!=null){
            System.out.print(index.value+"->");
            index=index.next;
        }
        System.out.println();
    }

    private void move2head(DLinkedNode node){
        //摘出来
        node.pre.next=node.next;
        node.next.pre=node.pre;
        //添加到头。head节点只是用来占位置的，其值无实际意义。放置到头结点不取代head
        node.pre=head;
        node.next=head.next;

        head.next.pre=node;//后一个节点的前向链接
        head.next=node;//head节点的后向链接
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if(node==null)
            return -1;//cache里没有
        //cache命中，挪到开头
        move2head(node);
        //System.out.println(node.value);
        return node.value;
    }

    private void addnode(DLinkedNode node){//新创建一个节点并添加到头节点位置。本身不在链表中，所以不需要像move2head一样先断开。
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;//后一个节点的前向链接
        head.next=node;//head节点的后向链接
    }

    private DLinkedNode removelast(){
        DLinkedNode last=tail.pre;
        last.pre.next=last.next;
        last.next.pre=last.pre;
        count--;
        return last;
    }

    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);//hash表有直接指向节点地址的链接，实现o(1)操作。
        if(node==null)
        {
         //创建新节点并挪到头节点位置。
         DLinkedNode newnode=new DLinkedNode();
         newnode.key=key;
         newnode.value=value;
         cache.put(key,newnode);//加入cache
         addnode(newnode);//放在链表头部
         ++count;//cache中元素计数。
         if(count>capacity){//淘汰最尾节点，不是tail节点，而是tail节点的前一个节点。
            DLinkedNode res=removelast();//被移除的节点
            cache.remove(res.key);//cache中对应移除
         }
        }
        else{
         //cache命中，更新cache
         node.value=value;
         move2head(node);//之前的忘了挪到头部了
        }
    }

    public static void main(String[] args){
        M146_LRUCache cache = new M146_LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.printcache();
        cache.put(2, 2);
        cache.printcache();
        cache.get(1);       // returns 1
        cache.printcache();
        cache.put(3, 3);    // evicts key 2
        cache.printcache();
        cache.get(2);       // returns -1 (not found)
        cache.printcache();
        cache.put(4, 4);    // evicts key 1
        cache.printcache();
        cache.get(1);       // returns -1 (not found)
        cache.printcache();
        cache.get(3);       // returns 3
        cache.printcache();
        cache.get(4);       // returns 4
        cache.printcache();
    }
}

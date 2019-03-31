package LeetCode;

import java.util.*;

public class L310_MinumumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2)
            return Collections.singletonList(0);//创建单个元素的List，最简单的方法，可以在其中创建不可变List的单个元素。也可以使用Arrays.asList创建，但创建的列表不是不可变的
        List<Set<Integer>> nodeEdges=new ArrayList<>(n);//每个节点的连接的有哪些节点。
        for(int i=0;i<n;i++)
            nodeEdges.add(new HashSet<Integer>());//创建节点连接集合
        for(int i=0;i<edges.length;i++){
            nodeEdges.get(edges[i][0]).add(edges[i][1]);//记录与节点连接的节点
            nodeEdges.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves=new ArrayList<Integer>();
        for(int i=0;i<n;i++){//获取初始叶子节点集合。
            if (nodeEdges.get(i).size()==1)
                leaves.add(i);
        }
        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            for(int i:leaves){
                int j=nodeEdges.get(i).iterator().next();//获取连接到叶子的节点。
                nodeEdges.get(j).remove(i);//移除对应节点的连接记录。
                if(nodeEdges.get(j).size()==1)
                    newLeaves.add(j);//下一轮循环中成为叶子节点
            }
            leaves=newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args){
        L310_MinumumHeightTrees l310=new L310_MinumumHeightTrees();
        int n=4;
        int[][] edges={{1,0}, {1, 2},{1,3}};
        System.out.println(l310.findMinHeightTrees(n,edges));
    }
}
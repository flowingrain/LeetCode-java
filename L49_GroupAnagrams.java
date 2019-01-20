package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new LinkedList<List<String>>();
        HashMap<String,Integer> hm=new HashMap<String,Integer>();//前边为字符串，后边为字符串对应list的序号
        int listsnum=0;//list数目
        for(int i=0;i<strs.length;i++){
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String str=String.valueOf(temp);
            if(!hm.containsKey(str))//temp.toString不是temp里的字符组成字符串
            {
                hm.put(str,listsnum);
                List<String> list=new LinkedList<String>();
                list.add(strs[i]);
                res.add(list);
                listsnum++;
            }else{
                res.get(hm.get(str)).add(strs[i]);//找到对应的String list，往里添加string
            }
        }
        //System.out.println(hm);
        return res;
    }
    public static void main(String[] args){
        L49_GroupAnagrams l49=new L49_GroupAnagrams();
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(l49.groupAnagrams(strs));
    }
}
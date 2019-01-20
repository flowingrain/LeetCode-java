package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L249_GroupShiftedStrings {
    public String getBase(String str){//将平移字符串的base定为首字母为a的字符串
        int distance=str.charAt(0)-'a';//平移的距离
        StringBuilder sb=new StringBuilder();
        sb.append('a');
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)-'a'<distance)
                sb.append((char)(str.charAt(i)+26-distance));
            else
                sb.append((char) (str.charAt(i)-distance));
        }
        return sb.toString();
    }
    public List<List<String>> groupStrings(String[] strs) {
        List<List<String>> res=new LinkedList<List<String>>();
        HashMap<String,Integer> hm=new HashMap<String,Integer>();//前边为字符串，后边为字符串对应list的序号
        int listsnum=0;//list数目
        for(int i=0;i<strs.length;i++){
            String str=getBase(strs[i]);
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
        return res;
    }
    public static void main(String[] args){
        L249_GroupShiftedStrings l249=new L249_GroupShiftedStrings();
        //System.out.println(l249.getBase("cde"));
        String[] strs={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(l249.groupStrings(strs));
    }
}
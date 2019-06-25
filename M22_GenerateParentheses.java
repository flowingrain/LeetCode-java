package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class M22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<String>();
        backtrack(ans,"",0,0,n);
        //System.out.println(ans);
        return ans;
    }
    public void backtrack(List<String> list,String str,int left,int right,int max){
        if(str.length()==max*2)
        {
            list.add(str);
            return;
        }
        if(left<max){
            backtrack(list,str+"(",left+1,right,max);//不知为何，++和+1效果差很多
        }
        if(right<left){
            backtrack(list,str+")",left,right+1,max);
        }
    }
    public static void main(String[] args){
        M22_GenerateParentheses m22=new M22_GenerateParentheses();
        int n=3;
        System.out.println(m22.generateParenthesis(n));
    }
}
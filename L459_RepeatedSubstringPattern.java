package LeetCode;

public class L459_RepeatedSubstringPattern {
    private boolean canDividedIntoSameSlices(String s,int n){//是否可以分为n个相同串
        int subLen=s.length()/n;
        String pattern=s.substring(0,subLen);
        int index=subLen;
        while(index<s.length()){
            if(s.substring(index,index+subLen).equals(pattern)){//index从第二个子串的左侧开始，每次增加subLen
                index+=subLen;
            }
            else
                break;
        }
        if(index>=s.length())
            return true;
        return false;
    }
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<2)
            return false;
        for(int i=2;i<=s.length();i++){
            //System.out.println(i);
            if(s.length()%i==0){//可能是有i段模式串匹配而成
                if(canDividedIntoSameSlices(s,i))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        L459_RepeatedSubstringPattern l459=new L459_RepeatedSubstringPattern();
        //String s="abab";
        //String s="bb";
        //String s="ababab";
        String s="abac";
        System.out.println(l459.repeatedSubstringPattern(s));
    }
}

package LeetCode;

public class L214_ShortestPalindrome {
    /*public String shortestPalindrome(String s) {
        if(s.length()<=1)
            return s;
        int max=0;//从头开始的最长对称子串最右侧下标
        for(int i=0;i<s.length();i++)//i作为对称串的右边界的下标
        {
            //System.out.println(i+":");
            int axis=i/2;//对称轴
            int j;
            if(i%2==0) {//到i的子串长度为奇数。对称中心为i/2
                for(j=1;j<=axis;j++)
                {
                    //System.out.println("\t"+j);
                    if(s.charAt(axis-j)==s.charAt(axis+j))//判断对称轴两侧值是否相等
                        continue;
                    else
                        break;
                }
                if(j>axis)
                    max=i;
            }
            else{//到i的子串长度为偶数。对称中心为i/2，i/2+1
                for(j=0;j<=axis;j++)
                {
                    //System.out.println("\t"+j);
                    if(s.charAt(axis-j)==s.charAt(axis+1+j))
                        continue;
                    else
                        break;
                }
                if(j>axis)
                    max=i;
            }

        }
        //System.out.println(max);
        StringBuilder sb=new StringBuilder();
        return sb.append(s).reverse().append(s.substring(max+1)).toString();
    }
    */

    public String shortestPalindrome(String s) {
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==s.charAt(j))
                j++;
        }
        if(j==s.length())//整个字符串对称
            return s;
        return new StringBuilder().append(s.substring(j)).reverse().toString()+shortestPalindrome(s.substring(0,j))+s.substring(j);
    }
    public static void main(String[] args){
        L214_ShortestPalindrome l214=new L214_ShortestPalindrome();
        //String s="aacecaaa";
        //String s="abcd";
        String s="abbacd";
        //Input
        //"abbacd"
        //Output
        //"dcabbabbacd"
        //Expected
        //"dcabbacd"
        String result=l214.shortestPalindrome(s);
        System.out.println(result);
    }
}
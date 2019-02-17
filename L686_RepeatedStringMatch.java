package LeetCode;

public class L686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb=new StringBuilder();
        int count=(int)Math.ceil((float)B.length()/A.length());
        //System.out.println(count);
        for(int i=0;i<count;i++)
            sb.append(A);
        if(sb.toString().contains(B))
            return count;
        if(sb.append(A).toString().contains(B))
            return ++count;
        return -1;
    }
    public static void main(String[] args){
        L686_RepeatedStringMatch l686=new L686_RepeatedStringMatch();
       /* String A="abcd";
        String B="cdabcdab";*/
        //Input
        //"abcbc"
        //"cabcbca"
        //Output
        //-1
        //Expected
        //3
        /*String A="abcbc";
        String B="cabcbca";*/
        //Input
        //"aaaaaaaaaaaaaaaaaaaaaab"
        //"ba"
        //Output
        //-1
        //Expected
        //2
        String A="aaaaaaaaaaaaaaaaaaaaaab";
        String B="ba";
        System.out.println(l686.repeatedStringMatch(A,B));
    }
}

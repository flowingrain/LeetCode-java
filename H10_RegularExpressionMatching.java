package LeetCode;

public class H10_RegularExpressionMatching {
    /*public boolean isMatch(String s, String p) {
        return s.matches(p);
    }*/
    public boolean isMatch(String s, String p) {
        //corner case
        if(s==null||p==null)
            return false;
        int m=s.length();
        int n=p.length();
        //M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
        boolean[][] dp=new boolean[m+1][n+1];//所以这里的i j对应的不是字符串当前i，j的下标？这里的i j是从1开始的？
        // initialization:
        // 1. M[0][0] = true, since empty string matches empty pattern
        dp[0][0]=true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
        // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P,
        // and for this case we need to check manually:
        // as we can see, the length of pattern should be even && the character at the even position should be *,
        // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2.
        // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time
        // for checking if it matches #*#*#*#*.
        for(int j=2;j<=n;j++){
            if(p.charAt(j-1)=='*'&&dp[0][j-2]){
                dp[0][j]=true;
            }
        }

        // Induction rule is very similar to edit distance, where we also consider from the end. And it is based on what character in the pattern we meet.
        // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
        //    ######a(i)
        //    ####a(j)
        // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
        // 	  #######a(i)
        //    ####.(j)
        // 3. if p.charAt(j) == '*':
        //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
        //       #####a(i)
        //       ####b*(j)
        //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
        //       ######a(i)
        //       ####.*(j)
        //
        // 	  	 #####a(i)
        //    	 ###a*(j)
        //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
        //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
        //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

        // recap:
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i - 1][j - 2]
        // M[i][j] = M[i - 1][j]
        // Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we need to compute them first.
        // which determines i goes from 1 to m - 1, j goes from 1 to n + 1
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.')//前面匹配，当前一样，则当前匹配
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.'){//两种情况都可以在当前位的*复制后匹配到当前位
                        dp[i][j]=dp[i][j-2];
                    }else//(p.charAt(j)==s.charAt(i+1)||p.charAt(j)=='.')
                    {
                        dp[i][j]=(dp[i-1][j]||dp[i][j-1]||dp[i][j-2]);
                    }
                }//else
                   // return false;
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args){
        H10_RegularExpressionMatching h10=new H10_RegularExpressionMatching();
        String s1="aa",p1="a";
        System.out.println(h10.isMatch(s1,p1));
        String s2="aa",p2="a*";
        System.out.println(h10.isMatch(s2,p2));
        String s3="ab",p3=".*";
        System.out.println(h10.isMatch(s3,p3));
        String s4="aab",p4="c*a*b";
        System.out.println(h10.isMatch(s4,p4));
        String s5="mississippi",p5="mis*is*p*.";
        System.out.println(h10.isMatch(s5,p5));
    }
}
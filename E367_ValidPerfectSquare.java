package LeetCode;

public class E367_ValidPerfectSquare {
    /*public boolean isPerfectSquare(int num) {
        int square;
        int maxSqrt=46340;
        //int maxPerfectSquare=maxSqrt*maxSqrt;//int型的最大完全平方数
        //System.out.println(maxPerfectSquare);
        if(num>maxSqrt&&num>maxSqrt*maxSqrt)
            return false;
        int low=1,high=maxSqrt;
        while(low<=high){
            int mid=high-(high-low)/2;
            //System.out.println(mid);
            square=mid*mid;
            //System.out.println(square);
            if(square==num)
            {
                return true;
            }else if(square>num){
                //System.out.println(">");
                high=mid-1;
            }else {
                //System.out.println("<");
                low=mid+1;
            }
        }
        return false;
    }*/
    /*牛顿法
    https://leetcode.com/problems/valid-perfect-square/discuss/83907/3-4-short-lines-Integer-Newton-Most-Languages
    */
    public boolean isPerfectSquare(int num) {
        long sqrt=num;
        while(sqrt*sqrt>num)
        {
            sqrt=(sqrt+num/sqrt)/2;
        }
        return sqrt*sqrt==num;
    }
    public static void main(String[] args){
        E367_ValidPerfectSquare e367=new E367_ValidPerfectSquare();
        int num=2147483647;
        //int num=808201;//答案，true。平方根899
        //System.out.println(Math.sqrt(num));
        //System.out.println(Math.sqrt(Integer.MAX_VALUE));
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Long.MAX_VALUE);
        System.out.println(e367.isPerfectSquare(num));
    }
}
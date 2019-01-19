package LeetCode;

public class L204_CountPrimes {
    public int countPrimes(int n){
        if(n<2)
            return 0;
        int count=0;
        boolean[] notPrime=new boolean[n];//notPrime即是非素数。默认赋值为false，如此定义可以不用初始化
        for(int i=2;i<Math.sqrt(n);i++){
            if(!notPrime[i])//i是素数
            {
                for(int j=i;i*j<n;j++)//能保证覆盖所有合数吗？合数的重复赋值有多少？
                    notPrime[i*j]=true;
            }
        }
        for(int i=2;i<n;i++)
        {
            if(!notPrime[i]){//素数
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        L204_CountPrimes l204=new L204_CountPrimes();
        int input=10;
        System.out.println(l204.countPrimes(input));
    }
}
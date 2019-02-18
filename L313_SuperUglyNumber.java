package LeetCode;

public class L313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {//参照264题解法
        int[] uglyNums=new int[n];
        int primeLen=primes.length;
        int[] indexs=new int[primeLen];
        int[] temps=new int[primeLen];
        for(int i=0;i<primeLen;i++){
            indexs[i]=0;
            temps[i]=primes[i];
        }
        uglyNums[0]=1;
        for(int i=1;i<n;i++)
            uglyNums[i]=Integer.MAX_VALUE;
        int last;
        for(int i=1;i<n;i++){
            last=uglyNums[i-1];
            for(int j=0;j<primeLen;j++){
                if(last==temps[j])
                    temps[j]=primes[j]*uglyNums[++indexs[j]];
                if(uglyNums[i]>temps[j])
                    uglyNums[i]=temps[j];
            }
        }
        return uglyNums[n-1];
    }
    public static void main(String[] args){
        L313_SuperUglyNumber l313=new L313_SuperUglyNumber();
        int n=12;
        int[] primes={2,7,13,19};
        System.out.println(l313.nthSuperUglyNumber(n,primes));
    }
}
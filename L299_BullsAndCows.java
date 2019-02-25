package LeetCode;

public class L299_BullsAndCows {//公牛母牛游戏。求该如何提示
    public String getHint(String secret, String guess) {//使用桶
        //有多少在位置和大小上与给定字符串一致，bulls
        //有多少大小一致位置不同,cows
        char[] secretChar=secret.toCharArray(),guessChar=guess.toCharArray();
        int bulls=0,cows=0;
        int[] secretNums=new int[10];//存储包含各个数字的个数
        int[] guessNums=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secretChar[i]==guessChar[i]){
                bulls++;
            }else{
                secretNums[secretChar[i]-48]++;
                guessNums[guessChar[i]-48]++;
            }
        }
        for(int i=0;i<10;i++){
            cows+=Math.min(secretNums[i],guessNums[i]);
        }
        return bulls+"A"+cows+"B";
    }
    public static void main(String[]  args){
        L299_BullsAndCows l299=new L299_BullsAndCows();
        String secret = "1807", guess = "7810";
        //String secret = "7151535801", guess = "4604986377";
        //String secret="00112233445566778899",guess="16872590340158679432";
        System.out.println(l299.getHint(secret,guess));
    }
}
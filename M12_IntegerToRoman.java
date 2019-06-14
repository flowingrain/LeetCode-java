package LeetCode;

public class M12_IntegerToRoman {
    //https://leetcode.com/problems/integer-to-roman/discuss/6274/Simple-Solution
    public String intToRoman(int num) {//很暴力啊
        String[] M={"","M","MM","MMM"};
        String[] C={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//0 100
        String[] X={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//0 10 20 30...
        String[] I={"","I","II","III","IV","V","VI","VII","VIII","IX"};//0 1 2 3
        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
    }
    public static void main(String[] args){
        M12_IntegerToRoman m12=new M12_IntegerToRoman();
        int input=3;
        System.out.println(m12.intToRoman(input));
    }
}
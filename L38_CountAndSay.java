package LeetCode;

public class L38_CountAndSay {
    public String countAndSay(int n) {
        if(n<=0){
            return null;
        }
        String res="1";//第一行结果
        int len = 0;
        for(int i=1;i<n;i++){//第二行及以后
            int count=1;//数字出现次数
            if(i==1){//第二行
                res="11";
            }else {//不加else的计划，第二行有res，还会接着构建，第二行的res就会成为原本第三行展示的内容
                len = res.length();
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j < len; j++) {//统计每个字符出现次数
                    if (res.charAt(j - 1) == res.charAt(j)) {
                        count++;
                    } else {
                        sb.append(count);
                        sb.append(res.charAt(j - 1));
                        count = 1;
                    }
                }
                sb.append(count);
                sb.append(res.charAt(len - 1));
                res = sb.toString();
            }
        }
        return res;
    }
    public static void main(String[] args){
        L38_CountAndSay l38=new L38_CountAndSay();
        System.out.println(l38.countAndSay(4));
    }
}
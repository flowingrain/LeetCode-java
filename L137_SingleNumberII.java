package LeetCode;

//位操作
public class L137_SingleNumberII {
    /*public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++)//逐位对result进行设置
        {
            int sum=0;
            for(int j=0;j<nums.length;j++){
                //如果这些数字的当前位为1，就用sum记录当前位为1的数目
                //如果是1向左平移i位，求且的结果就不等于1了
                sum+=(nums[j]>>i) &1;
            }
            result|=(sum%3)<<i;
        }
        return result;
    }*/
    /*
    我们想要达到的效果其实是——

　　　　　　　　　　  a  b

初始状态　　　　  ：   0   0

第一次碰见某个数x：   0   x（把x记录在b中）

第二次碰见某个数x：   x   0（把x记录在a中）

第三次碰见某个数x：   0   0（把a和b都清空，可以处理其他数）

还记得我们之前处理“所有元素都出现两次，只有一个特殊元素出现一次”的问题吗？其实我们那会想要达到的状态也是——

　　　　　　　　　　  a

初始状态　　　　  ：   0

第一次碰见某个数x：   x(把x记录在a中）

第二次碰见某个数x：   0(把a清空）

然后我们刚好就找到了异或运算可以处理这个问题。

那么这次我们同样利用异或运算，看能不能设计出一种变换的方法让a和b按照上述变换规则，进行转换。

b=0时碰到x，就变成x；b=x时再碰到x，就变成0，这个不就是异或吗？所以我们也许可以设计b=b xor x。

但是当b=0时再再碰到x，这时候b还是要为0，但这时候不同的是a=x，而前两种情况都是a=0。所以我们可以设计成：b=(b xor x)&~a

同样道理，我们可以设计出：a=(a xor x)&~b

在这种变换规则下，a和b都能按照我们设定的状态来发生转化。最后那个只出现一次的元素必定存储在b中。
     */
    public int singleNumber(int[] nums) {
        int a =0;
        int b =0;
        for(int i=0;i<nums.length;i++){
            b = b ^ nums[i] & ~a;
            a = a ^ nums[i] & ~b;
        }
        return a|b;
    }
    public static void main(String[] args){
        L137_SingleNumberII l137=new L137_SingleNumberII();
        int[] nums={0,1,0,1,0,1,99};
        System.out.println(l137.singleNumber(nums));
    }
}

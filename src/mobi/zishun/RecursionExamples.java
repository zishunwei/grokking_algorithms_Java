package mobi.zishun;

public class RecursionExamples {
    //从大到小依次打印整数到0为止
    private static void countDown(int i) {
        System.out.println(i);
        if (i > 0) {
            countDown(i - 1);
        }
    }

    //阶乘函数
    private static int factorial(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public static void main(String[] args) {
        countDown(3);
        System.out.println(".............");
        System.out.println(factorial(4));
    }
}

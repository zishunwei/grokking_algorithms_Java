package mobi.zishun;

// 欧几里得算法：求两个数字的最大公约数 (辗转相除法)
// 现实场景：给一个矩形（长度和宽度），要将其均匀分为多个正方形，求适用的最大正方形大小（边长）
public class EuclideanAlgorithm {
    private static int euclideanAlgorithm(int length, int width) {
        if (length < width) {
            int temp = length;
            length = width;
            width = temp;
        }
        if (length % width == 0) {
            return width;
        } else {
            return euclideanAlgorithm(length % width, width);
        }
    }

    public static void main(String[] args) {
        System.out.println(euclideanAlgorithm(640, 1440));
    }

}

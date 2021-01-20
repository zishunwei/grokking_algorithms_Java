package mobi.zishun;

public class ForLoopTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr = new int[arr.length - 1];
            System.out.println(i); //0,1,2,3,4
            System.out.println("arr length: " + arr.length); //0,1,2,3,4
        }
    }
}

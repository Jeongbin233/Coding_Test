import java.math.BigInteger;
import java.util.Scanner;

public class Main_BJ_1271_엄청난부자2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bigNum1 = new BigInteger(sc.next());
        BigInteger bigNum2 = new BigInteger(sc.next());

        System.out.println(bigNum1.divide(bigNum2));
        System.out.println(bigNum1.remainder(bigNum2));

    }//main
}

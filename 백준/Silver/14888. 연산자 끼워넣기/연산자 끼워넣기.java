import java.util.Scanner;

public class Main {
    static int[] operator = new int[4]; //+ - * /
    static int[] arr;
    static int n, max, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for(int i=0; i<4; i++)
            operator[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        result(arr[0], 1);
        System.out.println(max);
        System.out.println(min);


    }//main
    private static void result(int num, int idx){
        if(idx == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i] >0){
                operator[i]--;
                switch (i){
                    case 0:
                        result(num+arr[idx], idx+1);
                        break;
                    case 1:
                        result(num-arr[idx], idx+1);
                        break;
                    case 2:
                        result(num*arr[idx], idx+1);
                        break;
                    case 3:
                        result(num/arr[idx], idx+1);
                        break;
                }
                operator[i]++;
            }
        }
    }//result
}

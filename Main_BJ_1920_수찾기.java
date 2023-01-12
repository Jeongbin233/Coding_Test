import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1920_수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        // 이분 탐색 위한 정렬
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] find = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            find[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++) {
            //binary Search
            int low = 0;
            int high = n-1;
            int mid = 0;
            int key = find[i];
            boolean flag = false; // 탐색 성공
            while (low <= high) {
                mid = (low + high) / 2;

                if(key == arr[mid]) {
                    System.out.println(1);
                    flag = true;
                    break;
                }
                else if(key < arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }//while
            if(!flag){
                System.out.println(0);
            }

        }//for

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] sw = new int [n];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		for(int i =0; i<n; i++) {
			sw[i]=Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine());
		for(int i =0; i<students; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());	
			//System.out.println(sex + " " + num);
			
			if (sex == 1) {// ��
				for(int j = num-1; j<sw.length; j=j+num) {
					if (sw[j]==1) {
						sw[j]=0;
					}
					else {
						sw[j]=1;
					}
				}
			}
			
			else {//��
				// ���� �� �� ������(����)
				int left = num;
				int right = n-num-1;
				sw[num-1] = Math.abs(sw[num-1]-1);//������� �ٲٱ�
				
				if(left > right) {
					for(left = num-2, right=num; right<n; left--, right++) {
						if(sw[left] == sw[right]) {
							sw[left] = Math.abs(sw[left]-1);
							sw[right] = Math.abs(sw[right]-1);
						}
						else {
							break;
						}
						
					}
				}
				else {
					for(left = num-2, right=num; left>=0; left--, right++) {
						if(sw[left] == sw[right]) {
							sw[left] = Math.abs(sw[left]-1);
							sw[right] = Math.abs(sw[right]-1);
						}
						else {
							break;
						}
						
					}
				}
				
			}
			
		}
		//20���� ���
		for(int i = 0; i<sw.length; i++) {
			//System.out.println(Arrays.toString(sw));
			if(i!= 0 && i % 20 == 0) {
				System.out.println();
			}
            if(i%20 != 0){
                System.out.print(" ");
            }
            System.out.print(sw[i]);
		}

	}

}
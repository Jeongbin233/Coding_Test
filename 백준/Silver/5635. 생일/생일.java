import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Info> students = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Info info = new Info(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            students.add(info);
        }
        Collections.sort(students);
        StringBuilder sb = new StringBuilder();
        System.out.println(students.get(n-1).name);
        System.out.println(students.get(0).name);
    }

    static class Info implements Comparable<Info>{
       private String name;
       private int dd;
       private int mm;
       private int yyyy;

       public Info(String name, int dd, int mm, int yyyy){
           this.name = name;
           this.dd = dd;
           this.mm = mm;
           this.yyyy = yyyy;
       }

       @Override
       public int compareTo(Info info){
           if(info.yyyy < yyyy)
               return 1;
           else if(info.yyyy > yyyy)
               return -1;
           else {
               if(info.mm < mm)
                   return 1;
               else if(info.mm > mm)
                   return -1;
               else {
                   if(info.dd < dd)
                       return 1;
                   else
                       return -1;
               }
           }
       }
    }
}

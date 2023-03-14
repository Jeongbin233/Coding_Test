import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class person{
        int age;
        String name;
        int order;

        public person(int age, String name, int order){
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<person> pq = new PriorityQueue<>(new Comparator<person>() {
            @Override
            public int compare(person o1, person o2) {
                if(o1.age == o2.age)
                    return o1.order - o2.order;
                else
                    return o1.age - o2.age;
            }
        });
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            pq.offer(new person(num, name, i));
        }
        for(int i=0; i<n; i++){
            person person = pq.poll();
            System.out.println(person.age + " " + person.name);
        }

    }
}

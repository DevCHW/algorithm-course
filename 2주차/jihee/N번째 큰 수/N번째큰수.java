import java.util.*;
public class N번째큰수 {
    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                pq.offer(sc.nextInt());
            }
        }

        System.out.println(solution(n, pq));
    }

    public static int solution(int n, PriorityQueue<Integer> pq){

        for(int i=0; i<n-1; i++){
            pq.poll();
        }

        return pq.poll();
    }
}

import java.util.*;

public class Main {
    static int node;
    static int line;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        line = sc.nextInt();

        arr = new int[node+1][node+1];

        for(int i=1; i<=line; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1][node2] = 1;
            arr[node2][node1] = 1;

        }
        System.out.println(solution());
        
    }

    private static int solution(){
        int answer = 0;
        visited = new boolean[node+1];
        Queue<Integer> queue = new LinkedList<>();

        //1번 컴퓨터부터 시작
        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            for(int i=1; i<=node; i++){
                if(arr[currentNode][i] == 1){
                    if(!visited[i]){
                        visited[i] = true;
                        queue.add(i);
                        answer++;
                    }
                }
            }
        }

        return answer;

    }
}

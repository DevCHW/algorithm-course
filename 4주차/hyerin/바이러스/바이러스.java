import java.util.*;

public class 바이러스_2606 {

    public static boolean[] visited;
    public static int N;
    public static int M;
    public static int[][] arr;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 컴퓨터의 개수
        M = sc.nextInt(); // 연결되어있는 개수

        arr = new int[N+1][N+1]; // 컴퓨터 arr

        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
            arr[y][x] = 1; //양방향 연결
        }

        visited = new boolean[N+1];

        DFS(1);
        System.out.println(count);
    }

    public static void DFS(int start){
        visited[start] = true; // 방문 체크

        for(int i=1; i<=N; i++){
            if(arr[start][i] == 1 && !visited[i]){
                count++;
                DFS(i);
            }
        }

    }


}

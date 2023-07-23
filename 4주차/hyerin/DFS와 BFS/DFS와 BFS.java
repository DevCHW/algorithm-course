import java.util.*;

public class DFS와BFS_1260 {

    public static boolean[] visited;
    public static int N;
    public static int M;
    public static int[][] arr;
    public static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        solution(V);

    }

    public static void solution(int start){
        // 초기화
        sb = new StringBuilder();
        visited = new boolean[N+1];

        // 탐색 시작
        visited[start] = true;
        sb.append(start).append(" ");

        DFS(start); // DFS
        sb.append("\n");

        // 초기화
        visited = new boolean[N+1];

        // 탐색 시작
        visited[start] = true;
        sb.append(start).append(" ");

        BFS(start); //BFS
        System.out.println(sb);
    }

    public static void DFS(int start){

        for(int i=1; i<=N; i++){
            if(arr[start][i] == 1) { // 연결되어 있고
                if(!visited[i]){ // 방문하지 않은 경우
                    visited[i] = true; // 방문처리
                    sb.append(i).append(" ");
                    DFS(i);
                }
            }
        }

    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 큐에 넣어주기
        while(!queue.isEmpty()){ // 큐가 빌때까지 반복하기
            int curNode = queue.poll();

            // 연결정보 탐색
            for(int i=1; i<=N; i++){
                if(arr[curNode][i] == 1) {// 연결되어 있고
                    if(!visited[i]){ // 방문하지 않은 경우
                        queue.add(i); // 큐에 넣기
                        visited[i] = true;
                        sb.append(i).append(" ");
                    }
                }
            }

        }


    }


}

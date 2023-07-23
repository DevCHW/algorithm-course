import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {

    static int N;
    static int M;
    static int arr[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // x방향 배열
    static int[] dy = {0, 0, -1, 1}; // y방향 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 가로행
        M = sc.nextInt(); // 세로행

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];

        System.out.println(BFS(0,0, N-1, M-1));
    }

    public static int BFS(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()){

            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            if(x == endX && y == endY){
                return arr[x][y];
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위 벗어나거나, 벽이거나, 이미 방문한곳 제외
                if( nx< 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || visited[nx][ny]){
                    continue;
                }

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y] + 1; //최단거리 기록

            }
        }
        return -1; // 도착점에 도달할 수 없는 경우
    }
}

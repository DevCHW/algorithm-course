import java.util.*;
public class Main {

    // 위치클래스 선언
    static class Position {
        int x;
        int y;

        Position(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 방향벡터 정의.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t > 0) {
            int m = sc.nextInt();   //가로길이 (1 <= m <= 50)
            int n = sc.nextInt();   //세로길이 (1 <= n <= 50)
            int k = sc.nextInt();   //배추가 심어져 있는 위치의 개수(1 <=k <= 2500)

            int[][] graph = new int[n][m];

            for(int i=0; i<k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[b][a] = 1;
            }

            sb.append(solution(n, m, k, graph)).append("\n");

            t--;
        }

        System.out.print(sb);
    }

    private static int solution(int n, int m, int k, int[][] graph) {
        int answer = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    bfs(n, m, graph, visited, i, j);
                }
            }
        }
        return answer;
    }

    private static void bfs(int n, int m, int[][] graph, boolean[][] visited, int x, int y) {
        Queue<Position> queue = new LinkedList<>();

        // 시작위치 큐에 삽입, 방문처리
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                // 범위내에 있고, 방문하지 않고, 배추가 심어져있는곳이라면
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny]
                    && graph[nx][ny] == 1 ) {

                    visited[nx][ny] = true; // 방문처리
                    queue.offer(new Position(nx, ny));
                }
            }
        }
    }
}
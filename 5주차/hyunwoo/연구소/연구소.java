import java.util.*;
public class Main {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static int[][] graph;
    static int n;
    static int m;
    static Queue<Position> queueTmp = new LinkedList<>();
    static int tmp; //안전영역 최댓값 갱신할 변수

    // 방향벡터 정의
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) queueTmp.offer(new Position(i, j));
            }
        }

        solution();
        System.out.println(tmp);
    }

    private static void solution() {
        dfs(0);
    }

    /**
     * 바이러스 퍼트리기
     */
    private static int bfs() {
        int count = 0;

        Queue<Position> queue = new LinkedList<>();
        visited = new boolean[n][m];
        for(Position p : queueTmp) queue.offer(p);

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = pos.x+dx[i];
                int ny = pos.y+dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) count++;
            }
        }

        return count;
    }


    /**
     * 벽 세워보기
     */
    private static void dfs(int depth) {
        if (depth == 3) {   // 벽 3개까지 세우면 bfs 호출
            int count = bfs();  //안전영역 갯수 return 받는다.
            tmp = Math.max(count, tmp);
        } else {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if (graph[i][j] == 0) { //빈공간 이라면
                        graph[i][j] = 1;

                        dfs(depth + 1);

                        graph[i][j] = 0;
                    }
                }
            }
        }
    }
}
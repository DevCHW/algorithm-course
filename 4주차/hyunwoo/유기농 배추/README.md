## Info
<a href="https://www.acmicpc.net/problem/1012" rel="nofollow">유기농 배추</a>

## 풀이 코드
```java
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
```

## ❗ 풀이 방법
문제의 지문이 길어서 약간 헷갈릴 수는 있으나, 섬의 개수 문제와 똑같이 풀면 된다.

먼저 테스트 케이스의 갯수만큼 입력을 받고 `solution` 메소드를 호출한다.

`solution` 메소드에서는 그래프를 탐색하면서, 한번도 방문하지 않은 배추가 심어져있는 위치를 만나면 answer를 카운팅하고, bfs를 호출하여 인접한 배추들을 전부 방문처리해준다.

탐색이 끝난다면 answer가 곧 필요한 최소 배추흰지렁이의 수 이므로, answer를 return하여 출력한다.

## 🙂 새로 알게된 점
* 섬의 개수 문제와 같이 풀면 된다. DFS탐색으로 풀고싶다면 visited 배열을 전역변수로 빼준 뒤 초기화를 solution에서 진행하고, 아래의 코드를 추가하여 bfs 메소드 대신 dfs 메소드를 호출해주면 된다.


```java
private static void dfs(int n, int m, int[][] graph, int x, int y) {
    visited[x][y] = true; // 방문처리
    for(int i=0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 범위내에 있고, 방문하지 않고, 배추가 심어져있는곳이라면
        if(nx >= 0 && nx < n && ny >= 0 && ny < m
                && !visited[nx][ny]
                && graph[nx][ny] == 1 ) {
            dfs(n, m, graph, nx, ny);
        }
    }
}
```


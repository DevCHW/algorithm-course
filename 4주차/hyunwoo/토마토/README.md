## Info
<a href="https://www.acmicpc.net/problem/7576" rel="nofollow">토마토</a>

## 풀이 코드
```java
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

    // BFS 탐색을 위한 queue 선언
    static Queue<Position> queue = new LinkedList<>();

    // 방향벡터 정의
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        // 1은 익은토마토, 0은 익지않은 토마토, -1은 토마토가 들어있지 않은 칸
        int[][] graph = new int[n][m];

        List<Position> tomatoPositionList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();

                if(graph[i][j] == 1) queue.offer(new Position(i, j));
            }
        }

        System.out.println(solution(n, m, graph));
    }
    private static int solution(int n, int m, int[][] graph) {
        int[][] visited = new int[n][m];

        // 저장될 때부터 모든 토마토가 익어있는 상태라면 0 return
        if(queue.size() == (n*m)) return 0;

        bfs(n, m, graph, visited);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0 && visited[i][j] == 0) return -1; // 안익은 토마토가 발견된다면 -1 return
                max = Math.max(max, visited[i][j]);
            }
        }

        int answer = max; //이미 익은 토마토 날짜 빼기
        return answer;
    }

    private static void bfs(int n, int m, int[][] graph, int[][] visited) {
        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                // 벙위내에 있고, 방문하지 않은, 안익은 토마토라면
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                        && visited[nx][ny] == 0
                        && graph[nx][ny] == 0) {

                    // 토마토 익는 날짜 기록, 방문처리
                    visited[nx][ny] = visited[pos.x][pos.y] + 1;

                    graph[nx][ny] = 1;

                    queue.offer(new Position(nx, ny));
                }
            }
        }
    }
}
```

## ❗ 풀이 방법
위치 클래스 `Position`를 정의하고, BFS 탐색을 위한 `Queue`, 방향벡터 `int[] dx`, `int[] dy`를 전역변수로 선언한다.

입력을 받을 때, 익은 토마토의 위치를 전역변수 queue에 삽입해준다. 그리고 입력받은 값을 n, m, graph를 `solution` 메소드에 매개변수로 넘겨준다.

만약, queue의 size()가 창고의 크기(n*m) 과 같다면 입력받은 순간부터 모든 토마토가 익어있다는 뜻이므로 0을 return한다.

```java
if(queue.size() == (n*m)) return 0;
```

아니라면 bfs 탐색하여 토마토를 익히는 시뮬레이션을 한다.
```java
private static void bfs(int n, int m, int[][] graph, int[][] visited) {
    while(!queue.isEmpty()) {
        Position pos = queue.poll();

        for(int i=0; i<4; i++) {
            int nx = pos.x + dx[i];
            int ny = pos.y + dy[i];

            // 벙위내에 있고, 방문하지 않은, 안익은 토마토라면
            if(nx >= 0 && nx < n && ny >= 0 && ny < m
                    && visited[nx][ny] == 0
                    && graph[nx][ny] == 0) {

                // 토마토 익는 날짜 기록, 방문처리
                visited[nx][ny] = visited[pos.x][pos.y] + 1;

                // 토마토 익히기
                graph[nx][ny] = 1;

                queue.offer(new Position(nx, ny));
            }
        }
    }
}
```

현재 queue에는 초기에 익은 토마토들이 들어있으므로, 익은 토마토들의 상,하,좌,우를 살펴본다음 visited 배열에 현재 위치에서 +1 한 값을 기록하면서 토마토를 익힌다.

## 🙂 새로 알게된 점
* bfs 탐색하며 토마토를 익히는 것을 머릿속에서 시뮬레이션 할 수 있다면 쉽게 풀어낼 수 있는 문제이다.


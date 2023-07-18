## Info
<a href="https://www.acmicpc.net/problem/2178" rel="nofollow">미로 탐색</a>

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();;
        int m = sc.nextInt();;
        int[][] graph = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String tmp = sc.next();
            for(int j=1; j<=m; j++) {
                graph[i][j] = tmp.charAt(j-1)-'0';
            }
        }

        System.out.println(solution(n, m, graph));
    }

    private static int solution(int n, int m, int[][] graph) {
        int answer = bfs(n, m, graph);
        return answer;
    }

    private static int bfs(int n, int m, int[][] graph) {
        int[][] visited = new int[n+1][m+1];

        Queue<Position> queue = new LinkedList<>();

        //시작위치 삽입, 방문처리
        queue.offer(new Position(1, 1));
        visited[1][1] = 1;

        // 방향벡터 정의
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m
                        && visited[nx][ny] == 0
                        && graph[nx][ny] == 1) {

                    // 현재위치 + 1 한 것을 방문배열에 넣기
                    visited[nx][ny] = visited[pos.x][pos.y] + 1;

                    queue.offer(new Position(nx, ny));
                }
            }
        }
        return visited[n][m];
    }
}
```

## ❗ 풀이 방법
```java
static class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```
위치 클래스를 만들어둔다.


```java
private static int bfs(int n, int m, int[][] graph) {
    int[][] visited = new int[n+1][m+1];

    Queue<Position> queue = new LinkedList<>();

    //시작위치 삽입, 방문처리
    queue.offer(new Position(1, 1));
    visited[1][1] = 1;

    // 방향벡터 정의
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    while(!queue.isEmpty()) {
        Position pos = queue.poll();

        for(int i=0; i<4; i++) {
            int nx = pos.x + dx[i];
            int ny = pos.y + dy[i];

            if(nx >= 1 && nx <= n && ny >= 1 && ny <= m
                    && visited[nx][ny] == 0
                    && graph[nx][ny] == 1) {

                // 현재위치 + 1 한 것을 방문배열에 넣기
                visited[nx][ny] = visited[pos.x][pos.y] + 1;

                queue.offer(new Position(nx, ny));
            }
        }
    }
    return visited[n][m];
}
```
그래프를 (1,1)부터 상하좌우로 bfs탐색하여 범위내에 있고, 방문하지 않고 갈 수 있는 위치를 visited에 거리를 기록한다.

bfs탐색이 끝나면 시작위치(1, 1) 부터 도착지점(n, m) 까지의 거리가 visited[n][m] 에 기록되기 때문에 visited[n][m]을 return하여 출력한다.

## 🙂 새로 알게된 점
* visited 배열을 단순히 방문처리만 하는것이 아닌 거리를 기록하는 용도로도 활용할 수 있다는 점을 이용하면 쉽게 풀 수 있는 문제이다.


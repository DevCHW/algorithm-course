## Info
<a href="https://www.acmicpc.net/problem/14502" rel="nofollow">연구소</a>


## ❗ 풀이 방법
문제가 복잡한 만큼 로직을 나눠서 생각한 뒤, 구현해주는 것이 좋다.  
문제를 읽어보면 다음의 세가지 로직이 필요한 것을 깨달을 수 있다.

1. 벽을 세워보는 로직
2. 바이러스를 퍼트리는 로직
3. 안전영역의 갯수를 세는 로직

이렇게 정리가 되었다면, 다음은 위 세가지 로직을 어떻게 구현할 지 생각해보아야 한다.

### 벽을 세워보는 로직
모든 조합수를 따져보아야 하니 백트래킹으로 벽을 세워보고 허물어보고 하는식으로 하는것이 적절하지 않을까? 따라서 벽을 3개까지 세워보고 다음의 로직들을 호출한 뒤, 백트래킹으로 벽을 허물어주면 될 것 같다.

### 바이러스를 퍼트리는 로직
넓게 무엇인가 퍼트린다? 직관적으로 BFS가 떠오른다.

### 안전영역의 갯수를 세는 로직
이것은 따로 생각할 필요 없이 2중 반복문으로 안전영역의 갯수를 카운팅 해주면 될 것 같다는 느낌이 든다.


위와 같이 로직을 나누고, 어떻게 구현할 지 정했으니 순서대로 구현해보자.

```java
static class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

static int[][] graph;
static int n;
static int m;
static Queue<Position> queueTmp = new LinkedList<>();

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

    dfs(0);
}
```

먼저 문제에서 주어진 대로 충실하게 n, m, graph를 입력받고 모두 전역변수로 빼주었다.  

여기서 중요한 것이, 맨 처음 바이러스의 위치는 변함이 없고, 처음 바이러스의 위치들 부터 bfs로 바이러스를 퍼트려야 하기 때문에 전역변수 `queueTmp` 에 바이러스의 위치를 입력과 동시에 기록해두었다.

그다음 `dfs(0)`을 호출하였는데 매개변수는 depth를 뜻하고, 벽을 하나 세울 때 마다 재귀호출을 하면서 depth를 늘려나가고, depth가 3이 되었을 때 **바이러스를 퍼트리는 로직(bfs)** 를 호출하기로 하자.


```java
static int tmp; //안전영역 최댓값 갱신할 변수
/**
 * 벽 세워보기
 */
private static void dfs(int depth) {
    if (depth == 3) {   // 벽 3개까지 세우면 bfs 호출
        int count = bfs();  //안전영역의 갯수를 return 받는다.
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
```

dfs로 벽을 세워보는 로직이다. depth가 3이 되었을 때 bfs를 호출하고 안전영역의 갯수를 return받아 전역변수 tmp에 안전영역의 최댓값을 갱신해주도록 하였다.

depth가 3이 안되었다면, graph를 탐색하면서 빈공간을 찾았을 때 벽으로 만들어주고 재귀가 종료되어서 복귀하였을 때 다시 0으로 만들어주도록 하였다(백트래킹)

이제 바이러스를 퍼트리는 로직(bfs)을 살펴보자.

```java
/**
 * 바이러스 퍼트리기
 */
// 방향벡터 정의
static int[] dx = {1, 0, -1, 0};
static int[] dy = {0, 1, 0, -1};

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
```

전역변수 `queueTmp` 에는 입력과 동시에 바이러스의 위치를 기록해두었다.
전역변수를 가지고 조작한다면 다음 bfs에서도 영향을 받기 때문에, 전역변수의 `queueTmp`를 새로 선언한 `queue`에 깊은복사를 해주어 해당 큐에서 bfs로 바이러스를 퍼트리는 로직을 작성해주었다.

필자는 바이러스를 퍼트리는 것이 끝난 뒤, 안전영역 갯수를 세는 것 까지 bfs 메소드에 포함 시켜서 return 해주었다.


위의 과정이 끝난다면, tmp에는 안전영역의 최댓값이 남게 될 것이다. 모든 코드를 합친다면 다음과 같다.


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

        dfs(0);
        System.out.println(tmp);
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
            int count = bfs();  //안전영역의 갯수를 return 받는다.
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
```


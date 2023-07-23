## Info
<a href="https://www.acmicpc.net/problem/2606" rel="nofollow">바이러스</a>

## 풀이 코드(DFS)
```java
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 개수
        m = sc.nextInt();   //간선의 개수
        graph = new int[n+1][n+1];  //연결정보
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        dfs(1, visited);

        for(boolean visit : visited) if (visit) answer++;
        
        return answer-1;    //1번컴퓨터 제외
    }

    private static void dfs(int computer, boolean[] visited) {
        for(int i=1; i<=n; i++) {
            if(graph[computer][i] == 1) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i, visited);
                }
            }
        }
    }
}
```

## 풀이코드 (BFS)
```java
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 개수
        m = sc.nextInt();   //간선의 개수
        graph = new int[n+1][n+1];  //연결정보
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.println(solution());
    }

    private static int solution() {
        return bfs(1);
    }

    private static int bfs(int start) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int computer = queue.poll();
            for(int i=1; i<=n; i++) {
                if (graph[computer][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        answer++;
                        queue.offer(i);
                    }
                }
            }
        }

        return answer;
    }
}
```

## ❗ 풀이 방법(DFS)
1번 컴퓨터부터 dfs를 시작하여 방문한 곳을 기록하면서 탐색한다.  
dfs가 끝난 뒤, 방문처리 된 컴퓨터의 갯수를 세어서 -1하여 return한다. (1번 컴퓨터는 제외되어야 하므로 -1)

## ❗ 풀이 방법(BFS)
1번 컴퓨터와 연결된 컴퓨터가 있다면 answer를 1씩 증가시키면서 bfs로 탐색한다.
bfs가 끝난 뒤 answer를 return한다.


## 🙂 새로 알게된 점

* DFS, BFS의 기본 개념으로 쉽게 풀 수 있는 문제이다. 다만 DFS문제를 BFS로도 풀어보고 BFS 문제를 DFS로 풀어보는 것에 의의를 두었다!


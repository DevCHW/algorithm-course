## Info
<a href="문제 주소" rel="nofollow">문제 이름</a>

## 풀이 코드
```java
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 개수
        m = sc.nextInt();   //간선의 개수
        int start = sc.nextInt();

        graph = new int[n+1][n+1];

        // 간선의 개수(연결정보의 개수)만큼 입력받기
        for(int i=0; i<m; i++) {
            int vtx1 = sc.nextInt();
            int vtx2 = sc.nextInt();

            graph[vtx1][vtx2] = 1;
            graph[vtx2][vtx1] = 1;
        }

        System.out.print(solution(start));
    }

    /**
     * dfs, bfs 풀이
     */
    private static StringBuilder solution(int start) {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[n+1];

        // DFS
        sb.append(start).append(" ");
        visited[start] = true;
        dfs(start, sb); //dfs 호출

        // BFS
        sb.append("\n");
        Arrays.fill(visited, false);
        sb.append(start).append(" ");
        bfs(start, sb); //bfs 호출

        return sb;
    }

    private static void dfs(int vertex, StringBuilder sb) {
        for(int i=1; i<=n; i++) {
            if (graph[vertex][i] == 1) { //연결되어 있다면
                if (!visited[i]) { //방문하지 않았다면
                    visited[i] = true;  //방문처리
                    sb.append(i).append(" ");   //출력을 위한 append
                    dfs(i, sb);
                }
            }
        }
    }

    private static void bfs(int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        // 큐가 빌 때 까지 반복.
        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            for(int i=1; i<=n; i++) {
                if(graph[vertex][i] == 1) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.offer(i); 
                        sb.append(i).append(" "); //출력을 위한 append
                    }
                }
            }
        }
    }
}
```

## ❗ 풀이 방법
`StringBuilder`에 DFS로 탐색한 결과와 BFS로 탐색한 결과를 appned로 쌓아서 한번에 main함수에서 출력하였다.  
DFS는 재귀를 이용(메소드 스택프레임), BFS는 Queue 자료구조를 이용하여 풀이하였다.

## 🙂 새로 알게된 점

* 가장 기본적인 DFS, BFS 풀이이다.


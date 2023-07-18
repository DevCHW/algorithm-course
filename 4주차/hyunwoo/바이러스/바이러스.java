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
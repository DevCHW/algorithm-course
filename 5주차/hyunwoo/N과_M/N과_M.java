import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        solution();
        System.out.println(sb);
    }

    private static void solution() {
        boolean[] visited = new boolean[n+1];
        int[] arr = new int[m];

        dfs(0, arr, visited);
    }

    private static void dfs(int depth, int[] arr, boolean[] visited) {
        if(depth == m) {
            Arrays.stream(arr).forEach(x -> sb.append(x + " "));
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1, arr, visited);
                visited[i] = false;
            }
        }
    }
}

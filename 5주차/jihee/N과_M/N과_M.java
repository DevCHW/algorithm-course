import java.util.*;
public class Main {
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        solution();
        System.out.print(sb);
    }

    private static void solution(){
        visited = new boolean[n+1];
        arr = new int[m];
        dfs(0);
    }
    private static void dfs(int depth){
        if(depth == m){ //depth가 만들어야할 자리수와 같다면
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        else{
            for(int i=1; i<=n; i++){
                if(visited[i]) continue;
                visited[i] = true; //방문처리
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}

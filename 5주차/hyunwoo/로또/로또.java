import java.util.*;

public class Main {

    static int k;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            k = sc.nextInt();
            if (k == 0) break;
            arr = new int[k];
            for(int i=0; i<k; i++) {
                arr[i] = sc.nextInt();
            }

            solution();
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void solution() {
        visited = new boolean[k];
        dfs(0, "", 0);
    }

    private static void dfs(int depth, String tmp, int count) {
        if(depth == k) {
            if(count == 6) {
                sb.append(tmp).append("\n");
            }
        } else {
            dfs(depth+1, tmp+arr[depth]+ " ", count+1);
            dfs(depth+1, tmp, count);
        }
    }
}

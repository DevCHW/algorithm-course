import java.util.*;

public class Main {

    static int count;
    static String answer;
    static char[] arr;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();

            System.out.println(solution(str, n));
        }
    }

    private static String solution(String str, int n) {
        answer = null;
        flag = false;
        count = 0;
        arr = new char[str.length()];
        visited = new boolean[str.length()];

        dfs(0, str, n);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(" ").append(n).append(" = ");

        if(answer == null) return sb.append("No permutation").toString();
        else {
            return sb.append(answer).toString();
        }
    }

    private static void dfs(int depth, String str, int n) {
        if (flag) return;

        if (depth == str.length()) {
            count++;
            if(count == n) {
                answer = new String(arr);
                flag = true;
                return;
            }
            return;
        }
        for(int i=0; i<str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = str.charAt(i);
                dfs(depth+1, str, n);
                visited[i] = false;
            }
        }
    }

}

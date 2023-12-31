## Info
<a href="https://www.acmicpc.net/problem/15649" rel="nofollow">N과 M</a>

## 풀이 코드
```java
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

```

## ❗ 풀이 방법
visited로 1부터 N까지의 사용을 체크하면서 재귀호출하여 arr에 순열을 만든다.

## 🙂 새로 알게된 점
* 전형적인 순열 문제이다. N+1크기의 visited 배열을 만들어서 체크를 해주고 풀어가면서 수를 만드는 것을 떠올릴 수 있다면 쉽게 재귀적으로 풀어낼 수 있다.


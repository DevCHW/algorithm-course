## Info
<a href="https://www.acmicpc.net/problem/6603" rel="nofollow">로또</a>


## 풀이 코드
```java
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

```

## ❗ 풀이 방법
재귀함수로 풀어냈다. 중요코드는 dfs()쪽만 보면되는데, depth를 1씩 늘려가면서 2가지의 경우의 수 현재 위치의 depth의 원소를 사용 했는지, 안했는지를 count에 표시하면서 재귀호출한다.

```java
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
```

위의 재귀함수는 depth를 배열의 원소인 k번까지 늘려가면서, 모든 경우의 수를 탐색할 것이다.  
그러면서 매개변수의 tmp에 arr[depth]를 포함한 경우라면 count를 1 증가시켜주고, 아닌 경우의 수에서는 count를 그대로 넘겨준다.

종료조건인 depth==k 에서는 count==6이라면(tmp에 6번 추가되었단 소리임) 전역변수 StringBuilder에 매개변수를 append()시켜준다.



## Info
<a href="https://www.acmicpc.net/problem/9663" rel="nofollow">N-Queen</a>

## ❗ 풀이 방법
대표적인 백트래킹 문제이다. 처음에 퀸의 위치를 1차원 배열에 기록하면서 백트래킹하는 아이디어를 떠올리지 못하여 2차원 배열의 체스판을 만든 뒤 모든 칸에 대하여 퀸을 놓아본 다음 퀸을 놓은 위치와 공격할 수 있는 위치를 방문처리하고, 카운팅한 다음 방문처리를 풀어주는 굉장히 수고스러운 로직을 구현하였는데 다른 사람의 풀이를 보고 해당 아이디어를 베껴와서 다시 풀었더니 쉽게 풀렸다..  

``` java
private static int[] arr;
private static int n;
private static int count;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n];
    dfs(0);
}
```
문제에서의 n을 입력받고, 1차원 배열 arr을 n의 크기로 초기화 시켜준 뒤 dfs를 호출하여 퀸을 놓을 수 있는 조합수를 백트래킹으로 카운팅 해줄 것이다.

```java
private static void dfs(int depth) {
    if (depth == n) {
        count++;
        return;
    }

    for(int i=0; i<n; i++) {
        // board[열] = 행
        arr[depth] = i;

        // 퀸을 놓을 수 있는 위치라면 재귀호출
        if (isPossible(depth)) {
            dfs(depth + 1);
        }
    }
}
```
퀸을 놓을 때 마다 재귀호출하면서, depth를 늘려나간다.
따라서 detph가 n이 되었다는 조건은 퀸을 n개만큼 놓은 가짓수 이므로, 전역변수 count를 1 증가시켜준다.

depth가 n만큼 늘어나지 않았다면 for문으로 행을 하나씩 늘려가면서 재귀호출을 해주어야 하는데,
위와 같이 구현할 수 있는 이유는 어차피 **같은 행에는 퀸을 놓을 수 없기 때문이다**

(i,depth) 좌표에 퀸을 놓을 수 있는지 `isPossible()` 메소드로 판별한 뒤, 놓을 수 있다면 재귀호출을 해준다.

```java
private static boolean isPossible(int col) {
    for(int i=0; i<col; i++) {
        //해당 열의 행과 i열의 행이 일치할 경우( 같은 행에 존재할 경우)
        if (arr[col] == arr[i]) return false;

        // 열의 차와 행의 차가 같을 경우 같은 대각선상에 놓여져 있는 경우임.
        if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
            return false;
        }
    }

    // 위의 검사를 통과하면 놓을 수 있는 위치.
    return true;
}
```
해당 문제의 핵심로직인 현재위치에 퀸을 놓을 수 있는가?를 판별하는 isPossible 메소드이다.
우리는 dfs에서 detph를 매개변수로 넘겨주었다. 이것은 열의 번호를 뜻하고, arr[col]은 우리가 임시로 놓아 본 퀸의 행 위치가 기록되어 있을 것이다.

따라서 arr[col]의 이전 원소들을 봤을 때 일치하는 원소가 없어야 한다.(같은 행에는 놓을 수 없으므로)

그다음에 대각선을 따져보아야 하는데, **열의 차와 행의 차가 같을 경우엔 같은 대각선에 놓여져 있는 경우다.**

따라서 `Math.abs(col - i) == Math.abs(arr[col] - arr[i])`가 true가 될 경우 같은 대각선상에 퀸이 위치하였다는 소리이므로, false를 return해준다.

for문을 무사히 빠져나왔다면 검사를 통과하였고 해당 위치에 퀸을 놓을 수 있으므로 true를 return한다.

위의 isPossible 메소드로 퀸을 하나씩 놓아가면서 백트래킹으로 가지를 치며 카운팅을 해준다면, 문제에서 요구하는 퀸을 놓는 방법의 수를 구할 수 있게 된다.


## 풀이 코드
```java
import java.util.*;
public class Main {
    private static int[] arr;
    private static int n;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            // board[행] = 열
            arr[depth] = i;

            // 퀸을 놓을 수 있는 위치라면 재귀호출
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for(int i=0; i<col; i++) {
            //해당 열의 행과 i열의 행이 일치할 경우( 같은 행에 존재할 경우)
            if (arr[col] == arr[i]) return false;

            // 열의 차와 행의 차가 같을 경우 같은 대각선상에 놓여져 있는 경우임.
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        // 위의 검사를 통과하면 놓을 수 있는 위치.
        return true;
    }
}

```
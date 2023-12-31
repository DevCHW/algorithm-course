## Info
<a href="https://www.acmicpc.net/problem/2075" rel="nofollow">N번째 큰 수</a>

## 풀이 코드
___

``` java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                pq.offer(arr[i][j]);
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = pq.poll();
        }
        return answer;
    }
}
```
<br>

## ❗ 풀이 방법
___
모든 수를 PriorityQueue에 넣고, n번만큼 priorityQueue에서 `poll()` 한 값을 찾아 출력하였다. 

<br>


## 🙂 새로 알게된 점
___
* 새로 알게된 점은 없고, 여러가지 풀이 방법이 있겠지만 PrioriryQueue를 사용하여 최대한 간단하게 구현하여 풀었다.


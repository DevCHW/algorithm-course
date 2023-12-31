## Info
<a href="https://www.acmicpc.net/problem/3085" rel="nofollow">사탕 게임</a>
## 풀이 코드
___
``` java
import java.util.*;

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];

        for(int i=0; i<n; i++) {
            String tmp = sc.next();
            for(int j=0; j<n; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char current_color = arr[i][j];
                int count = simulation(i, j, n, current_color);
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }

    /**
     * 자리바꾸기 시뮬레이션 돌리기
     */
    private static int simulation(int x, int y, int length, char current_color) {
        int result = 0;
        for(int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx >= 0 && nx < length && ny >= 0 && ny < length && current_color != arr[nx][ny]) {
                char next_color = arr[nx][ny];

                // 자리바꾸기
                arr[x][y] = next_color;
                arr[nx][ny] = current_color;

                // 갯수 세기
                int count = count(length);
                result = Math.max(result, count);

                // 자리 원상복구
                arr[x][y] = current_color;
                arr[nx][ny] = next_color;
            }
        }
        return result;
    }

    /**
     * 갯수 세기
     */
    private static int count(int length) {
        int max_count = 0;

        for(int i=0; i<length; i++) {
            char row = arr[i][0];
            char col = arr[0][i];
            int row_count = 1;
            int col_count = 1;

            for(int j=1; j<length; j++) {
                if(row == arr[i][j]) row_count++;
                else {
                    max_count = Math.max(max_count, row_count);
                    row = arr[i][j];
                    row_count = 1;
                }

                if(col == arr[j][i]) col_count++;
                else {
                    max_count = Math.max(max_count, col_count);
                    col = arr[j][i];
                    col_count = 1;
                }
            }
            max_count = Math.max(max_count, row_count);
            max_count = Math.max(max_count, col_count);
        }
        return max_count;
    }
}
```

<br>

## 아이디어
___
(3 ≤ N ≤ 50) 이라는 조건이 있기 때문에 부담없이 완전탐색으로 풀이하였다.

<br>

## ❗ 풀이 방법
___
- `count(int length)` : 2차원 배열을 탐색하여 행,열의 최대 먹을 수 있는 사탕개수를 카운트하는 메소드
- `simulation(int x, int y, int length, char current_color)` : 현재 위치에서 상하좌우를 확인한 뒤, 현재 색깔과 다르다면 자리를 바꾸고 먹을 수 있는 사탕의 갯수를 카운트한 뒤 다시 자리를 원상복귀 시키고 상,하,좌,우의 최대 먹을 수 있는 사탕 갯수를 return하는 메소드


1. `main()`에서 `int n`과 현재 사탕들의 상태판 `char[][] arr`을 입력받는다.
2. `solution()` 에서 2중 for문으로 `arr`의 모든 원소에 대하여 사탕 자리바꾸기 카운팅을 시뮬레이션한다.

<br>

## 🙂 후기
___
그냥 문제에서 주어진대로 열심히 구현하면 된다.  
처음에 `count()` 메소드를 연속적으로 같은색깔의 사탕을 카운팅해야하는데, 연속적이라는것을 빼먹고 구현하여서 많이 애를먹었다..  
문제를 꼼꼼하게 읽지 않고 풀이하여 구현하는데 꽤나 시간이 오래걸렸던 문제.


